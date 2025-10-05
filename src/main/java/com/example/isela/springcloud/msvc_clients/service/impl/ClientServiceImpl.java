package com.example.isela.springcloud.msvc_clients.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isela.springcloud.msvc_clients.client.UserFeignClient;
import com.example.isela.springcloud.msvc_clients.model.Client;
import com.example.isela.springcloud.msvc_clients.model.User;
import com.example.isela.springcloud.msvc_clients.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public List<Client> findAll() {
        
        return userFeignClient.list().getBody().stream()
            .map(user -> {
              
                System.out.println("Cliente desde puerto: " + user.port());

                return new Client(
                    user.id(),
                    user.dni(),
                    user.nombres(),
                    user.apellidos(),
                    generarUsuario(user.nombres(), user.apellidos()),
                    "123456",
                    user.port()
                );
            })
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(Long id) {
        User user = userFeignClient.detail(id).getBody();
        if (user != null) {
            return Optional.of(new Client(
                user.id(),
                user.dni(),
                user.nombres(),
                user.apellidos(),
                generarUsuario(user.nombres(), user.apellidos()),
                "123456",
                user.port()
            ));
        }
        return Optional.empty();
    }

    private String generarUsuario(String nombres, String apellidos) {
        return (nombres + "." + apellidos)
                .toLowerCase()
                .replace(" ", ".");
    }
}
