package by.epam.tr.start;

import by.epam.task.custom.CustomerService;
import by.epam.task.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FunctionTest {

    private final CustomerService customerService = new CustomerService();
    private Customer customerFirst;
    private Customer customerSecond;


    @BeforeAll
    public void setUp() {
        customerFirst = new Customer(1, "B", "B", "c", "ad", 123, 2);
        customerSecond = new Customer(1, "A", "B", "c", "ad", 148, 2);
        customerService.addCustomer(customerFirst);
        customerService.addCustomer(customerSecond);
    }

    @Test
    public void verifyAddCustomers() {
        int actual = customerService.getCustomers().size();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void verifySortCustomers() {
        customerService.sortCustomerByName();
        Assertions.assertEquals(customerSecond, customerService.getCustomers().get(0));
    }

    @Test
    public void verifySearchCustomerByCreditCard() {
        List<Customer> choiceCustomer = customerService.searchCustomerByCreditCard(114, 125);
        int amountExpectedCustomer = 1;
        int actual = choiceCustomer.size();

        Assertions.assertEquals(amountExpectedCustomer, actual);

    }


}
