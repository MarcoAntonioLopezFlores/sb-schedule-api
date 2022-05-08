package com.at.internship.schedule.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppointmentDto {
    private Integer id;
    private Integer contactId;
    private String time;
    private String subject;
}
