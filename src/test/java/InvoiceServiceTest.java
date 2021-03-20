import com.bridgelabz.invoiceservice.InvoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceGenerator;
    @BeforeEach
    public void setUp() {
        invoiceGenerator = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        Assertions.assertEquals(25.0, invoiceGenerator.calculateFare(2.0, 5));
    }

    @Test
    public void givenLessDistaneOrTime_ShouldReturnMinFare() {
        Assertions.assertEquals(5, invoiceGenerator.calculateFare(0.1, 1));
    }
}
