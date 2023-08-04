package org.example.service;

import org.example.model.signal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SignalRegistryImpl implements SignalRegistry {
    private final Map<Integer, Signal> registry = new ConcurrentHashMap<>();
    @Autowired
    @Qualifier("cancelSignal")
    private Signal cancelSignal;
    @Autowired
    @Qualifier("setUpSignal")
    private Signal setUpSignal;
    @Autowired
    @Qualifier("reverseSignal")
    private Signal reverseSignal;
    @Autowired
    @Qualifier("calculateSignal")
    private Signal calculateSignal;

    public void init() {
        registry.put(0, cancelSignal);
        registry.put(1, setUpSignal);
        registry.put(2, reverseSignal);
        registry.put(3, calculateSignal);
    }

    @Override
    public Signal getSignalById(Integer signalId) {
        return registry.getOrDefault(signalId, registry.get(0));
    }
}
