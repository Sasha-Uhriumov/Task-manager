package com.sasha.task_manager.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateTaskDTO {

    @NotBlank(message = "Title must be not empty")
    @Size(min = 1, max = 200, message = "Title should be 1-200 characters")
    private String title;
}
