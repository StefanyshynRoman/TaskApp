package com.romanstefanyshyn.task.domain;


import com.romanstefanyshyn.task.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate duedate,
        TaskPriority priority
) {
}
