import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {

    @Test
    void hasToReturnFalse() {
        boolean[] FUV = new boolean[]{true, true, true, true, false,
                true, true, true, true, true,
                true, true, true, true, true};
        assertFalse(Decide.decideLaunch(FUV));
    }

    @Test
    void hasToReturnTrue() {
        boolean[] FUV = new boolean[]{true, true, true, true, true,
                true, true, true, true, true,
                true, true, true, true, true};
        assertTrue(Decide.decideLaunch(FUV));
    }

    void checkFUV() {
        boolean[][] PUM = new boolean[][]{
                {true, false, true},
                {true, true, true},
                {false, true, true}
        };
        boolean[] PUV = new boolean[]{false, true, true};
        boolean[] result = Decide.computeFUV(PUM, PUV);

        boolean[] expected = new boolean[]{true, true, false};
        assertArrayEquals(result, expected);
    }

} 