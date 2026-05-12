package com.sasha.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateTaskDTO {

    @NotBlank(message = "Title must be not empty")
    @Size(min = 1, max = 200, message = "Title should be 1-200 characters")
    private String title;

    @NotBlank(message = "Status must be not empty")
    @Size(min = 1, max = 20, message = "Status should be 1-20 characters")
    private String status;
}
