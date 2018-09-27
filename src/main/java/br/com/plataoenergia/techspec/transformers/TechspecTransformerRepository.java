package br.com.plataoenergia.techspec.transformers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechspecTransformerRepository extends CrudRepository<TechspecTransformer, Long>
{
	@Transactional
	Optional<TechspecTransformer> findByBrandIgnoreCaseAndNameIgnoreCase(String brand, String name);
}
