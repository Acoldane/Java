package com.example.demo.Controller;

import com.example.demo.Entity.DTO.UserRequestDto;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Exception.DataNotFoundException;
import com.example.demo.Utils.Exception.DataNotValidException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/users", produces = "application/json")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() throws DataNotFoundException {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById( @PathVariable Long id) throws DataNotFoundException, IOException {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<?> userExist( @PathVariable Long id) throws DataNotFoundException{
        userService.userExist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<?> createUser( @RequestBody UserRequestDto userDto) throws DataNotValidException {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = "application/json")
    public ResponseEntity<?> updateUser( @PathVariable Long id,
                                         @RequestBody UserRequestDto userRequestDto) throws DataNotFoundException, DataNotValidException {
        return new ResponseEntity<>(userService.updateUser(id,userRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteUser( @PathVariable Long id) throws DataNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
