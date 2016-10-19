package utng.datos;


import org.hibernate.HibernateException;

import utng.modelo.Evento;


public class EventoDAO extends DAO<Evento> {

	public EventoDAO() {
		super(new Evento());	
	}
	
	public Evento getOneById(Evento evento) throws HibernateException {
		return super.getOneById(evento.getId());
	}
}
