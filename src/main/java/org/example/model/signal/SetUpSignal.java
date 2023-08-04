package org.example.model.signal;

import org.example.thirdparty.Algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("setUpSignal")
public class SetUpSignal implements Signal {
    @Autowired
    private Algo algo;

    @Override
    public void execute() {
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }
}
