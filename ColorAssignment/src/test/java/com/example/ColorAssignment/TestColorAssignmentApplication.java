package com.example.ColorAssignment;

import org.springframework.boot.SpringApplication;

public class TestColorAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.from(ColorAssignmentApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
