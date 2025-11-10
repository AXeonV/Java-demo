import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalJudge_T3 {

    @Test
    void test1() {
        Car carExLarge = new Car("京A00003", "Extra Large");
        assertEquals("京A00003", carExLarge.getPlateNumber());
        assertEquals(3, carExLarge.getType());
    }

    /**
     * @Description: Used to test getters and setters
     */
    @Test
    void test2() {
        Car car = new Car("京A00001", "Standard");


        assertEquals(1, car.getType());

        //test field entryDay
        assertEquals("", car.getEntryDay());
        car.setEntryDay("2025-10-27");
        assertEquals("2025-10-27", car.getEntryDay());
        car.setEntryDay("");
        assertEquals("", car.getEntryDay());

    }

    /**
     * @Description: Used to test toString
     */
    @Test
    void test3() {
        Car car = new Car("京A00001", "Standard");
        car.setEntryDay("Monday");
        car.setEntryTime("8.0");
        car.setExitDay("Monday");
        car.setExitTime("13.5");

        String expectedJson =
                "{\n" +
                        "  \"plateNumber\": \"京A00001\",\n" +
                        "  \"type\": \"Standard\",\n" +
                        "  \"entryDay\": \"Monday\",\n" +
                        "  \"entryTime\": \"8.0\",\n" +
                        "  \"exitDay\": \"Monday\",\n" +
                        "  \"exitTime\": \"13.5\"\n" +
                        "}";

        assertEquals(expectedJson, car.toString());


    }

    /**
     * @Description: Used to getFee
     */
    @Test
    void test4(){
        Car car = new Car("京A00001", "Standard");
        car.setEntryDay("2025-01-10"); // Friday
        car.setEntryTime("17.0");      // 17:00
        car.setExitDay("2025-01-13");  // Monday
        car.setExitTime("9.0");        // 09:00
        assertEquals(133.0, car.getFee());
    }


}