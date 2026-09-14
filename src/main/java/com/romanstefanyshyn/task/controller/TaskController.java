package com.romanstefanyshyn.task.controller;


import com.romanstefanyshyn.task.domain.CreateTaskRequest;
import com.romanstefanyshyn.task.domain.dto.CreateTaskRequestDto;
import com.romanstefanyshyn.task.domain.dto.TaskDto;
import com.romanstefanyshyn.task.domain.entity.Task;
import com.romanstefanyshyn.task.mapper.TaskMapper;
import com.romanstefanyshyn.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid
                                              @RequestBody
                                              CreateTaskRequestDto createTaskRequestDto) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto createTaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createTaskDto, HttpStatus.CREATED);
    }
}
