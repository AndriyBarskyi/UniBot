package com.example.unibot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniBotApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(UniBotApplication.class, args);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

        String data;
        while (! (data = reader.readLine()).equals("q")) {
            if (data.equals("abc")) {
                System.out.println("def");
            }
        }
    }

}
