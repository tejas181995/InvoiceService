import com.bridgelabz.invoiceservice.InvoiceService;
import com.bridgelabz.invoiceservice.InvoiceSummary;
import com.bridgelabz.invoiceservice.Ride;
import com.bridgelabz.invoiceservice.RideRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InvoiceServiceTest {
    InvoiceService invoiceGenerator;
    @BeforeEach
    public void setUp() {
        invoiceGenerator = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        Assertions.assertEquals(25.0, invoiceGenerator.calculateFare(2.0, 5, InvoiceService.NORMAL_RIDE));
    }

    @Test
    public void givenLessDistaneOrTime_ShouldReturnMinFare() {
        Assertions.assertEquals(5, invoiceGenerator.calculateFare(0.1, 1,  InvoiceService.NORMAL_RIDE));
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)
            };
            InvoiceSummary summary = invoiceGenerator.calculateFare(rides, 11,  InvoiceService.NORMAL_RIDE);
            InvoiceSummary expectedInvoiceSummary=  new InvoiceSummary(2,30.0);
            Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void getUserRideSummaryTest() {
        ArrayList<InvoiceSummary> expectedSummery = new ArrayList<>();
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides1, 10,  InvoiceService.NORMAL_RIDE);
        expectedSummery.add(summary);
        Ride[] rides2 = {new Ride(2.0, 5),
                new Ride(0.3, 1)
        };
        summary = invoiceGenerator.calculateFare(rides2, 10,  InvoiceService.NORMAL_RIDE);
        expectedSummery.add(summary);
        Assertions.assertEquals(expectedSummery, RideRepository.getUserRideList(10));
    }
    @Test
    public void givenMultipleRides_ShouldReturnTotalFarePremiumCustomer() {
        Ride[] rides = {new Ride(1.0, 5),
                new Ride(2.0, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides, 10,  InvoiceService.PREMIUM_RIDE);
        InvoiceSummary expectedInvoiceSummary=  new InvoiceSummary(2,57.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
}
