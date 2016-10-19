package utng.datos;

import org.hibernate.HibernateException;

import utng.modelo.Categoria;


public class CategoriaDAO extends DAO<Categoria> {

	public CategoriaDAO() {
		super(new Categoria());	
	}
	
	public Categoria getOneById(Categoria categoria) throws HibernateException {
		return super.getOneById(categoria.getId());
	}
}
