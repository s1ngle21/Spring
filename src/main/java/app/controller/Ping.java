package app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/ping")
public class Ping {

    @GetMapping
    public ResponseEntity<?> isProgramWorking() {
        return ResponseEntity.ok().build();
    }
}
