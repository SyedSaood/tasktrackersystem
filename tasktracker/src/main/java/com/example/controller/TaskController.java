package com.example.tasktracker.controller;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> changeTaskStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(taskService.changeTaskStatus(id, status));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTaskByTitle(@RequestParam String title) {
        return ResponseEntity.ok(taskService.searchTaskByTitle(title));
    }
}
