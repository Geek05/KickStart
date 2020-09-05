package org.mockito;

/**
 * @author Bharath.MC
 * @since Sep-2020
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int Add(int a, int b) {
        return a + b;
    }

    @Override
    public int Mul(int a, int b) {
        return a * b;
    }
}
