package com.example.demo.Service;

import com.example.demo.Entity.DTO.TasksResponseDto;
import com.example.demo.Entity.DTO.UserRequestDto;
import com.example.demo.Entity.DTO.UserResponseDto;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Utils.Exception.DataNotFoundException;
import com.example.demo.Utils.Exception.DataNotValidException;
import com.example.demo.Utils.Mapper.MappingProfile;
import com.example.demo.Utils.Feign.TaskMicroservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final TaskMicroservice taskMicroservice;

    public List<UserResponseDto> getAllUsers() throws DataNotFoundException {
        if (userRepo.findAll().isEmpty()) throw new DataNotFoundException("User list is empty");
        return userRepo.findAll()
                .stream()
                .map(MappingProfile::mapToUserDto).toList();
    }

    public UserResponseDto createUser(UserRequestDto userDto) throws DataNotValidException {
        userValidation(userDto);
        var user = MappingProfile.mapToUserEntity(userDto);
        return MappingProfile.mapToUserDto(userRepo.save(user));
    }

    public Object getUserById(Long id) throws DataNotFoundException, IOException {
        User user = userRepo.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
        return new Object(){
            public Long id = user.getId();
            public String fullName = user.getLastName().toUpperCase() + ", " + user.getFirstName();
            public String email = user.getEmail();
            ObjectMapper mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(taskMicroservice.getUsersTasks(user.getId()).getBody());
            public TasksResponseDto tasks = mapper.readValue(requestBody, TasksResponseDto.class);
        };
    }

    public void userExist(Long id) throws DataNotFoundException {
        userRepo.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
    }

    public UserResponseDto updateUser(Long id, UserRequestDto userDto) throws DataNotValidException, DataNotFoundException {
        if(!Objects.equals(id, userDto.getId()) || id==0) throw new DataNotValidException("Id doesn't match the user id");
        userValidation(userDto);
        var user = userRepo.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return MappingProfile.mapToUserDto(userRepo.save(user));
    }

    public boolean isEmailValid(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    public void deleteUser(Long id) throws DataNotFoundException {
        var task = userRepo.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
        userRepo.delete(task);
    }
    public void userValidation(UserRequestDto userDto) throws DataNotValidException {
        if(userDto.getFirstName()==null || userDto.getFirstName().isEmpty()) throw new DataNotValidException("Invalid first name");
        if(userDto.getLastName()==null || userDto.getLastName().isEmpty()) throw new DataNotValidException("Invalid last name");
        if (!isEmailValid(userDto.getEmail())) throw new DataNotValidException("Invalid email address");
    }
}
