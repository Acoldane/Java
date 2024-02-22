package com.example.demo.Utils.Feign;

import com.example.demo.Utils.Feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "spring-cloud-eureka-User", configuration = FeignConfig.class)
public interface UserMicroservice {
    @GetMapping(value = "api/v1/users/exist/{id}")
    ResponseEntity<?> getUser(@PathVariable long id);
}
