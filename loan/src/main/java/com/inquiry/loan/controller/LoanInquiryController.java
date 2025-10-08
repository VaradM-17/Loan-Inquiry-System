package com.inquiry.loan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inquiry.loan.dto.LoanInquiryDto;
import com.inquiry.loan.service.LoanInquiryService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/inquiries")
@RestController
public class LoanInquiryController {
	private final LoanInquiryService loanInquiryService;

	@PostMapping("/inquiry")
	public ResponseEntity<LoanInquiryDto> createInquiry(@Valid @RequestBody LoanInquiryDto loanInquiryDto) {
		LoanInquiryDto createInquiry = loanInquiryService.createInquiry(loanInquiryDto);
		return new ResponseEntity<LoanInquiryDto>(createInquiry, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<LoanInquiryDto>> allInquiries() {
		List<LoanInquiryDto> inquiries = loanInquiryService.allInquiries();
		return ResponseEntity.ok(inquiries);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LoanInquiryDto> getInquiry(@PathVariable Long id) {
		LoanInquiryDto inquiries = loanInquiryService.getInquiry(id);
		return ResponseEntity.ok(inquiries);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LoanInquiryDto> updateInquiry(@PathVariable Long id,
			@RequestBody LoanInquiryDto loanInquiryDto) {
		LoanInquiryDto updateInquiry = loanInquiryService.updateInquiry(id, loanInquiryDto);
		return ResponseEntity.ok(updateInquiry);
	}

	@DeleteMapping("/{id}")
	public String deleteInquiry(@PathVariable Long id) {
		loanInquiryService.deleteInquiry(id);
		return "Loan Inquiry deleted ....";
	}

}
