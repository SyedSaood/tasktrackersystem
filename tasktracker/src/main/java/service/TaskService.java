package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
    Task changeTaskStatus(Long id, String status);
    List<Task> searchTaskByTitle(String title);
}
