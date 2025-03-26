package com.lsp.LSP.service;

import com.lsp.LSP.dao.LspDao;
import com.lsp.LSP.entity.LspEntity;
import com.lsp.LSP.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LspService {

	@Autowired
	private LspDao lspDao;

	public LspEntity saveCustomer(LspEntity customer) {
		return lspDao.save(customer);
	}

	public List<LspEntity> findAllCustomers() {
		return lspDao.findAll();
	}

	public LspEntity findCustomerById(Long id) {
		return lspDao.findCustomerByCustomerId(id)
				.orElseThrow(() -> new UserNotFoundException("Customer by id " + id + " was not found."));
	}

	public LspEntity updateCustomer(LspEntity lspEntity) {
		return lspDao.save(lspEntity);
	}

	public void deleteCustomerById(Long id) {
		lspDao.deleteCustomerByCustomerId(id);
	}
}