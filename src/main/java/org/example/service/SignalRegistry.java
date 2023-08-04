package org.example.service;

import org.example.model.signal.Signal;

public interface SignalRegistry {
    Signal getSignalById(Integer signalId);

    void init();
}
