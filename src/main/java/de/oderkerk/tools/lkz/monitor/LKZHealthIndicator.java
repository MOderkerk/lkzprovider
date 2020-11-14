package de.oderkerk.tools.lkz.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import de.oderkerk.tools.lkz.repository.LKZRepository;

@Component
public class LKZHealthIndicator implements HealthIndicator {

	@Autowired
	private LKZRepository repository;

	@Override
	public Health health() {
		try {
		long countLKZ = repository.count();
		if (countLKZ > 0){
			return Health.up().withDetail("LKZ Daten",String.valueOf(countLKZ) +" Sätze gefunden").build();
		}
		else {
			return Health.down().withDetail("LKZ Daten","Keine Sätze gefunden.").build();		
		}
		}
		catch (Exception ex){
			return Health.down(ex).build();
		}
		
	
	}
}
