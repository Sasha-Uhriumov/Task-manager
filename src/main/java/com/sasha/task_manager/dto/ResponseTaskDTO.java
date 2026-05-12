package com.sasha.task_manager.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseTaskDTO {

    private Long id;

    private String title;

    private String status;
}
