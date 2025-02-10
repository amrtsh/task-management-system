package com.example.tmsystem.dto;

import java.time.LocalDateTime;

public record TaskToCreateDto(
        String title,
        String description,
        StatusDto status,
        PriorityDto priority,
        Integer createdBy
) {}
