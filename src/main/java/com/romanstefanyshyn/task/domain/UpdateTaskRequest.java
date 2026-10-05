package com.romanstefanyshyn.task.domain;

import com.romanstefanyshyn.task.domain.entity.TaskPriority;
import com.romanstefanyshyn.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
                                  ) {


}
