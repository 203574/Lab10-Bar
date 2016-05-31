package it.polito.tdp.model;

public class Tavolo 
{
	private int id;
	private int numPosti;
	private boolean occupato;
	
	public Tavolo(int id,int numPosti) 
	{
		this.id = id;
		this.numPosti = numPosti;
		this.occupato = false;
	}

	public boolean isOccupato() 
	{
		return occupato;
	}

	public void setOccupato(boolean occupato) 
	{
		this.occupato = occupato;
	}

	public int getId() 
	{
		return id;
	}

	public int getNumPosti() 
	{
		return numPosti;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}
