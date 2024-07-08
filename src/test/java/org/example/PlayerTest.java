package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testGetMarkerPositive() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    void testGetMarkerNegative() {
        Player player = new Player('X');
        assertNotEquals('O', player.getMarker());
    }
}
