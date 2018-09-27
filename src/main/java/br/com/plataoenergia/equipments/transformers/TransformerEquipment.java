
package br.com.plataoenergia.equipments.transformers;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.plataoenergia.techspec.transformers.TechspecTransformer;

@Entity
@Table(name = "equipments_transformers")
public class TransformerEquipment
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Positive
	private double price;

	@NotNull
	@Size(min = 1, max = 255)
	private String supplier;

	private boolean isAvailable;

	@NotNull
	@ManyToOne
	@JoinColumn
	private TechspecTransformer transformer;

	private LocalDate lastUpdatedDate;

	/* CONSTRUCTORS */

	public TransformerEquipment()
	{
	}

	public TransformerEquipment(String supplier, TechspecTransformer transformer, double price)
	{
		this.price = price;
		this.supplier = supplier;
		this.transformer = transformer;
	}

	/* GETTERS */

	public long getId()
	{
		return id;
	}

	public double getPrice()
	{
		return price;
	}

	public String getSupplier()
	{
		return supplier;
	}

	public boolean isAvailable()
	{
		return isAvailable;
	}

	public TechspecTransformer getTransformer()
	{
		return transformer;
	}

	public LocalDate getLastUpdatedDate()
	{
		return lastUpdatedDate;
	}

	/* SETTERS */

	public void setId(long id)
	{
		this.id = id;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void setSupplier(String supplier)
	{
		this.supplier = supplier;
	}

	public void setAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}

	public void setTransformer(TechspecTransformer transformer)
	{
		this.transformer = transformer;
	}

	public void setLastUpdatedDate(LocalDate lastUpdatedDate)
	{
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/* OVERRIDDEN METHODS */

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((transformer == null) ? 0 : transformer.hashCode());
		return result;
	}

	@Override
	public String toString()
	{
		return "TransformerEquipment [id=" + id + ", price=" + price + ", supplier=" + supplier + ", transformer=" + transformer
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
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
		
		TransformerEquipment other = (TransformerEquipment) object;
		
		if (supplier == null)
		{
			if (other.supplier != null)
				return false;
		} 
		else
			if (!supplier.equals(other.supplier))
				return false;
		
		if (transformer == null)
		{
			if (other.transformer != null)
				return false;
		} 
		else
			if (!transformer.equals(other.transformer))
				return false;
		
		return true;
	}
}
