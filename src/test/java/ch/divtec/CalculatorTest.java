package ch.divtec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    // ── ADD ──────────────────────────────────────────────────────────────────

    @Test
    void add_deuxPositifs() {
        assertEquals(5.0, calc.add(2, 3));
    }

    @Test
    void add_deuxNegatifs() {
        assertEquals(-5.0, calc.add(-2, -3));
    }

    @Test
    void add_positifEtNegatif() {
        assertEquals(-1.0, calc.add(2, -3));
    }

    @Test
    void add_avecZero() {
        assertEquals(3.0, calc.add(3, 0));
    }

    @Test
    void add_deuxDecimaux() {
        assertEquals(0.3, calc.add(0.1, 0.2), 1e-9);
    }

    // ── SUBTRACT ─────────────────────────────────────────────────────────────

    @Test
    void subtract_deuxPositifs() {
        assertEquals(1.0, calc.subtract(3, 2));
    }

    @Test
    void subtract_deuxNegatifs() {
        assertEquals(1.0, calc.subtract(-2, -3));
    }

    @Test
    void subtract_resultatNegatif() {
        assertEquals(-1.0, calc.subtract(2, 3));
    }

    @Test
    void subtract_avecZero() {
        assertEquals(3.0, calc.subtract(3, 0));
    }

    @Test
    void subtract_memeNombre() {
        assertEquals(0.0, calc.subtract(5, 5));
    }

    // ── MULTIPLY ─────────────────────────────────────────────────────────────

    @Test
    void multiply_deuxPositifs() {
        assertEquals(6.0, calc.multiply(2, 3));
    }

    @Test
    void multiply_deuxNegatifs() {
        assertEquals(6.0, calc.multiply(-2, -3));
    }

    @Test
    void multiply_positifEtNegatif() {
        assertEquals(-6.0, calc.multiply(2, -3));
    }

    @Test
    void multiply_parZero() {
        assertEquals(0.0, calc.multiply(5, 0));
    }

    @Test
    void multiply_parUn() {
        assertEquals(5.0, calc.multiply(5, 1));
    }

    @Test
    void multiply_deuxDecimaux() {
        assertEquals(0.06, calc.multiply(0.2, 0.3), 1e-9);
    }

    // ── DIVIDE ───────────────────────────────────────────────────────────────

    @Test
    void divide_deuxPositifs() {
        assertEquals(2.0, calc.divide(6, 3));
    }

    @Test
    void divide_deuxNegatifs() {
        assertEquals(2.0, calc.divide(-6, -3));
    }

    @Test
    void divide_positifEtNegatif() {
        assertEquals(-2.0, calc.divide(6, -3));
    }

    @Test
    void divide_resultatDecimal() {
        assertEquals(2.5, calc.divide(5, 2));
    }

    @Test
    void divide_parZero_leveException() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @Test
    void divide_zeroParNombre() {
        assertEquals(0.0, calc.divide(0, 5));
    }

    // ── FACTORIAL ────────────────────────────────────────────────────────────

    @Test
    void factorial_zero() {
        assertEquals(1L, calc.factorial(0));
    }

    @Test
    void factorial_un() {
        assertEquals(1L, calc.factorial(1));
    }

    @Test
    void factorial_nombrePositif() {
        assertEquals(120L, calc.factorial(5));
    }

    @Test
    void factorial_grand() {
        assertEquals(3628800L, calc.factorial(10));
    }

    @Test
    void factorial_nombreNegatif_leveException() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-1));
    }

    @Test
    void factorial_nombreDecimal_leveException() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(2.5));
    }
}