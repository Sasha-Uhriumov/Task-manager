package com.sasha.task_manager.controller;

import com.sasha.task_manager.dto.CreateTaskDTO;
import com.sasha.task_manager.dto.ResponseTaskDTO;
import com.sasha.task_manager.dto.UpdateTaskDTO;
import com.sasha.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<ResponseTaskDTO> createTask(@RequestBody CreateTaskDTO dto) {
        ResponseTaskDTO task = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTaskDTO> getTask(@PathVariable long id) {
        ResponseTaskDTO task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseTaskDTO> updateTaskById(@PathVariable long id,
                                                          @RequestBody UpdateTaskDTO dto) {

        ResponseTaskDTO task = taskService.updateTaskById(id, dto);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Task successfully deleted with id " + id);
    }
}
