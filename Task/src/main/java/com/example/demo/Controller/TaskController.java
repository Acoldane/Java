package com.example.demo.Controller;

import com.example.demo.Entity.DTO.TaskRequestDto;
import com.example.demo.Service.TaskService;
import com.example.demo.Utils.Exception.DataNotFoundException;
import com.example.demo.Utils.Exception.DataNotValidException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/api/v1/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    // add CRUD methods
    // add ExceptionHandling
    // create custom exceptions NotFoundException, DataNotValidException, etc.
    // BONUS : Add Swagger documentation (OpenAPI)!
    @GetMapping("/")
    public ResponseEntity<?> getAllTasks() throws DataNotFoundException {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById( @PathVariable Long id) throws DataNotFoundException {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<?> getTasksByUserId( @PathVariable Long id){
        return new ResponseEntity<>(taskService.getTasksByUserId(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTask( @RequestBody TaskRequestDto taskDto) throws DataNotValidException, DataNotFoundException {
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTask( @PathVariable Long id,
                                         @RequestBody TaskRequestDto taskRequestDto) throws DataNotFoundException, DataNotValidException {
        return new ResponseEntity<>(taskService.updateTask(id, taskRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask( @PathVariable Long id) throws DataNotFoundException {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
