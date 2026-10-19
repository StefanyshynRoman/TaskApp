package com.romanstefanyshyn.task.service.impl;

import com.romanstefanyshyn.task.domain.CreateTaskRequest;
import com.romanstefanyshyn.task.domain.UpdateTaskRequest;
import com.romanstefanyshyn.task.domain.entity.Task;
import com.romanstefanyshyn.task.domain.entity.TaskStatus;
import com.romanstefanyshyn.task.exception.TaskNotFoundException;
import com.romanstefanyshyn.task.repository.TaskRepository;
import com.romanstefanyshyn.task.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.duedate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest request) {
    Task task= taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));

    task.setTitle(request.title());
    task.setDescription(request.description());
    task.setDueDate(request.dueDate());
    task.setStatus(request.status());
    task.setPriority(request.priority());
    task.setUpdated(Instant.now());

   return taskRepository.save(task);


    }

    @Override
    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }
}
