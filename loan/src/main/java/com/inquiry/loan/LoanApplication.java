package com.inquiry.loan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Loan Finance System",
        version = "1.0",
        description = "API documentation for the Loan Finance System."
    ),
    externalDocs = @ExternalDocumentation(
        description = "GitHub Repository",
        url = "https://github.com/VaradM-17/Loan-Inquiry-System.git"
    )
)
public class LoanApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
        System.out.println("Application Started...");
    }
}
