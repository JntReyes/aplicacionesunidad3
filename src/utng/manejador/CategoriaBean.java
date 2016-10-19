package utng.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import utng.datos.CategoriaDAO;
import utng.datos.EventoDAO;
import utng.modelo.Categoria;
import utng.modelo.Evento;



@ManagedBean(name="categoriaBean")
@SessionScoped
public class CategoriaBean implements Serializable {
	
	private List<Categoria> categorias;
	private Categoria categoria;


	public String listar(){
		CategoriaDAO dao = new CategoriaDAO();
		try {
			categorias = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Categorias";
	}
	
	public String eliminar(){
		CategoriaDAO dao = new CategoriaDAO();
		try {
			dao.delete(categoria);
			categorias = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		categoria = new Categoria();	
		return "Agregar";
	}
	
	public String guardar(){
		CategoriaDAO dao = new CategoriaDAO();
		try {
			if (categoria.getId() != 0) {
				dao.update(categoria);
			} else {
				dao.insert(categoria);
			}
			categorias = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}
	
	public String cancelar(){
		return "Cancelar";
	}
	
	public String editar(Categoria categoria){
		this.categoria = categoria;
		return "Editar";
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


}