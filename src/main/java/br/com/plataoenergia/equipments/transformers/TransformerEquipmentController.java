
package br.com.plataoenergia.equipments.transformers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipments/transformers")
public class TransformerEquipmentController
{
	@Autowired
	TransformerEquipmentService service;
	
	@GetMapping("/all")
	public Iterable<TransformerEquipment> getAll()
	{
		return service.getAll();
	}
	
	@PutMapping("/save")
	public void update(@Valid @RequestBody TransformerEquipment equipment)
	{
		service.save(equipment);
	}
	
	@DeleteMapping("/delete")
	public void delete(@Valid @RequestBody TransformerEquipment equipment)
	{
		service.delete(equipment);
	}
}
