package br.com.plataoenergia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.plataoenergia.equipments.transformers.TransformerEquipment;
import br.com.plataoenergia.equipments.transformers.TransformerEquipmentService;
import br.com.plataoenergia.techspec.transformers.TechspecTransformer;
import br.com.plataoenergia.techspec.transformers.TechspecTransformerService;
import br.com.plataoenergia.utils.ACConnectionType;

@SpringBootApplication
public class PlatãoEnergiaApplication implements CommandLineRunner
{
	@Autowired
	TechspecTransformerService transformerService;
	
	@Autowired
	TransformerEquipmentService transformerEquipmentService;
	
	public static void main(String[] args)
	{
		SpringApplication.run(PlatãoEnergiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		if (!transformerService.getAll().iterator().hasNext())
			initializeTechSpecTransformers();
		
		if (!transformerEquipmentService.getAll().iterator().hasNext())
			initializeEquipmentTransformers();
	}

	private void initializeTechSpecTransformers()
	{
		transformerService.save(new TechspecTransformer("Minuzzi", "2500TTC003", 25, 380, 220, ACConnectionType.THREE_PHASE));
		transformerService.save(new TechspecTransformer("Minuzzi", "3000TTC003", 30, 380, 220, ACConnectionType.THREE_PHASE));
		transformerService.save(new TechspecTransformer("Minuzzi", "4000TTC003", 40, 380, 220, ACConnectionType.THREE_PHASE));
		transformerService.save(new TechspecTransformer("Minuzzi", "5500TTC003", 55, 380, 220, ACConnectionType.THREE_PHASE));
		transformerService.save(new TechspecTransformer("Minuzzi", "8500TTC003", 85, 380, 220, ACConnectionType.THREE_PHASE));
		transformerService.save(new TechspecTransformer("Minuzzi", "10000TTC003", 100, 380, 220, ACConnectionType.THREE_PHASE));
		transformerService.save(new TechspecTransformer("Minuzzi", "12500TTC003", 125, 380, 220, ACConnectionType.THREE_PHASE));
		transformerService.save(new TechspecTransformer("Minuzzi", "15000TTC003", 150, 380, 220, ACConnectionType.THREE_PHASE));
	}
	
	public void initializeEquipmentTransformers()
	{
		double price = 25_000.00;
		String supplier = "Aldo";
		TechspecTransformer transformer = transformerService.getAll().iterator().next();
		
		transformerEquipmentService.save(new TransformerEquipment(supplier, transformer, price));
	}
}
