package com.amit.book.inventory.service;

import com.amit.book.inventory.exception.InvalidBookIDException;
import com.amit.book.inventory.exception.InvalidBookNameException;
import com.amit.book.inventory.exception.InvalidBookPriceException;
import com.amit.book.inventory.model.Customer;
import com.amit.book.inventory.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerService implements CustomerServiceInterface {

    private HashMap<Integer, Customer> customers = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    private static final CustomerRepository customerRepository = new CustomerRepository();

    public void acceptCustomerInfo() throws SQLException {

        boolean value = customerRepository.isCustomerTableEmpty();
        if (value) System.out.println("No Customer present in the inventory.");

        Customer customer = new Customer();

        System.out.println("Enter customer id");
        int customerId = Integer.parseInt(scanner.nextLine());
        customer.setCustomerID(customerId);

        System.out.println("Enter customer name");
        String name = scanner.nextLine();
        customer.setCustomerName(name);

        System.out.println("Enter customer address");
        String address = scanner.nextLine();
        customer.setCustomerAddress(address);

        System.out.println("Enter customer contact");
        Long contact = Long.valueOf(scanner.nextLine());
        customer.setCustomerContact(contact);

        System.out.println("Enter customer Email ID");
        String emailID = scanner.nextLine();
        customer.setCustomerEmailID(emailID);

        boolean isCustomerAdded = customerRepository.fillCustomerInfo(customer);
        System.out.println(isCustomerAdded ? "Customer entry added in DB" : "Failed to add customer entry in DB");
    }

    public void displayCustomerInfo() throws SQLException {
        customerRepository.displayTheCustomerInfo();
    }

    public void getCustomerById(int customer_Id) throws SQLException {
        customerRepository.getCustomerById(customer_Id);
    }

    public void deleteCustomerById(int customerId) throws SQLException {
        customerRepository.deleteCustomerById(customerId);
    }

    public boolean isCustomerExist(int customerId) throws SQLException {
        return customerRepository.isCustomerExists(customerId);
    }

    public void updateCustomerInfo(int customer_Id) throws InvalidBookNameException, SQLException, InvalidBookIDException, InvalidBookPriceException {
        Customer customer = new Customer();
        customer.setCustomerID(customer_Id);

        System.out.println("Enter new customer name");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            customer.setCustomerName(name);
        }

        System.out.println("Enter new customer address");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            customer.setCustomerAddress(address);
        }

        System.out.println("Enter new customer contact");
        long contact = 0L;
        contact = Long.parseLong(scanner.nextLine());
        if (!(contact == 0L)) {
            customer.setCustomerContact(contact);
        }

        System.out.println("Enter new customer email address");
        String emailId = scanner.nextLine();
        if (!emailId.isEmpty()) {
            customer.setCustomerEmailID(emailId);
        }

        boolean isUpdated = customerRepository.updateCustomerInfo(customer);
        System.out.println(isUpdated ? "Customer info updated successfully." : "Failed to update customer info.");
    }
}
