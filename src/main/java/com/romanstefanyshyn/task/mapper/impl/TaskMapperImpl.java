package com.romanstefanyshyn.task.mapper.impl;

import com.romanstefanyshyn.task.domain.CreateTaskRequest;
import com.romanstefanyshyn.task.domain.dto.CreateTaskRequestDto;
import com.romanstefanyshyn.task.domain.dto.TaskDto;
import com.romanstefanyshyn.task.domain.entity.Task;
import com.romanstefanyshyn.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.duedate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDuedate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
