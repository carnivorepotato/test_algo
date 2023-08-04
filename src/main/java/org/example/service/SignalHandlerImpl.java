package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerImpl implements SignalHandler {
    private SignalRegistry registry;

    @Autowired
    public SignalHandlerImpl(SignalRegistry registry) {
        this.registry = registry;
        this.registry.init();
    }

    public void handleSignal(int signal) {
        registry.getSignalById(signal).execute();
    }
}
