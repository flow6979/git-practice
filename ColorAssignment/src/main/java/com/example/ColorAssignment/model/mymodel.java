package com.example.ColorAssignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class mymodel {

    private String name;
    private List<String> colors;
}