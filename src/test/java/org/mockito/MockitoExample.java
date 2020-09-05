package org.mockito;

import cucumber.api.java.ca.Cal;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Bharath.MC
 * @since Sep-2020
 */
public class MockitoExample {

    @Mock
    Calculator calculator;

    @BeforeClass
    public void initMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDirectMockInterface() {
        Mockito.when(calculator.Add(10, 20)).thenReturn(30);
        int sum = calculator.Add(10, 20);
        System.out.println(sum);
    }

    @Test
    public void testMockApplication() {
        CaclulatorApplication caclulatorApplication = new CaclulatorApplication();
        Mockito.when(calculator.Add(10, 20)).thenReturn(30);
        caclulatorApplication.setCalculator(calculator); //inject mocked object
        int sum = caclulatorApplication.Addition(10, 20);;
        System.out.println(sum);
    }
}
