import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {

    @Test
    void checkPUM() {
        Decide.Connectors[][] LCM = new Decide.Connectors[][]{
                {Decide.Connectors.ANDD, Decide.Connectors.ORR, Decide.Connectors.NOTUSED},
                {Decide.Connectors.ORR, Decide.Connectors.ORR, Decide.Connectors.ANDD},
                {Decide.Connectors.NOTUSED, Decide.Connectors.ANDD, Decide.Connectors.NOTUSED}
        };
        boolean[] CMV = new boolean[]{true, false, true};
        boolean[][] result = Decide.computePUM(LCM, CMV);

        boolean[][] expected = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {true, false, true}
        };
        for (int i = 0; i < expected.length; ++i) {
            assertArrayEquals(result[i], expected[i]);
        }
    }

} 