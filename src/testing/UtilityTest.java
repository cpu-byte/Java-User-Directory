package testing;

import directory.elements.Utility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void idExist() {
        assertNotNull(Utility.uuidGenerate());
    }

    @Test
    void idLength() {
        // uuid is 36 letters long
        assertEquals(Utility.uuidGenerate().length(), 36);
    }

}