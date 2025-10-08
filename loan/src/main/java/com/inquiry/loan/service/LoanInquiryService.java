package com.inquiry.loan.service;

import java.util.List;

import com.inquiry.loan.dto.LoanInquiryDto;

public interface LoanInquiryService {
	LoanInquiryDto createInquiry(LoanInquiryDto loanInquiryDto);

	List<LoanInquiryDto> allInquiries();

	LoanInquiryDto getInquiry(Long id);

	LoanInquiryDto updateInquiry(Long id, LoanInquiryDto loanInquiryDto);

	void deleteInquiry(Long id);
}
