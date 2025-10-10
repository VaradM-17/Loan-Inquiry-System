package com.inquiry.loan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inquiry.loan.dto.LoanInquiryDto;
import com.inquiry.loan.service.LoanInquiryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/inquiries")
@Tag(name = "Loan Inquiries", description = "APIs for managing loan inquiries")
public class LoanInquiryController {

	private final LoanInquiryService loanInquiryService;

	@Operation(summary = "Create a new loan inquiry")
	@PostMapping("/inquiry")
	public ResponseEntity<LoanInquiryDto> createInquiry(@Valid @RequestBody LoanInquiryDto loanInquiryDto) {
		LoanInquiryDto createInquiry = loanInquiryService.createInquiry(loanInquiryDto);
		return new ResponseEntity<>(createInquiry, HttpStatus.CREATED);
	}

	@Operation(summary = "Get all loan inquiries")
	@GetMapping
	public ResponseEntity<List<LoanInquiryDto>> allInquiries() {
		List<LoanInquiryDto> inquiries = loanInquiryService.allInquiries();
		return ResponseEntity.ok(inquiries);
	}

	@Operation(summary = "Get a loan inquiry by ID")
	@GetMapping("/{id}")
	public ResponseEntity<LoanInquiryDto> getInquiry(@PathVariable Long id) {
		LoanInquiryDto inquiry = loanInquiryService.getInquiry(id);
		return ResponseEntity.ok(inquiry);
	}

	@Operation(summary = "Update a loan inquiry by ID")
	@PutMapping("/{id}")
	public ResponseEntity<LoanInquiryDto> updateInquiry(@PathVariable Long id,
			@Valid @RequestBody LoanInquiryDto loanInquiryDto) {
		LoanInquiryDto updateInquiry = loanInquiryService.updateInquiry(id, loanInquiryDto);
		return ResponseEntity.ok(updateInquiry);
	}

	@Operation(summary = "Delete a loan inquiry by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInquiry(@PathVariable Long id) {
		loanInquiryService.deleteInquiry(id);
		return ResponseEntity.ok("Loan Inquiry deleted successfully");
	}
}
