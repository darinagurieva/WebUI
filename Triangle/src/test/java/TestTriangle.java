import org.junit.Assert;
import org.junit.Test;
import org.example.hw.Triangle;
import org.junit.jupiter.api.AfterAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

public class TestTriangle {

    static Integer myTestInt = 0;
    static Logger logger = LoggerFactory.getLogger(TestTriangle.class);
    Integer repeated = 0;
    public static String expected = "The sides of a triangle cannot be equal or less then 0";
    public static String errorMsg = "The square of the triangle cannot be measured.";

    @Test
    public void trianglePositiveTest() throws Exception {
        Assert.assertTrue(Triangle.checkSides(5, 3, 6));
        System.out.println(Triangle.measureTriangleSquare(5,3,6));
        logger.info("INFO: ");
    }

    @Test
    public void triangleEqualSidesPositiveTest() throws Exception {
        Assert.assertTrue(Triangle.checkSides(3, 3, 3));
        System.out.println(Triangle.measureTriangleSquare(3,3,3));
        logger.trace("TRACE: ");
    }

    @Test
    public void triangle2SidesEqualNegativeTest() {
        try {
            Assert.assertFalse(Triangle.checkSides(1, 1, 2));
            System.out.println(errorMsg);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void triangleSideZeroNegativeTest() {
        try {
            Triangle.checkSides(0, 5, 7);
        } catch (Exception e) {
            String actual = e.getMessage();
            Assert.assertEquals(expected, actual);
            System.out.println(errorMsg);
            logger.info("INFO: ");
        }
    }

    @Test
    public void triangleAllSidesZeroNegativeTest() {
        try {
            Triangle.checkSides(0, 0, 0);
        } catch (Exception e) {
            String actual = e.getMessage();
            Assert.assertEquals(expected, actual);
            System.out.println(errorMsg);
        }
    }

    @Test
    public void triangleNegativeSideNegativeTest() {
        try {
            Triangle.checkSides(3, 3, -5);
        } catch (Exception e) {
            String actual = e.getMessage();
            Assert.assertEquals(expected, actual);
            System.out.println(errorMsg);
        }
    }

    @Test
    public void triangleAllNegativeSidesNegativeTest() {
        try {
            Triangle.checkSides(-5, -6, -12);
        } catch (Exception e) {
            String actual = e.getMessage();
            Assert.assertEquals(expected, actual);
            System.out.println(errorMsg);
        }
    }

    @Test
    public void triangleNegativeSideZeroSideNegativeTest() {
        try {
            Triangle.checkSides(0, -15, -25);
        } catch (Exception e) {
            String actual = e.getMessage();
            Assert.assertEquals(expected, actual);
            System.out.println(errorMsg);
        }
    }

    @AfterAll
    static void close(){
        myTestInt++;
        System.out.println("Запускаем в конце "+myTestInt);
    }
}