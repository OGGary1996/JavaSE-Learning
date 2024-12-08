package training.exampleclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorsTest {

    @Test
    void add() {
        Calculators calculators = new Calculators();
        int result = calculators.add(1, 2);
        assertEquals(3, result);
    }
}