package org.example.model.signal;

import org.example.thirdparty.Algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("reverseSignal")
public class ReverseSignal implements Signal {
    @Autowired
    private Algo algo;

    @Override
    public void execute() {
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
        algo.doAlgo();
    }
}
