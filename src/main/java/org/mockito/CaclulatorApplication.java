package org.mockito;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bharath.MC
 * @since Sep-2020
 */
public class CaclulatorApplication {
    @Getter
    @Setter
    Calculator calculator;

    public int Addition(int a, int b){
        return calculator.Add(a, b);
    }

    public int Multiplication(int a, int b){
        return calculator.Mul(a, b);
    }
}
