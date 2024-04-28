import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.management.ConstructorParameters;
import java.util.stream.Stream;

public class CalculatorTests {
    Calculator sut;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("before all tests");
    }

    @AfterAll
    public static void tearDounAfterClass() {
        System.out.println("after all tests");
    }


    @BeforeEach
    public void setUp() {
        System.out.println("before each test");
        sut = new Calculator();
    }

    @AfterEach
    public void tearDoun() {
        System.out.println("after each test");
        sut = null;
    }

    @Test
    public void test_taxEarnings() {
        System.out.println("test taxEarnings");
        //arrange
        int a = 100, expected = 6;
        
        //act
        var actual = Calculator.taxEarnings(a);

        //assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void test_taxEarningsMinusSpendings() {
        System.out.println("test taxEarningsMinusSpendings");
        //arrange
        int a = 150, b = 50, expected = 15;

        //act
        var actual = Calculator.taxEarningsMinusSpendings(a, b);

        //assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSubtract() {
        System.out.println("testSubtract");
        //arrange
        int a = 3, b = 2, expected = 1;
        //Calculator calc = new Calculator(); //выносим за методы

        //act
        var actual = sut.substract(a, b);

        //assert
        Assertions.assertEquals(expected, actual);

    }


    //================ПАРАМЕТРИЗОВАННЫЕ ТЕСТЫ======================================
    public static Stream<Arguments> getParametrizedTest_taxEarningsMinus() {
        return Stream.of(
                Arguments.of(1,1,0),
                Arguments.of(50,-50,15),
                Arguments.of(10,10,0)
        );
    }

    @ParameterizedTest()
    @MethodSource("getParametrizedTest_taxEarningsMinus")
    //arrange
    public void parametrizedTest_taxEarningsMinus( int a, int b, int expected) {
        System.out.println("parametrized test taxEarningsMinus");
        //act
        var actual = Calculator.taxEarningsMinusSpendings(a, b);
        //assert
        Assertions.assertEquals(expected, actual);

    }

    public static Stream<Arguments> getParametrizedTest_taxEarnings() {
        return Stream.of(
                Arguments.of(100,6),
                Arguments.of(0,0),
                Arguments.of(1000,60)
        );
    }
    //arrange
    @ParameterizedTest()
        @MethodSource("getParametrizedTest_taxEarnings")
    public void parametrizedTest_taxEarnings( int a, int expected) {
        System.out.println("parametrized test taxEarnings");
        //act
        var actual = Calculator.taxEarnings(a);
        //assert
        Assertions.assertEquals(expected, actual);

    }
    public static Stream<Arguments> getParametrizedTest_Subtract() {
        return Stream.of(
                Arguments.of(1,1,0),
                Arguments.of(1,-1,2),
                Arguments.of(0,-1,1)
        );
    }
    //arrange
    @ParameterizedTest()
    @MethodSource("getParametrizedTest_Subtract")
    public void parametrizedTest_taxEarnings( int a, int b, int expected) {
        System.out.println("parametrized test Subtract");
        //act
        var actual = Calculator.substract(a,b);
        //assert
        Assertions.assertEquals(expected, actual);

    }


}
