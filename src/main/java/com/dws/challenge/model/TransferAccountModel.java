package com.dws.challenge.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferAccountModel {

	@NotNull
	private String accountFromId;
	@NotNull
	private String accountToId;
	@NotBlank
	private BigDecimal amount;

}
