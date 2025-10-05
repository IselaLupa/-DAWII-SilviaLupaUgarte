package com.example.isela.springcloud.msvc_clients.service;

import java.util.List;
import java.util.Optional;

import com.example.isela.springcloud.msvc_clients.model.Client;

public interface ClientService {

    List<Client> findAll();

    Optional<Client> findById(Long id);
}
