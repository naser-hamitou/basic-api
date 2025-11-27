package com.example.basic_api.mapper;

import com.example.basic_api.entity.Task;
import com.example.basic_api.model.CreateTaskDto;
import com.example.basic_api.model.TaskDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T22:52:23-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class TaskDtoToTaskImpl implements TaskDtoToTask {

    @Override
    public Task dtoToTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDto.getId() );
        task.setTitle( taskDto.getTitle() );
        task.setDescription( taskDto.getDescription() );
        task.setCompleted( taskDto.isCompleted() );

        return task;
    }

    @Override
    public Task createTaskDtoToTask(CreateTaskDto createTaskDto) {
        if ( createTaskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setTitle( createTaskDto.getTitle() );
        task.setDescription( createTaskDto.getDescription() );

        return task;
    }
}
