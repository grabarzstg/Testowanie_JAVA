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

	private final String NAME_1 = "Ryszard";
	private final String PESEL_1 = "73031393833";
	private final String OCCUP_1 = "Handlarz";

	private final String NAME_2 = "Marian";
	private final String PESEL_2 = "51021825563";
	private final String OCCUP_2 = "Stolarz";

	private final String CPB_1 = "Intel";
	private final String CPU_1 = "Pentium III";
	private final String GPU_1 = "Intel Integrated";
	private final String HDD_1 = "WD5000MB";

	private final String CPB_2 = "AMD";
	private final String CPU_2 = "Athlon X2";
	private final String GPU_2 = "Radeon 4890HD";
	private final String HDD_2 = "MX42000MB";

	private final String CPB_3 = "Intel";
	private final String CPU_3 = "Atom";
	private final String GPU_3 = "GeForce 320";
	private final String HDD_3 = "BC3500GB";
	
	private final String SVN_1 = "Intel";
	private final String SVS_1 = "Professional";
	private final String SVC_1 = "33102";
	
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
		computer.setBrand(CPB_1);
		computer.setCpu(CPU_1);
		computer.setSeries(GPU_1);
		computer.setModel(HDD_1);
		// ... other properties here

		Long computerId = sellingManager.addNewPhone(computer);

		Phone retrievedComputer = sellingManager.findPhoneById(computerId);
		assertEquals(CPB_1, retrievedComputer.getBrand());
		assertEquals(CPU_1, retrievedComputer.getCpu());
		assertEquals(GPU_1, retrievedComputer.getSeries());
		assertEquals(HDD_1, retrievedComputer.getModel());
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
		computer.setBrand(CPB_2);
		computer.setCpu(CPU_2);
		computer.setSeries(GPU_2);
		computer.setModel(HDD_2);

		Long computerId = sellingManager.addNewPhone(computer);

		sellingManager.sellPhone(retrievedCustomer.getId(), computerId);

		List<Phone> ownedComputers = sellingManager.getOwnedPhones(retrievedCustomer);

		assertEquals(1, ownedComputers.size());
		assertEquals(CPB_2, ownedComputers.get(0).getBrand());
		assertEquals(CPU_2, ownedComputers.get(0).getCpu());
		assertEquals(GPU_2, ownedComputers.get(0).getSeries());
		assertEquals(HDD_2, ownedComputers.get(0).getModel());
	}

	@Test
	public void computerServiceCheck() {
		
		Phone computer = new Phone();
		computer.setBrand(CPB_3);
		computer.setCpu(CPU_3);
		computer.setSeries(GPU_3);
		computer.setModel(HDD_3);

		sellingManager.addNewPhone(computer);
		
		Provider service = new Provider();
		service.setName(SVN_1);
		service.setCountry(SVS_1);
		service.setCode(SVC_1);

		sellingManager.addProvider(service);

		List<Provider> availableServices = sellingManager.getAvailableProvider(computer);
		
		assertEquals(1, availableServices.size());
		assertEquals(CPB_3, availableServices.get(0).getName());
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
		computer.setCpu(CPU_2);
		computer.setSeries(GPU_2);
		computer.setModel(HDD_2);

		Customer retrievedCustomer = sellingManager.findCustomerByPesel(PESEL_2);
		
		sellingManager.addNewPhone(computer);

		sellingManager.disposePhone(customer, computer);

		List<Phone> ownedComputers = sellingManager.getOwnedPhones(retrievedCustomer);

		assertEquals(0, ownedComputers.size());
	}

}
