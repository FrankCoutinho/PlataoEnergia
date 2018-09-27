
package br.com.plataoenergia.techspec.transformers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/techspec/transformers")
public class TechspecTransformerController
{
	@Autowired
	TechspecTransformerService service;

	@GetMapping("/all")
	public Iterable<TechspecTransformer> getAll()
	{
		return service.getAll();
	}

	@PutMapping("/save")
	public void save(@Valid @RequestBody TechspecTransformer transformer)
	{
		service.save(transformer);
	}

	@DeleteMapping("/delete")
	public void delete(@Valid @RequestBody TechspecTransformer transformer)
	{
		service.delete(transformer);
	}
}
