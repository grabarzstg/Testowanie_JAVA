package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Phone;
import com.example.shdemo.domain.Customer;
import com.example.shdemo.domain.Provider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SellingManagerTest {

	@Autowired
	SellingManager sellingManager;

	private final String NAME_1 = "Rafał";
	private final String PESEL_1 = "13031393832";
	private final String OCCUP_1 = "Informatyk";

	private final String NAME_2 = "Adam";
	private final String PESEL_2 = "31021825567";
	private final String OCCUP_2 = "Sprzedawca";

	private final String PHN_1 = "Orange";
	private final String PHB_1 = "Nokia";
	private final String PHS_1 = "Lumia";
	private final String PHM_1 = "520";

	private final String PHN_2 = "T-Mobile";
	private final String PHB_2 = "Samsung";
	private final String PHS_2 = "Galaxy";
	private final String PHM_2 = "S3";

	private final String PHN_3 = "Orange";
	private final String PHB_3 = "Microsoft";
	private final String PHS_3 = "Lumia";
	private final String PHM_3 = "640";
	
	private final String PVN_1 = "Orange";
	private final String PVC_1 = "Poland";
	private final String SVC_1 = "PL-01";
	
	@Test
	public void addClientCheck() {

		List<Customer> retrievedClients = sellingManager.getAllClients();

		// If there is a client with PIN_1 delete it
		for (Customer client : retrievedClients) {
			if (client.getPesel().equals(PESEL_1)) {
				sellingManager.deleteClient(client);
			}
		}

		Customer customer = new Customer();
		customer.setName(NAME_1);
		customer.setOccupation(OCCUP_1);
		customer.setPesel(PESEL_1);
		// ... other properties here

		// Pin is Unique
		sellingManager.addClient(customer);

		Customer retrievedClient = sellingManager.findCustomerByPesel(PESEL_1);

		assertEquals(NAME_1, retrievedClient.getName());
		assertEquals(OCCUP_1, retrievedClient.getOccupation());
		assertEquals(PESEL_1, retrievedClient.getPesel());
		// ... check other properties here
	}

	@Test
	public void addComputerCheck() {

		Phone computer = new Phone();
		computer.setNetwork(PHN_1);
		computer.setBrand(PHB_1);
		computer.setSeries(PHS_1);
		computer.setModel(PHM_1);
		// ... other properties here

		Long computerId = sellingManager.addNewPhone(computer);

		Phone retrievedComputer = sellingManager.findPhoneById(computerId);
		assertEquals(PHN_1, retrievedComputer.getNetwork());
		assertEquals(PHB_1, retrievedComputer.getBrand());
		assertEquals(PHS_1, retrievedComputer.getSeries());
		assertEquals(PHM_1, retrievedComputer.getModel());
		// ... check other properties here

	}

	@Test
	public void sellComputerCheck() {

		Customer customer = new Customer();
		customer.setName(NAME_2);
		customer.setOccupation(OCCUP_2);
		customer.setPesel(PESEL_2);

		sellingManager.addClient(customer);

		Customer retrievedCustomer = sellingManager.findCustomerByPesel(PESEL_2);

		Phone computer = new Phone();
		computer.setNetwork(PHN_2);
		computer.setBrand(PHB_2);
		computer.setSeries(PHS_2);
		computer.setModel(PHM_2);

		Long computerId = sellingManager.addNewPhone(computer);

		sellingManager.sellPhone(retrievedCustomer.getId(), computerId);

		List<Phone> ownedComputers = sellingManager.getOwnedPhones(retrievedCustomer);

		assertEquals(1, ownedComputers.size());
		assertEquals(PHN_2, ownedComputers.get(0).getNetwork());
		assertEquals(PHB_2, ownedComputers.get(0).getBrand());
		assertEquals(PHS_2, ownedComputers.get(0).getSeries());
		assertEquals(PHM_2, ownedComputers.get(0).getModel());
	}

	@Test
	public void computerServiceCheck() {
		
		Phone computer = new Phone();
		computer.setNetwork(PHN_3);
		computer.setBrand(PHB_3);
		computer.setSeries(PHS_3);
		computer.setModel(PHM_3);

		sellingManager.addNewPhone(computer);
		
		Provider service = new Provider();
		service.setName(PVN_1);
		service.setCountry(PVC_1);
		service.setCode(SVC_1);

		sellingManager.addProvider(service);

		List<Provider> availableServices = sellingManager.getAvailableProvider(computer);
		
		assertEquals(1, availableServices.size());
		assertEquals(PHN_3, availableServices.get(0).getName());
		assertEquals(true, availableServices.get(0).getActive());
	}
	
	@Test
	public void disposeComputerCheck() {
		
		Customer customer = new Customer();
		customer.setName(NAME_2);
		customer.setOccupation(OCCUP_2);
		customer.setPesel(PESEL_2);

		sellingManager.addClient(customer);

		Phone computer = new Phone();
		computer.setBrand(PHB_2);
		computer.setSeries(PHS_2);
		computer.setModel(PHM_2);

		Customer retrievedCustomer = sellingManager.findCustomerByPesel(PESEL_2);
		
		sellingManager.addNewPhone(computer);

		sellingManager.disposePhone(customer, computer);

		List<Phone> ownedComputers = sellingManager.getOwnedPhones(retrievedCustomer);

		assertEquals(0, ownedComputers.size());
	}

}
