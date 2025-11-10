import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocalJudge_T4 {

    private ParkingSystem parkingSystem;
    private final int INITIAL_CAPACITY = 2;

    @BeforeEach
    void setUp() {
        parkingSystem = new ParkingSystem(INITIAL_CAPACITY);
    }


    @Test
    void testConstructorAndRemainingCap() {
        assertEquals(INITIAL_CAPACITY, parkingSystem.getRemainingCap(), "Remaining capacity should equal initial total capacity");
    }

    @Test
    void testEntrySuccess() {
        assertTrue(parkingSystem.entry("京A10000", "Standard", "2023-10-25", "10.0"), "First entry should succeed");
        assertEquals(INITIAL_CAPACITY - 1, parkingSystem.getRemainingCap(), "Remaining capacity should decrease after successful entry");

        assertTrue(parkingSystem.entry("沪B20000", "Large", "2023-10-25", "11.0"), "Second entry should succeed");
        assertEquals(INITIAL_CAPACITY - 2, parkingSystem.getRemainingCap(), "Remaining capacity should be 0 after two entries");
    }

    @Test
    void testEntryFailure() {
        parkingSystem.entry("京A10000", "Standard", "2023-10-25", "10.0");
        parkingSystem.entry("沪B20000", "Large", "2023-10-25", "11.0");
        assertEquals(0, parkingSystem.getRemainingCap(), "System should be full");

        assertFalse(parkingSystem.entry("粤C30000", "Extra Large", "2023-10-25", "12.0"), "Entry should fail when capacity is zero");
        assertEquals(0, parkingSystem.getRemainingCap(), "Remaining capacity should remain unchanged after failed entry");
    }

    @Test
    void testExit() {
        parkingSystem.entry("京A10000", "Standard", "2023-10-25", "10.0");
        parkingSystem.entry("沪B20000", "Large", "2023-10-25", "11.0");

        parkingSystem.exit("京A10000", "2023-10-25", "12.0");
        assertEquals(INITIAL_CAPACITY - 1, parkingSystem.getRemainingCap(), "Remaining capacity should increase after successful exit");

        Car[] events = parkingSystem.allCarEvents();
        assertEquals("2023-10-25", events[0].getExitDay(), "Exiting car's exitDay should be set");
        assertEquals("12.0", events[0].getExitTime(), "Exiting car's exitTime should be set");
    }

    @Test
    void testAllCarEvents() {
        parkingSystem.entry("京A10000", "Standard", "2023-10-25", "10.0");
        parkingSystem.entry("沪B20000", "Large", "2023-10-25", "11.0");

        Car[] events = parkingSystem.allCarEvents();
        assertEquals(2, events.length, "Should return 2 car events");
        assertEquals("京A10000", events[0].getPlateNumber(), "First plate number should be 京A10000");
        assertEquals("沪B20000", events[1].getPlateNumber(), "Second plate number should be 沪B20000");
    }

    @Test
    void testTotalFeeCarNotExited() {
        parkingSystem.entry("京A10000", "Standard", "2023-10-25", "10.0");
        parkingSystem.exit("京A10000", "2023-10-25", "12.0");

        parkingSystem.entry("沪B20000", "Large", "2023-10-25", "10.0");
        assertEquals(18.0, parkingSystem.totalFee(), "Cars that have not exited should not be included in total fee");
    }
}