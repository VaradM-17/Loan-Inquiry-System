package com.lsp.LSP.controller;

import com.lsp.LSP.entity.LspEntity;
import com.lsp.LSP.service.LspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class LspController {

	@Autowired
	private LspService lspService;

	@PostMapping("/add")
	public ResponseEntity<LspEntity> createCustomer(@RequestBody LspEntity customer) {
		LspEntity lsp = lspService.saveCustomer(customer);
		return new ResponseEntity<>(lsp, HttpStatus.CREATED);
	}

	@GetMapping("/findall")
	public ResponseEntity<List<LspEntity>> findAllCustomers() {
		List<LspEntity> lsp = lspService.findAllCustomers();
		return new ResponseEntity<>(lsp, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<LspEntity> findCustomerById(@PathVariable Long id) {
		LspEntity lsp = lspService.findCustomerById(id);
		return new ResponseEntity<>(lsp, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<LspEntity> updateCustomer(@PathVariable Long id, @RequestBody LspEntity customer) {
		customer.setCustomerId(id);
		LspEntity updatedCustomer = lspService.updateCustomer(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		lspService.deleteCustomerById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
