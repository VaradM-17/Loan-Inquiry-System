package com.inquiry.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inquiry.loan.entity.LoanInquiry;

public interface LoanInquiryRepository extends JpaRepository<LoanInquiry, Long> {}
