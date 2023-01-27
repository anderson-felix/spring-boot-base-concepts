package com.example.basicconcepts.shared.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {
  private boolean success;
  private String message;
  private T data = null;
}
