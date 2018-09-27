package br.com.plataoenergia.equipments.transformers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataoenergia.techspec.transformers.TechspecTransformer;

@Service
public class TransformerEquipmentService
{
	@Autowired
	TransformerEquipmentRepository repository;
	
	public Iterable<TransformerEquipment> getAll()
	{
		return repository.findAll();
	}
	
	public void save(TransformerEquipment equipment)
	{	
		String supplier = equipment.getSupplier();
		TechspecTransformer transformer = equipment.getTransformer();
		
		Optional<TransformerEquipment> result = repository.findBySupplierIgnoreCaseAndTransformer(supplier, transformer);

		if (result.isPresent())
			if (result.get().getId() != equipment.getId())
				throw new RuntimeException("Esse transformador já foi cadastrado para esse fornecedor");

		equipment.setAvailable(true);
		equipment.setLastUpdatedDate(LocalDate.now());
		repository.save(equipment);
	}

	public void delete(TransformerEquipment equipment)
	{
		repository.delete(equipment);
	}
}
