package com.example.tmsystem.dto;

import com.example.tmsystem.model.Task;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TaskDto(
        Integer id,
        String title,
        String description,
        StatusDto status,
        PriorityDto priority,
        LocalDateTime createdAt,
        Integer assignedTo,
        Integer createdBy
) {

}
