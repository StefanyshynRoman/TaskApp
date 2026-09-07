package com.romanstefanyshyn.task.domain.dto;


import com.romanstefanyshyn.task.domain.entity.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateTaskRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
        @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
        String title,
        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
        @Nullable
        String description,
        @FutureOrPresent(message = ERROR_MESSAGE_DUEDATE_IN_FUTURE)
        @Nullable
        LocalDate duedate,
        @NotNull(message = ERROR_MESSAGE_PRIORITY_NOT_NULL)
        TaskPriority priority
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH =
            "Title must be less than 255 characters";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "Description must be less than 1000 characters";
    private static final String ERROR_MESSAGE_DUEDATE_IN_FUTURE =
            "Due date must be in the future";
    private static final String ERROR_MESSAGE_PRIORITY_NOT_NULL =
            "Priority must be provided";
}
