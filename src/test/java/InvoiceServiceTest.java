import com.bridgelabz.invoiceservice.InvoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceGenerator = new InvoiceService();
        double distance = 2.0;
        int time = 5;
        Assertions.assertEquals(25.0, invoiceGenerator.calculateFare(distance, time));
    }

    @Test
    public void givenLessDistaneOrTime_ShouldReturnMinFare() {
        InvoiceService invoiceGenerator = new InvoiceService();
        double distance = 0.1;
        int time = 1;
        Assertions.assertEquals(5,invoiceGenerator.calculateFare(distance, time));
    }
}
