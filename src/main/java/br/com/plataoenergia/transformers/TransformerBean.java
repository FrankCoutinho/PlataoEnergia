
package br.com.plataoenergia.transformers;

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
@Table(name = "transformers")
public class TransformerBean
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "A marca não pode ser nula")
	@Size(min = 1, max = 255, message = "A marca deve conter entre 1 e 255 caracteres")
	private String brand;

	@NotNull(message = "O nome não pode ser nulo")
	@Size(min = 1, max = 255, message = "O nome deve conter entre 1 e 255 caracteres")
	private String name;

	@Positive(message = "A potência aparente deve ser maior do que zero")
	private double apparentPower;

	@Positive(message = "A tensão primária deve ser maior do que zero")
	private double primaryVoltage;

	@Positive(message = "A tensão secundária deve ser maior do que zero")
	private double secondaryVoltage;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O tipo de conexão não pode ser nulo")
	private ACConnectionType connectionType;

	public TransformerBean()
	{
	}

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
	public boolean equals(Object object)
	{
		if (this == object)
			return true;

		if (object == null)
			return false;

		if (getClass() != object.getClass())
			return false;

		TransformerBean other = (TransformerBean) object;

		if (brand == null)
		{
			if (other.brand != null)
				return false;
		} else
			if (!brand.equals(other.brand))
				return false;

		if (name == null)
		{
			if (other.name != null)
				return false;
		} else
			if (!name.equals(other.name))
				return false;

		return true;
	}

	@Override
	public String toString()
	{
		return "TransformerBean [id=" + id + ", brand=" + brand + ", name=" + name + ", apparentPower=" + apparentPower + ", primaryVoltage="
				+ primaryVoltage + ", secondaryVoltage=" + secondaryVoltage + ", connectionType=" + connectionType + "]";
	}
}
