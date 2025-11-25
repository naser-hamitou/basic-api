package com.example.basic_api.service;

import com.example.basic_api.entity.Task;
import com.example.basic_api.exception.TaskNotFoundException;
import com.example.basic_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task findByTitle(String title) {
        return taskRepository.findByTitle(title).orElse(null);
    }

    public List<Task> findByTitles(List<String> titles) {
        return taskRepository.findAllByTitles(titles);
    }

    public List<Task> getAllCompleted() {
        return taskRepository.findByIsCompleted(true);
    }

    @Transactional
    public Task updateTask(Long id, String title, String description, boolean isCompleted) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task not found with id: " + id));
        task.setTitle(title);
        task.setDescription(description);
        task.setIsCompleted(isCompleted);

        return taskRepository.save(task);
    }

    @Transactional
    public Task deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task not found with id: " + id));
        taskRepository.delete(task);

        return task;
    }


}
