package com.learnleadgrow.taskapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TaskResponseDTO {
    private long taskId;
    private long userId;
    private String taskName;
}
