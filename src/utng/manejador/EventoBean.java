package utng.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.CategoriaDAO;

import utng.datos.EventoDAO;
import utng.modelo.Categoria;

import utng.modelo.Evento;



@ManagedBean
@SessionScoped
public class EventoBean implements Serializable {

	private List<Evento> eventos;
	private Evento evento;
        private List<Categoria> categorias;
        
        public EventoBean() {
		evento = new Evento(); 
                evento.setCategoria(new Categoria());
	}
        
	public String listar() {
		EventoDAO dao = new EventoDAO();
		try {
			eventos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eventos";
	}

	public String eliminar() {
		EventoDAO dao = new EventoDAO();
		try {
			dao.delete(evento);
			eventos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	
        
        public String agregar(){
		evento = new Evento();
		evento.setCategoria(new Categoria());
		try{
			categorias = new CategoriaDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Agregar";
	}

	public String guardar() {
		EventoDAO dao = new EventoDAO();
		try {
			if (evento.getId() != 0) {
				dao.update(evento);
			} else {
				dao.insert(evento);
			}
			eventos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	
        
        public String editar(Evento evento){
		this.evento = evento;
		try{
			categorias = new CategoriaDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Editar";
	}


	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

	
}
