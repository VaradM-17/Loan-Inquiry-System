package com.inquiry.loan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.inquiry.loan.dto.LoanInquiryDto;
import com.inquiry.loan.entity.LoanInquiry;
import com.inquiry.loan.exception.ResourceNotFoundException;
import com.inquiry.loan.repository.LoanInquiryRepository;
import com.inquiry.loan.service.LoanInquiryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanInquiryServiceImpl implements LoanInquiryService {

	private final LoanInquiryRepository loanInquiryRepository;
	private final ModelMapper modelMapper;

	@Override
	public LoanInquiryDto createInquiry(LoanInquiryDto loanInquiryDto) {
		LoanInquiry loanInquiry = modelMapper.map(loanInquiryDto, LoanInquiry.class);
		LoanInquiry createInquiry = loanInquiryRepository.save(loanInquiry);
		return modelMapper.map(createInquiry, LoanInquiryDto.class);
	}

	@Override
	public List<LoanInquiryDto> allInquiries() {
		List<LoanInquiry> inquiries = loanInquiryRepository.findAll();
		return inquiries.stream().map(inquiry -> modelMapper.map(inquiry, LoanInquiryDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public LoanInquiryDto getInquiry(Long id) {
		LoanInquiry inquiry = loanInquiryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inquiry does not exists by " + id));
		return modelMapper.map(inquiry, LoanInquiryDto.class);
	}

	@Override
	public LoanInquiryDto updateInquiry(Long id, LoanInquiryDto loanInquiryDto) {
		LoanInquiry inquiry = loanInquiryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inquiry does not exists by " + id));

		inquiry.setName(loanInquiryDto.getName());
		inquiry.setMobileNumber(loanInquiryDto.getMobileNumber());
		inquiry.setEmail(loanInquiryDto.getEmail());
		inquiry.setAddress(loanInquiryDto.getAddress());
		inquiry.setWorkType(loanInquiryDto.getWorkType());
		inquiry.setAnnualIncome(loanInquiryDto.getAnnualIncome());
		inquiry.setPastLoan(loanInquiryDto.getPastLoan());
		inquiry.setPanCard(loanInquiryDto.getPanCard());

		LoanInquiry updateInquiry = loanInquiryRepository.save(inquiry);

		return modelMapper.map(updateInquiry, LoanInquiryDto.class);
	}

	@Override
	public void deleteInquiry(Long id) {
		LoanInquiry inquiry = loanInquiryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inquiry does not exists by " + id));

		loanInquiryRepository.deleteById(id);
	}

}
