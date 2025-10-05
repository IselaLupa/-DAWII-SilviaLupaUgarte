package com.example.isela.springcloud.msvc_clients.model;

import java.util.Date;

public record User(Long id, String dni, String nombres, String apellidos, Date nacimiento, int port) {
}
