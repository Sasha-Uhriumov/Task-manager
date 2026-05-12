package com.sasha.task_manager.mapper;

import com.sasha.task_manager.dto.CreateTaskDTO;
import com.sasha.task_manager.dto.ResponseTaskDTO;
import com.sasha.task_manager.dto.UpdateTaskDTO;
import com.sasha.task_manager.entity.TaskEntity;

public class TaskMapper {

    public static TaskEntity toEntity(CreateTaskDTO dto) {
        TaskEntity task = new TaskEntity();
        task.setTitle(dto.getTitle());
        return task;
    }

    public static ResponseTaskDTO fromEntity(TaskEntity task) {
        ResponseTaskDTO dto = new ResponseTaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setStatus(task.getStatusEntity().getStatusName());
        return dto;
    }

    public static void updateTaskFromDTO(TaskEntity task, UpdateTaskDTO dto) {
        task.setTitle(dto.getTitle());
    }
}
