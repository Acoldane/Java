package com.example.demo.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksResponseDto implements Serializable {
    private List<TaskResponseDto> tasks;
}
