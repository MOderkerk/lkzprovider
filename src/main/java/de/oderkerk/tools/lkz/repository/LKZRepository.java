/**
 * 
 */
package de.oderkerk.tools.lkz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import de.oderkerk.tools.lkz.entity.LKZEntity;

/**
 * Crud Repository for all DB Operations regarding the LKZEntity
 * @author Odin
 * @version 11-2020
 */
public interface LKZRepository extends CrudRepository<LKZEntity, String> {
	
	public Optional<LKZEntity> findByIso316612(String isoString);
	
	public Optional<LKZEntity> findByIso316613(String isoString);
	
	public List<LKZEntity> findByKfzKennzeichen(String kfzKennzeichen);

}
