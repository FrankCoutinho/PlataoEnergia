
package br.com.plataoenergia.techspec.transformers;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.plataoenergia.utils.ACConnectionType;

@Entity
@Table(name = "techspecs_transformers")
public class TechspecTransformer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 1, max = 255)
	private String brand;

	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	@Positive
	private double apparentPower;

	@Positive
	private double primaryVoltage;

	@Positive
	private double secondaryVoltage;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ACConnectionType connectionType;

	/* CONSTRUCTORS */
	
	public TechspecTransformer()
	{
	}

	public TechspecTransformer(String brand, 
					   String name, 
					   double apparentPower, 
					   double primaryVoltage, 
					   double secondaryVoltage, 
					   ACConnectionType connectionType)
	{
		this.brand = brand;
		this.name = name;
		this.apparentPower = apparentPower;
		this.primaryVoltage = primaryVoltage;
		this.secondaryVoltage = secondaryVoltage;
		this.connectionType = connectionType;
	}

	/* GETTER METHODS */
	
	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getBrand()
	{
		return brand;
	}

	public double getApparentPower()
	{
		return apparentPower;
	}

	public double getPrimaryVoltage()
	{
		return primaryVoltage;
	}

	public double getSecondaryVoltage()
	{
		return secondaryVoltage;
	}

	public ACConnectionType getConnectionType()
	{
		return connectionType;
	}

	/* SETTER METHODS */
	
	public void setId(long id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public void setApparentPower(double apparentPower)
	{
		this.apparentPower = apparentPower;
	}

	public void setPrimaryVoltage(double primaryVoltage)
	{
		this.primaryVoltage = primaryVoltage;
	}

	public void setSecondaryVoltage(double secondaryVoltage)
	{
		this.secondaryVoltage = secondaryVoltage;
	}

	public void setConnectionType(ACConnectionType connectionType)
	{
		this.connectionType = connectionType;
	}

	/* OVERRIDDEN METHODS */
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString()
	{
		return "TransformerBean [id=" + id + ", brand=" + brand + ", name=" + name + ", apparentPower=" + apparentPower + ", primaryVoltage="
				+ primaryVoltage + ", secondaryVoltage=" + secondaryVoltage + ", connectionType=" + connectionType + "]";
	}
	
	@Override
	public boolean equals(Object object)
	{
		if (this == object)
			return true;

		if (object == null)
			return false;

		if (getClass() != object.getClass())
			return false;

		TechspecTransformer other = (TechspecTransformer) object;

		if (brand == null)
		{
			if (other.brand != null)
				return false;
		} 
		else
			if (!brand.equals(other.brand))
				return false;

		if (name == null)
		{
			if (other.name != null)
				return false;
		} 
		else
			if (!name.equals(other.name))
				return false;

		return true;
	}
}
