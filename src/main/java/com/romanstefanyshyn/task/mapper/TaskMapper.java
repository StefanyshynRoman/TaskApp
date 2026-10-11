package com.romanstefanyshyn.task.mapper;

import com.romanstefanyshyn.task.domain.CreateTaskRequest;
import com.romanstefanyshyn.task.domain.UpdateTaskRequest;
import com.romanstefanyshyn.task.domain.dto.CreateTaskRequestDto;
import com.romanstefanyshyn.task.domain.dto.TaskDto;
import com.romanstefanyshyn.task.domain.dto.UpdateTaskRequestDto;
import com.romanstefanyshyn.task.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
