package com.example.isela.springcloud.msvc_clients.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.isela.springcloud.msvc_clients.model.User;

@FeignClient(name = "msvc-users")
public interface UserFeignClient {

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> list();

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> detail(@PathVariable Long id);
}
