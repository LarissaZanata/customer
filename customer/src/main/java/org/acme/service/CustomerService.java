package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.repository.CustomerRepository;



import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class CustomerService {

	@Inject
	private CustomerRepository customerRepository;
	
	public List<CustomerDTO> findAllCustomers(){
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		
		customerRepository.findAll().stream().forEach(item -> {
			customers.add(mapCustomerEntityToDTO(item));
		});
		
		return customers;
	}
	
	public CustomerDTO findCustomerById(Long id) {
		return mapCustomerEntityToDTO(customerRepository.findById(id));
	}
	
	public void createNewCustomer(CustomerDTO customerDTO) {
		customerRepository.persist(mapCustomerEntityToDTO(customerDTO));
	}
	
	public void changeCustomer(Long id, CustomerDTO customerDTO) {
		CustomerEntity customer = customerRepository.findById(id);
		customer.setAddress(customerDTO.getAddress());
		customer.setAge(customerDTO.getAge());
		customer.setName(customerDTO.getName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhone(customerDTO.getPhone());
		
		customerRepository.persist(customer);
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
	private CustomerDTO mapCustomerEntityToDTO(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setAddress(customerEntity.getAddress());
		customerDTO.setAge(customerEntity.getAge());
		customerDTO.setName(customerEntity.getName());
		customerDTO.setEmail(customerEntity.getEmail());
		customerDTO.setPhone(customerEntity.getPhone());
		return customerDTO;
	}
	
	private CustomerEntity mapCustomerEntityToDTO(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setAddress(customerDTO.getAddress());
		customerEntity.setAge(customerDTO.getAge());
		customerEntity.setName(customerDTO.getName());
		customerEntity.setEmail(customerDTO.getEmail());
		customerEntity.setPhone(customerDTO.getPhone());
		return customerEntity;
	}
	
}
