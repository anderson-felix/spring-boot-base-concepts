package com.example.basicconcepts.dtos;

import java.time.LocalDateTime;

import com.example.basicconcepts.shared.enums.Actions;

public interface UserDatalogDTO {
  String username = null;
  Actions action = null;
  LocalDateTime createdAt = LocalDateTime.now();
}
