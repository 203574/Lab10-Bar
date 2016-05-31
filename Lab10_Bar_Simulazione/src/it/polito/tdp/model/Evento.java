package it.polito.tdp.model;

public class Evento implements Comparable<Evento>
{
	 enum TipoEvento {GRUPPO_ARRIVA, GRUPPO_PARTE}
	
	private int tempo;
	private TipoEvento tipo;
	private GruppoClienti gruppo;
	
	public Evento(int tempo, TipoEvento tipo, GruppoClienti gruppo) 
	{
		this.tempo = tempo;
		this.tipo = tipo;
		this.gruppo = gruppo;
	}

	public int getTempo() 
	{
		return tempo;
	}

	public TipoEvento getTipo() 
	{
		return tipo;
	}

	public GruppoClienti getGruppo() 
	{
		return gruppo;
	}

	@Override
	public int compareTo(Evento o) 
	{
		
		return this.tempo-o.getTempo();
	}
	
	
}
