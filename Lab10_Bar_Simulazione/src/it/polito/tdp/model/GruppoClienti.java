package it.polito.tdp.model;

public class GruppoClienti
{
	private int id;
	private int numero;
	private int durata;
	private float tolleranza;
	private Tavolo tavolo;

	public GruppoClienti(int id,int numero, int durata, float tolleranza)
	{
		super();
		this.id = id;
		this.numero = numero;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}
	public int getId() 
	{
		return id;
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
		GruppoClienti other = (GruppoClienti) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public int getNumero() 
	{
		return numero;
	}
	public int getDurata()
	{
		return durata;
	}
	public float getTolleranza() 
	{
		return tolleranza;
	}
	@Override
	public String toString()
	{
		return "GruppoClienti [numero=" + numero + ", durata=" + durata + "]";
	}
	
	public Tavolo getTavolo()
	{
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) 
	{
		this.tavolo = tavolo;
	}
	
}
