package by.epam.task.custom;

import by.epam.task.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    private final List<Customer> filteredCustomer = new ArrayList<>();


    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void sortCustomerByName() {
        Collections.sort(customers);

    }

    public List<Customer> searchCustomerByCreditCard(int start, int end) {
        for (Customer elementCustom : customers) {
            if ((elementCustom.getCreditCard()) >= start && elementCustom.getCreditCard() <= end) {
                filteredCustomer.add(elementCustom);
            }
        }
        return filteredCustomer;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

}
