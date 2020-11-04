package clasesDAOImplHibernateJPA;

import clasesDAO.OrganizadorDAO;
import modelos.Organizador;

public class OrganizadorDAOHibernateJPA extends GenericDAOHibernateJPA<Organizador> implements OrganizadorDAO{
	 
	public OrganizadorDAOHibernateJPA() {
		super(Organizador.class);
	 }

}
