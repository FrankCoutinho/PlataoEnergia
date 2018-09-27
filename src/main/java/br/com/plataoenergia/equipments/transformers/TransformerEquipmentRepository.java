package br.com.plataoenergia.equipments.transformers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.plataoenergia.techspec.transformers.TechspecTransformer;

@Repository
public interface TransformerEquipmentRepository extends CrudRepository<TransformerEquipment, Long>
{
	@Transactional
	Optional<TransformerEquipment> findBySupplierIgnoreCaseAndTransformer(String brand, TechspecTransformer transformer);
}
