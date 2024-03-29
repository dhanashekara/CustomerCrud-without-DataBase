package com.bank.customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customer.entity.Customer;
import com.bank.customer.exception.CustomGlobalExceptionHandler;
import com.bank.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Object> addCustomer(@Valid @RequestBody Customer customer) throws IOException {
		return new ResponseEntity<Object>(customerService.addCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("/getCustomer")
	public Object getCustomer(Integer customerId) {
		return customerService.getCustomer(customerId);

	}

	@DeleteMapping("/deleteCustomer")
	public Object deleteCustomer(Integer customerId) throws IOException {

		return customerService.deleteCustomer(customerId);
	}

	@PutMapping("/updateCustomer")
	public Object updateCustomer(Integer customerId, String customerName) throws IOException {
		return customerService.updateCustomer(customerId, customerName);
	}

	/*
	 * @GetMapping("/getAllCustomers") public ResponseEntity<JSONArray>
	 * getAllCustomers() throws IOException, ParseException { return new
	 * ResponseEntity<JSONArray>(customerService.getAllCustomers(), HttpStatus.OK);
	 * }
	 */

	@GetMapping("/getAllCustomers")
	public ResponseEntity<Object> getAllCustomers() throws IOException, ParseException {
		return new ResponseEntity<Object>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@PostMapping("/addMultipleCustomers")
	public ResponseEntity<String> addMultipleCustomers(@Valid @RequestBody ArrayList<Customer> customers) {
		return new ResponseEntity<String>(customerService.addMultipleCustomers(customers), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/getCustomer") public ResponseEntity<String>
	 * getCustomer(@RequestParam(value = "customerId", required = false) Integer
	 * customerId,
	 * 
	 * @RequestParam(value = "customerName", required = false) String customerName,
	 * 
	 * @RequestParam(value = "CustomerRole", required = false) String CustomerRole)
	 * {
	 * 
	 * return null;
	 * 
	 * }
	 */

}
