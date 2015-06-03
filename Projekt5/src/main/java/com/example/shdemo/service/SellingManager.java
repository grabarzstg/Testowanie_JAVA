package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Phone;
import com.example.shdemo.domain.Customer;
import com.example.shdemo.domain.Service;

public interface SellingManager {
	
	void addClient(Customer customer);
	List<Customer> getAllClients();
	void deleteClient(Customer customer);
	Customer findCustomerByPesel(String pesel);
	
	Long addNewPhone(Phone phone);
	List<Phone> getAvailablePhones();
	void disposePhone(Customer customer, Phone phone);
	Phone findPhoneById(Long id);

	List<Phone> getOwnedPhones(Customer customer);
	void sellPhone(Long customerId, Long phoneId);

	void addProvider(Service provider);
	List<Service> getAvailableProvider(Phone phone);
}
