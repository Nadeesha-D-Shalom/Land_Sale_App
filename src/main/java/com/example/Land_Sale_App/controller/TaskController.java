package com.example.Land_Sale_App.controller;

import com.example.Land_Sale_App.entity.Project;
import com.example.Land_Sale_App.entity.Task;
import com.example.Land_Sale_App.repository.ProjectRepository;
import com.example.Land_Sale_App.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/tasks")
public class TaskController {

    private final TaskRepository taskRepo;
    private final ProjectRepository projectRepo;

    public TaskController(TaskRepository taskRepo, ProjectRepository projectRepo) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;
    }

    // Get all tasks for a project
    @GetMapping
    public List<Task> getTasks(@PathVariable Long projectId) {
        return taskRepo.findByProjectId(projectId);
    }

    // Create a new task under a project
    @PostMapping
    public ResponseEntity<Task> createTask(@PathVariable Long projectId, @RequestBody Task task) {
        return projectRepo.findById(projectId)
                .map(project -> {
                    task.setProject(project);
                    return ResponseEntity.ok(taskRepo.save(task));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Update an existing task
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long projectId, @PathVariable Long taskId, @RequestBody Task updated) {
        return taskRepo.findById(taskId)
                .map(existing -> {
                    updated.setId(taskId);
                    updated.setProject(existing.getProject());
                    return ResponseEntity.ok(taskRepo.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a task
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        if (taskRepo.existsById(taskId)) {
            taskRepo.deleteById(taskId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
