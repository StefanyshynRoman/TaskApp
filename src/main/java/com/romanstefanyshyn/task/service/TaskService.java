package com.romanstefanyshyn.task.service;

import com.romanstefanyshyn.task.domain.CreateTaskRequest;
import com.romanstefanyshyn.task.domain.UpdateTaskRequest;
import com.romanstefanyshyn.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;


public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID id, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
