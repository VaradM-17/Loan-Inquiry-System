package com.inquiry.loan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Loan Inquiry DTO - holds customer inquiry details.")
public class LoanInquiryDto {

	private Long id;

	@NotEmpty
	@Schema(description = "Applicant name", example = "Varad Mule")
	private String name;

	@NotEmpty
	@Size(min = 10)
	@Schema(description = "Mobile number", example = "9876543210")
	private String mobileNumber;

	@NotEmpty
	@Email(message = "Invalid email address")
	@Schema(description = "Email address", example = "varad@example.com")
	private String email;

	@NotEmpty
	@Schema(description = "Address", example = "123 XYZ Road, Pune")
	private String address;

	@NotEmpty
	@Schema(description = "Work type", example = "Job")
	private String workType;

	@NotEmpty
	@Schema(description = "Organization name", example = "Tech Pvt Ltd")
	private String organizationName;

	@NotNull
	@Schema(description = "Annual income", example = "500000")
	private Double annualIncome;

	@NotNull
	@Schema(description = "Past loan history", example = "No")
	private Boolean pastLoan;

	@NotEmpty
	@Schema(description = "PAN card number", example = "ABCDE1234F")
	private String panCard;
}
