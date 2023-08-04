package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

@SpringBootTest
class SignalHandlerImplTest {

    @Autowired
    private SignalHandler handler;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testCancelSignal() {
        String expected = """
                cancelTrades
                doAlgo""";
        handler.handleSignal(Integer.MAX_VALUE);
        assertLinesMatch(out.toString().lines(), expected.lines());
    }

    @Test
    public void testSetUpSignal() {
        String expected = """
                setUp
                setAlgoParam 1,60
                performCalc
                submitToMarket
                doAlgo""";
        handler.handleSignal(1);
        assertLinesMatch(out.toString().lines(), expected.lines());
    }

    @Test
    public void testReverseSignal() {
        String expected = """
                reverse
                setAlgoParam 1,80
                submitToMarket
                doAlgo""";
        handler.handleSignal(2);
        assertLinesMatch(out.toString().lines(), expected.lines());
    }

    @Test
    public void tesCalculateSignal() {
        String expected = """
                setAlgoParam 1,90
                setAlgoParam 2,15
                performCalc
                submitToMarket
                doAlgo""";
        handler.handleSignal(3);
        assertLinesMatch(out.toString().lines(), expected.lines());
    }

}