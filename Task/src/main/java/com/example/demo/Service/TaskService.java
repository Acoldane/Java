package com.example.demo.Service;

import com.example.demo.Entity.DTO.TaskRequestDto;
import com.example.demo.Entity.DTO.TaskResponseDto;
import com.example.demo.Entity.DTO.TasksResponseDto;
import com.example.demo.Utils.Exception.DataNotFoundException;
import com.example.demo.Utils.Exception.DataNotValidException;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks() throws DataNotFoundException;
    TaskResponseDto createTask(TaskRequestDto taskDto) throws DataNotValidException;
    TaskResponseDto getTaskById(Long id) throws DataNotFoundException;
    TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws DataNotValidException,DataNotFoundException;
    void deleteTask(Long id) throws DataNotFoundException;
    TasksResponseDto getTasksByUserId(Long userId);
}