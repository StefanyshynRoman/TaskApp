package com.romanstefanyshyn.task.service;

import com.romanstefanyshyn.task.domain.CreateTaskRequest;
import com.romanstefanyshyn.task.domain.entity.Task;

import java.util.List;


public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();
}
