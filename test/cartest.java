import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class cartest {

    @Test
    void testJUnitWorking() {
        assertEquals(4, 2 + 2);
    }
    @Test
    void testGasCarRentalFee() {
        Car car = new GasCar(1, "BMW", 100);
        assertEquals(300, car.calculateRentalFee(3));
    }
    
  
   
  
    
}
