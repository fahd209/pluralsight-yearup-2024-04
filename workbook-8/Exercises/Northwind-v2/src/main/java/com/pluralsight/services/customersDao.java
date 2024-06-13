package com.pluralsight.services;

import com.pluralsight.models.Customer;

import java.util.List;

public interface customersDao {
    List<Customer> getAllCustomers();
}
