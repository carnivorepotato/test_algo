package org.example.controller;

import org.example.service.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("signal")
public class SignalController {
    @Autowired
    private SignalHandler signalHandler;

    @PostMapping
    public ResponseEntity handleSignalById(@RequestParam Integer signal) {
        signalHandler.handleSignal(signal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
