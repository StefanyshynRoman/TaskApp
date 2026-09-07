package com.romanstefanyshyn.task.domain.dto;

import com.romanstefanyshyn.task.domain.entity.TaskPriority;
import com.romanstefanyshyn.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String descriptions,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status

) {
}
