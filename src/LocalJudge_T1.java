import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LocalJudge_T1 {

    @Test
    void test1() {
        int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}};
        assertTrue(CollinerPoints.sameLine(points));
    }

    @Test
    void test2() {
        int[][] points = {{0, 0}, {1, 2}, {2, 3}, {3, 5}};
        assertFalse(CollinerPoints.sameLine(points));
    }

    @Test
    void test3() {
        int[][] points1 = {{5, 0}, {5, 5}, {5, 10}};
        int[][] points2 = {{10, 0}, {10, 5}, {10, 10}};
        assertTrue(CollinerPoints.sameLine(points1));
        assertTrue(CollinerPoints.sameLine(points2));
    }

    @Test
    void test4() {
        int[][] points = {{0, 0}, {10, 10}};
        assertTrue(CollinerPoints.sameLine(points));
    }

    @Test
    void test5() {
        int[][] points = {{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}};
        assertTrue(CollinerPoints.sameLine(points));
    }

    @Test
    void test6() {
        int[][] points = {{-2, -2}, {0, 0}, {2, 2}};
        assertTrue(CollinerPoints.sameLine(points));
    }

    @Test
    void test7() {
        int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}};
        assertTrue(CollinerPoints.sameLine(points));
    }

    @Test
    void test8() {
        int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 6}};
        assertFalse(CollinerPoints.sameLine(points));
    }

    @Test
    void test9() {
        int[][] points = new int[100][2];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt(201) - 100;
            int y = 3 * x -1;
            points[i][0] = x;
            points[i][1] = y;
        }
        assertTrue(CollinerPoints.sameLine(points));
    }

    @Test
    void test10() {
        int[][] points = new int[100][2];
        Random rand = new Random();
        for (int i = 0; i < 99; i++) {
            int x = rand.nextInt(201) - 100;
            int y = 3 * x -1;
            points[i][0] = x;
            points[i][1] = y;
        }
        points[99][0] = 0;
        points[99][1] = 0;
        assertFalse(CollinerPoints.sameLine(points));
    }


}
