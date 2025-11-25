package com.example.basic_api.controller;

import com.example.basic_api.entity.Task;
import com.example.basic_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TodoController {

    private TaskService taskService;

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

    // TODO: Create task, delete task, complete task, modify task,
}
