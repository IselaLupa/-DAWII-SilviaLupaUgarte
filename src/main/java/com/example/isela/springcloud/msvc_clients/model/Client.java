package com.example.isela.springcloud.msvc_clients.model;

public record Client(Long id, String dni, String nombres, String apellidos, String usuario, String contrasenia, int port ) {
}
