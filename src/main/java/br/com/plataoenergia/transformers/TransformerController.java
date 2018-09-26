
package br.com.plataoenergia.transformers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/techspec/transformers")
public class TransformerController
{
	@Autowired
	TransformerService service;

	@GetMapping("/all")
	public Iterable<TransformerBean> getAll()
	{
		return service.getAll();
	}

	@PostMapping("/create")
	public void create(@Valid @RequestBody TransformerBean transformer)
	{
		service.create(transformer);
	}

	@PostMapping("/update")
	public void update(@Valid @RequestBody TransformerBean transformer)
	{
		service.update(transformer);
	}

	@PostMapping("/delete")
	public void delete(@Valid @RequestBody TransformerBean transformer)
	{
		service.delete(transformer);
	}
}
