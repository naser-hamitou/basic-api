package com.example.basic_api.mapper;

import com.example.basic_api.entity.Task;
import com.example.basic_api.model.CreateTaskDto;
import com.example.basic_api.model.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDtoToTask {

    Task dtoToTask(TaskDto taskDto);

    Task createTaskDtoToTask(CreateTaskDto createTaskDto);

}
