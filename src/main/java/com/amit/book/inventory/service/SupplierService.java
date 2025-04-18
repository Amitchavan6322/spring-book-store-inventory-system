package com.amit.book.inventory.service;

import com.amit.book.inventory.exception.InvalidBookIDException;
import com.amit.book.inventory.exception.InvalidBookNameException;
import com.amit.book.inventory.exception.InvalidBookPriceException;
import com.amit.book.inventory.model.Customer;
import com.amit.book.inventory.model.Supplier;
import com.amit.book.inventory.repository.CustomerRepository;
import com.amit.book.inventory.repository.SupplierRepository;
import com.amit.book.inventory.util.SpringContextUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class SupplierService implements SupplierServiceInterface {

    private Scanner scanner = new Scanner(System.in);

    private static final SupplierRepository supplierRepository = SpringContextUtil.getContext().getBean("supplierRepository", SupplierRepository.class);

    public void acceptingSupplierInfo() throws SQLException {

        Supplier supplier = SpringContextUtil.getContext().getBean("supplier", Supplier.class);

        System.out.println("Enter supplier id");
        int supplierId = Integer.parseInt(scanner.nextLine());
        supplier.setSupplierID(supplierId);

        System.out.println("Enter supplier name");
        String name = scanner.nextLine();
        supplier.setSupplierName(name);

        System.out.println("Enter supplier address");
        String address = scanner.nextLine();
        supplier.setSupplierAddress(address);

        System.out.println("Enter supplier contact number");
        Long contact = Long.valueOf(scanner.nextLine());
        supplier.setSupplierContact(contact);

        System.out.println("Enter supplier Email ID");
        String emailID = scanner.nextLine();
        supplier.setSupplierEmailId(emailID);

        boolean isSupplierAdded = supplierRepository.fillSupplierInfo(supplier);
        System.out.println(isSupplierAdded ? "Supplier entry added in DB" : "Failed to add customer entry in DB");
    }

    public void displaySupplierInfo() throws SQLException {
        supplierRepository.displaySupplierInfo();
    }

    public void getSupplierById(int supplier_Id) throws SQLException {
        supplierRepository.getSupplierById(supplier_Id);
    }

    public void deleteSupplierById(int supplierId) throws SQLException {
        supplierRepository.deleteSupplierById(supplierId);
    }

    public boolean isSupplierExist(int supplierId) throws SQLException {
        return supplierRepository.isSupplierExists(supplierId);
    }

    public void updateSupplierInfo(int supplier_Id) throws InvalidBookNameException, SQLException, InvalidBookIDException, InvalidBookPriceException {
        Supplier supplier = SpringContextUtil.getContext().getBean("supplier", Supplier.class);
        supplier.setSupplierID(supplier_Id);

        System.out.println("Enter new supplier name");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            supplier.setSupplierName(name);
        }

        System.out.println("Enter new supplier address");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            supplier.setSupplierAddress(address);
        }

        System.out.println("Enter new supplier contact");
        long contact = 0L;
        contact = Long.parseLong(scanner.nextLine());
        if (!(contact == 0L)) {
            supplier.setSupplierContact(contact);
        }

        System.out.println("Enter new supplier email address");
        String emailId = scanner.nextLine();
        if (!emailId.isEmpty()) {
            supplier.setSupplierEmailId(emailId);
        }

        boolean isUpdated = supplierRepository.updateSupplierInfo(supplier);
        System.out.println(isUpdated ? "Supplier info updated successfully." : "Failed to update supplier info.");
    }

}
