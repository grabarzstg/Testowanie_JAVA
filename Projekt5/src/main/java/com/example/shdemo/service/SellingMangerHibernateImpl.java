package com.example.shdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Phone;
import com.example.shdemo.domain.Customer;
import com.example.shdemo.domain.Service;

@Component
@Transactional
public class SellingMangerHibernateImpl implements SellingManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addClient(Customer customer) {
		customer.setId(null);
		sessionFactory.getCurrentSession().persist(customer);
	}
	
	@Override
	public void deleteClient(Customer customer) {
		customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class,
				customer.getId());
		
		// lazy loading here
		for (Phone phone : customer.getPhones()) {
			phone.setSold(false);
			sessionFactory.getCurrentSession().update(phone);
		}
		sessionFactory.getCurrentSession().delete(customer);
	}

	@Override
	public List<Phone> getOwnedPhones(Customer customer) {
		customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class,
				customer.getId());
		// lazy loading here - try this code without (shallow) copying
		List<Phone> phones = new ArrayList<Phone>(customer.getPhones());
		return phones;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAllClients() {
		return sessionFactory.getCurrentSession().getNamedQuery("customer.all")
				.list();
	}

	@Override
	public Customer findCustomerByPesel(String pesel) {
		return (Customer) sessionFactory.getCurrentSession().getNamedQuery("customer.byPesel").setString("pesel", pesel).uniqueResult();
	}


	@Override
	public Long addNewPhone(Phone phone) {
		phone.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(phone);
	}

	@Override
	public void sellPhone(Long customerId, Long phoneId) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, customerId);
		Phone phone = (Phone) sessionFactory.getCurrentSession()
				.get(Phone.class, phoneId);
		phone.setSold(true);
		customer.getPhones().add(phone);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Phone> getAvailablePhones() {
		return sessionFactory.getCurrentSession().getNamedQuery("phone.unsold")
				.list();
	}
	@Override
	public void disposePhone(Customer customer, Phone phone) {

		customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class,
				customer.getId());
		phone = (Phone) sessionFactory.getCurrentSession().get(Phone.class,
				phone.getId());

		Phone toRemove = null;
		// lazy loading here (customer.getPhones)
		for (Phone aPhone : customer.getPhones())
			if (aPhone.getId().compareTo(phone.getId()) == 0) {
				toRemove = aPhone;
				break;
			}

		if (toRemove != null)
			customer.getPhones().remove(toRemove);

		phone.setSold(false);
	}

	@Override
	public Phone findPhoneById(Long id) {
		return (Phone) sessionFactory.getCurrentSession().get(Phone.class, id);
	}

	@Override
	public void addProvider(Service service) {
		service.setId(null);
		sessionFactory.getCurrentSession().persist(service);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Service> getAvailableProvider(Phone phone) {
		return sessionFactory.getCurrentSession().getNamedQuery("service.byBrand").setString("name", phone.getBrand()).list();
	}

}
