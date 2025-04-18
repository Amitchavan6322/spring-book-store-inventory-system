package com.amit.book.inventory;

import com.amit.book.inventory.controller.BookController;
import com.amit.book.inventory.controller.CustomerController;
import com.amit.book.inventory.controller.SupplierController;
import com.amit.book.inventory.exception.InvalidBookIDException;
import com.amit.book.inventory.exception.InvalidBookNameException;
import com.amit.book.inventory.exception.InvalidBookPriceException;

import java.sql.SQLException;
import java.util.Scanner;

public class BookStoreInventorySystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InvalidBookIDException, SQLException, InvalidBookNameException, InvalidBookPriceException {
        BookController bookController = new BookController();
        CustomerController customerController = new CustomerController();
        SupplierController supplierController = new SupplierController();

        int option = 0;
        do {
            System.out.println("Welcome to the Book Store Inventory System");
            System.out.println("Please select option from below list :");
            System.out.println("1. Go to Book Section");
            System.out.println("2. Go to Customer Section");
            System.out.println("3. Go to Supplier Section");
            System.out.println("0: Exit project");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    bookController.run();
                    break;
                case 2:
                    customerController.run();
                    break;
                case 3:
                    supplierController.run();
                    break;
            }
        }
        while (option != 0);
        System.out.println("THANK YOU!");
    }
}