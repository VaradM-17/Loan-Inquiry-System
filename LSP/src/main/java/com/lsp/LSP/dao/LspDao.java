package com.lsp.LSP.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsp.LSP.entity.LspEntity;

@Repository
public interface LspDao extends JpaRepository<LspEntity, Long> {

	Optional<LspEntity> findCustomerByCustomerId(Long customerId);

	void deleteCustomerByCustomerId(Long customerId);
}
