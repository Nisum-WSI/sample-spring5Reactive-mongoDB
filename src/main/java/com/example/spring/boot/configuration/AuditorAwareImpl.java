/**
 * 
 */
package com.example.spring.boot.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 * @author Vijay
 *
 */
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Mr. Chaitanya");
    }

}