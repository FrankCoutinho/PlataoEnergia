
package br.com.plataoenergia.transformers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerService
{
	@Autowired
	TransformerRepository repository;

	public Iterable<TransformerBean> getAll()
	{
		return repository.findAll();
	}
	
	public void create(TransformerBean transformer)
	{
		Optional<TransformerBean> result = repository.findByBrandIgnoreCaseAndNameIgnoreCase(transformer.getBrand(), transformer.getName());

		if (result.isPresent())
			throw new RuntimeException("Já existe um transformador com o mesmo modelo e marca");

		repository.save(transformer);
	}

	public void update(TransformerBean transformer)
	{
		Optional<TransformerBean> result = repository.findByBrandIgnoreCaseAndNameIgnoreCase(transformer.getBrand(), transformer.getName());

		if (result.isPresent())
			if (result.get().getId() != transformer.getId())
				throw new RuntimeException("Já existe um transformador com o mesmo modelo e marca");

		repository.save(transformer);
	}

	public void delete(TransformerBean transformer)
	{
		repository.delete(transformer);
	}
}
