package org.example.DSA;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DSTest {
    final DS OBJ = new DS();

    @ParameterizedTest
    @CsvSource("10, 6")
    void guessNumber(int n, int pick) {
        OBJ.pick = pick;
        assertEquals(pick, OBJ.guessNumber(n));
    }
}
