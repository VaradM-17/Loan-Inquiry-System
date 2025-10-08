package com.inquiry.loan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanInquiryDto {
	@NotEmpty
	private String name;

	@NotEmpty
	@Size(min = 10)
	private String mobileNumber;

	@NotEmpty
	@Email(message = "Invalid email address")
	private String email;

	@NotEmpty
	private String address;

	@NotEmpty
	private String workType;

	@NotEmpty
	private String organizationName;

	@NotNull
	private Double annualIncome;

	@NotEmpty
	private String pastLoan;

	@NotEmpty
	private String panCard;
}
