package com.amit.book.inventory.model;

import lombok.Data;

@Data
public class Supplier {

    private int supplierID;
    private String supplierName;
    private String supplierAddress;
    private Long supplierContact;
    private String supplierEmailId;

}
