package com.prototype.sales.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditConfig implements  AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		String nameUser = SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.of(nameUser);
	}

}
