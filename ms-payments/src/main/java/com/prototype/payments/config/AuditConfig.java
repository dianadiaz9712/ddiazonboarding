package com.prototype.payments.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditConfig implements  AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		String nameUser = "ddiaz";//"SecurityContextHolder.getContext().getAuthentication().getName()";
		return Optional.of(nameUser);
	}

}
