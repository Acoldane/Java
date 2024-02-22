package com.example.demo.Service;

import com.example.demo.Entity.DTO.TaskRequestDto;
import com.example.demo.Entity.DTO.TaskResponseDto;
import com.example.demo.Entity.DTO.TasksResponseDto;
import com.example.demo.Repository.TaskRepo;
import com.example.demo.Utils.Exception.DataNotFoundException;
import com.example.demo.Utils.Exception.DataNotValidException;
import com.example.demo.Utils.Mapper.MappingProfile;
import com.example.demo.Utils.Feign.UserMicroservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepo taskRepo;
    private final UserMicroservice userMicroservice;

    @Override
    public List<TaskResponseDto> getAllTasks() throws DataNotFoundException {
        if (taskRepo.findAll().isEmpty()) throw new DataNotFoundException("Empty task list");
        return taskRepo.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskDto) throws DataNotValidException {
        taskValidation(taskDto);
        userMicroservice.getUser(taskDto.getUserId());
        var task = MappingProfile.mapToEntity(taskDto);
        return MappingProfile.mapToDto(taskRepo.save(task));
    }

    @Override
    public TaskResponseDto getTaskById(Long id) throws DataNotFoundException {
        var task = taskRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Task not found"));
        return MappingProfile.mapToDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws DataNotFoundException, DataNotValidException {
        if(!Objects.equals(id,taskDto.getId())) throw new DataNotValidException("Id doesn't match the task id");
        taskValidation(taskDto);
        userMicroservice.getUser(taskDto.getUserId());
        var task = taskRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Task not found"));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setDueDate(task.getDueDate());
        return MappingProfile.mapToDto(taskRepo.save(task));
    }

    @Override
    public void deleteTask(Long id) throws DataNotFoundException {
        var task = taskRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Task not found"));
        taskRepo.delete(task);
    }

    @Override
    public TasksResponseDto getTasksByUserId(Long userId){
        TasksResponseDto tasksResponseDto = new TasksResponseDto(taskRepo.getTasksByUserIdIs(userId).stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList()));
        return tasksResponseDto;
    }

    public boolean isDateValid(Date date){
        return date.after(new Date());
    }

    public void taskValidation(TaskRequestDto taskDto) throws DataNotValidException {
        if (taskDto.getTitle() == null || taskDto.getTitle().isEmpty()) throw new DataNotValidException("Invalid title");
        if (taskDto.getStatus() == null) throw new DataNotValidException("Invalid status");
        if (taskDto.getDueDate() == null || !isDateValid(taskDto.getDueDate())) throw new DataNotValidException("Invalid due date");
    }
}
