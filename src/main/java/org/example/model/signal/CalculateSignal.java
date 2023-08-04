package org.example.model.signal;

import org.example.thirdparty.Algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("calculateSignal")
public class CalculateSignal implements Signal {

    @Autowired
    private Algo algo;

    @Override
    public void execute() {
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }
}
