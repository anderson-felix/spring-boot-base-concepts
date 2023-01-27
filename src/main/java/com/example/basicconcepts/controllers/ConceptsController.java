package com.example.basicconcepts.controllers;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.basicconcepts.dtos.UserDatalogDTO;
import com.example.basicconcepts.shared.utils.ResponseData;

@RestController
@RequestMapping("/api")
public class ConceptsController {

    @GetMapping("/array")
    public ResponseEntity<ResponseData<int[]>> example(@RequestParam(required = false) String lenght) {
        boolean haveParam = lenght != null && !lenght.isEmpty();
        String message = haveParam ? String.format("Here is your %s position array", lenght) : "This is a random lenght array. You can send query parameter 'lenght' to define array lenght";
        int arrLenght = new Random().nextInt(50) + 1;
        ResponseData<int[]> responseData = null;

        try {
            if (haveParam)
                arrLenght = Integer.parseInt(lenght);
        } catch (Exception e) {
            responseData = new ResponseData<>(false, "The 'lenght' parameter need to be a number", null);
            return ResponseEntity.badRequest().body(responseData);
        }

        int[] data = new int[arrLenght];

        for (int i = 0; i < arrLenght; i++) {
            data[i] = i + 1;
        }

        responseData = new ResponseData<>(true, message, data);

        return ResponseEntity.ok(responseData);
    }

    public void serialize(@RequestBody UserDatalogDTO dto) {

    }
}
