package com.spring.sns.controller.response;

import com.spring.sns.model.Alarm;
import com.spring.sns.model.AlarmArgs;
import com.spring.sns.model.AlarmType;
import com.spring.sns.model.User;
import com.spring.sns.model.entity.AlarmEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
public class AlarmResponse {
    private Integer id;
    private AlarmType alarmType;
    private AlarmArgs args;
    private String text;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static AlarmResponse fromAlarm(Alarm alarm) {
        return new AlarmResponse(
                alarm.getId(),
                alarm.getAlarmType(),
                alarm.getAlarmArgs(),
                alarm.getAlarmType().getAlarmText(),
                alarm.getRegisteredAt(),
                alarm.getUpdatedAt(),
                alarm.getDeletedAt()
        );
    }

}
