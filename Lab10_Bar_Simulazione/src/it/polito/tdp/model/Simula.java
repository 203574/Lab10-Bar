package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.model.Evento.TipoEvento;

public class Simula 
{
	private PriorityQueue<Evento> listaClienti = new PriorityQueue<Evento>();
	private List<GruppoClienti> clienti = new ArrayList<GruppoClienti>();
	private Map<Integer, Tavolo> tavoli = new HashMap<Integer,Tavolo>();
	private int numSoddisfatti=0;
	private int numArrabbiati=0;

	
	public static void main(String[] args) 
	{
		Simula s = new Simula();
		s.simula();
		System.out.println("Numero clienti soddisfatti: "+s.getNumSoddisfatti()+"\nNumero di clienti insoddisfatti: "+s.getNumArrabbiati());

	}

	public void aggiungiTavoli()
	{
		tavoli.put(0, new Tavolo(0, 10));
		tavoli.put(1, new Tavolo(1, 10));
		for (int i = 2; i < 6; i++) 
		{
			tavoli.put(i, new Tavolo(i, 8));
		}
		for (int i = 6; i < 10; i++) 
		{
			tavoli.put(i, new Tavolo(i, 6));
		}
		for (int i = 10; i < 15; i++)
		{
			tavoli.put(i, new Tavolo(i, 4));
		}
	}
	
	public void aggiungiEventi()
	{
		for (int i = 0; i < 2000; i++)
		{
			int n;
			int d;
			float t;
			int time;
			
			do
			{
				n = (int) (Math.random()*10);
			}
			while(n ==0);
			do
			{
				time = (int) (Math.random()*10);
			}
			while(time ==0);
			do
			{
				d = (int) (Math.random()*120);
			}
			while(d<60);
			do
			{
				t = (float) (Math.random());
			}
			while(t>0.9);
			
			GruppoClienti gc = new GruppoClienti(i,n, d, t);
			listaClienti.add(new Evento(time, TipoEvento.GRUPPO_ARRIVA, gc));
			clienti.add(gc);
		}
	}
	
	private void simula() 
	{
		aggiungiTavoli();
		aggiungiEventi();
		while(!listaClienti.isEmpty())
		{
			passo();
		}
	}

	private void passo() 
	{
		Evento e = listaClienti.remove();
		
		switch (e.getTipo()) 
		{
			case GRUPPO_ARRIVA:
				if(!tavoloAssegnato(e.getGruppo()))
				{
					float t = (float)(Math.random());
					e.getGruppo().setTavolo(null);
					if(t<=e.getGruppo().getTolleranza())
					{
						listaClienti.add(new Evento(e.getTempo()+e.getGruppo().getDurata(), TipoEvento.GRUPPO_PARTE, e.getGruppo()));
						numSoddisfatti++;
					}
					else
					{
						listaClienti.add(new Evento(e.getTempo(), TipoEvento.GRUPPO_PARTE, e.getGruppo()));
						numArrabbiati++;
					}
				}
				else
				{
					listaClienti.add(new Evento(e.getTempo()+e.getGruppo().getDurata(), TipoEvento.GRUPPO_PARTE, e.getGruppo()));
					
				}
				break;
			
			case GRUPPO_PARTE:
				
				if(e.getGruppo().getTavolo() != null)
				{
					tavoli.get(e.getGruppo().getTavolo().getId()).setOccupato(false);
					numSoddisfatti++;
				}
				
				break;

			default:
				break;
		}
	}

	private boolean tavoloAssegnato(GruppoClienti gruppo) 
	{
		for (Tavolo t : tavoli.values())
		{
			if(!t.isOccupato() && t.getNumPosti() >= gruppo.getNumero() && gruppo.getNumero() >= (0.5*t.getNumPosti()))
			{
				t.setOccupato(true);
				gruppo.setTavolo(t);
				return true;
			}
		}
		return false;
	}
	
	public int getNumSoddisfatti() 
	{
		return numSoddisfatti;
	}

	public int getNumArrabbiati()
	{
		return numArrabbiati;
	}


}
