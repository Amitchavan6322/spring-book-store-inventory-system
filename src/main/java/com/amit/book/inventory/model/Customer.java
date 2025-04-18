package com.amit.book.inventory.model;

import lombok.Data;

@Data
public class Customer {

    private int customerID;
    private String customerName;
    private String customerAddress;
    private Long customerContact;
    private String customerEmailID;
}
