package br.com.plataoenergia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person
{
	@Id
	private long id;
	private String firstname;
	private String lastName;

	public long getId()
	{
		return id;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	@Override
	public String toString()
	{
		return "Person [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + "]";
	}	
}
