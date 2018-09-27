
package br.com.plataoenergia.techspec.transformers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechspecTransformerService
{
	@Autowired
	TechspecTransformerRepository repository;

	public Iterable<TechspecTransformer> getAll()
	{
		return repository.findAll();
	}
	
	public void save(TechspecTransformer transformer)
	{	
		Optional<TechspecTransformer> result = repository.findByBrandIgnoreCaseAndNameIgnoreCase(transformer.getBrand(), transformer.getName());

		if (result.isPresent())
			if (result.get().getId() != transformer.getId())
				throw new RuntimeException("Esse transformador já foi cadastrado para esse fornecedor");

		repository.save(transformer);
	}
	
	public void delete(TechspecTransformer transformer)
	{
		repository.delete(transformer);
	}
}
