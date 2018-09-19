package br.com.plataoenergia.transformers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerRepository extends CrudRepository<TransformerBean, Long>
{
	@Transactional
	Optional<TransformerBean> findByBrandIgnoreCaseAndNameIgnoreCase(String brand, String name);
}
