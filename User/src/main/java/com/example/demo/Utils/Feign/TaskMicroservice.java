package com.example.demo.Utils.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "spring-cloud-eureka-Task", configuration = FeignConfig.class)
public interface TaskMicroservice {
    @RequestMapping(value = "api/v1/tasks/byUser/{id}", method = RequestMethod.GET)
    ResponseEntity<?> getUsersTasks(@PathVariable long id);
}
