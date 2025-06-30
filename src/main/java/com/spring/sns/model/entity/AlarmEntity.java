package com.spring.sns.model.entity;

import com.spring.sns.model.AlarmArgs;
import com.spring.sns.model.AlarmType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "\"alarm\"", indexes = {
        @Index(name = "user_id_idx", columnList = "user_id")
})
@SQLDelete(sql = "UPDATE \"alarm\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class AlarmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private AlarmArgs args;

    @Enumerated(EnumType.STRING)
    private AlarmType alarmType;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        this.registeredAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static AlarmEntity of(UserEntity userEntity, AlarmType alarmType, AlarmArgs args) {
        AlarmEntity entity = new AlarmEntity();
        entity.setUser(userEntity);
        entity.setAlarmType(alarmType);
        entity.setArgs(args);
        return entity;
    }
}
