package com.sasha.task_manager.service;

import com.sasha.task_manager.dto.CreateTaskDTO;
import com.sasha.task_manager.dto.ResponseTaskDTO;
import com.sasha.task_manager.entity.StatusEntity;
import com.sasha.task_manager.entity.TaskEntity;
import com.sasha.task_manager.exception.CustomStatusNotFoundException;
import com.sasha.task_manager.mapper.TaskMapper;
import com.sasha.task_manager.repository.StatusRepository;
import com.sasha.task_manager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;
    private final StatusRepository statusRepository;

    public ResponseTaskDTO createTask(CreateTaskDTO dto) {
        log.info("Attempt to create task");

        StatusEntity status = statusRepository.findByStatusNameIgnoreCase("NEW")
                .orElseThrow(() -> {
                    log.warn("Status NEW not found");
                    return new CustomStatusNotFoundException("Status NEW not found");
                });

        TaskEntity task = TaskMapper.toEntity(dto);
        task.setStatusEntity(status);

        TaskEntity savedTask = taskRepository.save(task);
        log.info("Task with id {} successfully created", savedTask.getId());

        return TaskMapper.fromEntity(savedTask, status.getStatusName());
    }
}
