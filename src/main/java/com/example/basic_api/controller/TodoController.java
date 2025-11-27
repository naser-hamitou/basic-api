package com.example.basic_api.controller;

import com.example.basic_api.entity.Task;
import com.example.basic_api.model.CreateTaskDto;
import com.example.basic_api.model.TaskDto;
import com.example.basic_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TodoController {

    private final TaskService taskService;

    @Autowired
    public TodoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(@RequestParam(required = false) List<String> titles) {
        if (titles == null || titles.isEmpty()) {
            return taskService.findAll();
        }
        return taskService.findByTitles(titles);
    }

    @GetMapping("/{id}")
    public Task findTaskByIds(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    public Task createTast(@RequestBody CreateTaskDto createTaskDto) {
        return taskService.createTask(createTaskDto);
    }

    @PostMapping("/{id}")
    public Task deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    @PatchMapping
    public Task modifyTask(@RequestBody TaskDto modifiedTask) {
        return taskService.updateTask(modifiedTask.getId(), modifiedTask.getTitle(),
                modifiedTask.getDescription(), modifiedTask.isCompleted());
    }

}
