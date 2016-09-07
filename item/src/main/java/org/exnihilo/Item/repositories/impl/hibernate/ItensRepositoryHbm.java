package org.exnihilo.Item.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.ItemType;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.ProyectoSoftware;
import org.exnihilo.Item.model.Usuario;
import org.exnihilo.Item.repositories.bi.ItensRepositoryBI;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ItensRepositoryHbm extends RepositoryHbm implements
		ItensRepositoryBI {

	ItemSys rootobject;

	public ItensRepositoryHbm() {
		// TODO Auto-generated constructor stub
	}

	public ItensRepositoryHbm(ItemSys mItem) {
		this.rootobject = mItem;

	}

	public ItensRepositoryHbm(ItemType mItem) {
		// TODO Auto-generated constructor stub
	}

	public void delete(Object o) throws Exception {
		super.delete(o);

	}

	@Override
	public void deleObjects(Collection<Object> co) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item findbyId(String oid) {

		// crea una consulta desde la sesion seteada al principio en el init del
		// repository
		Query query = super.getSessionFactory().getCurrentSession()
				.createQuery("from Item where oid = :oid ");
		query.setParameter("oid", oid);
		Item _result = (Item) query.uniqueResult();

		return _result;
	}

	@Override
	public List<Item> findItembySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findItembyType(ItemType itemtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findItembyAssignment(Usuario miembro) {

		Query query = super.getSessionFactory().getCurrentSession()
				.createQuery("from Item as i where i.asignado.oid = :oid ");
		query.setParameter("oid", miembro.getOid());
		return query.list();
		
		
	}

	@Override
	public List<Item> findItembyProyecto(ProyectoSoftware proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findItembyEstado(Nodo estado) {

		//"Select count(i) from zinbig.item.model.projects.Project p "
		//+ "join p.itemProperties i where p.oid =:anOid"
		
		//from Cat as cat where cat.mate.name like
		Query query = super.getSessionFactory().getCurrentSession()
				.createQuery("from Item as i where i.estado.oid = :oid ");
		query.setParameter("oid", estado.getOid());
		return query.list();

	}

	@Override
	public int itemExiste(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item getItemById(String itemId) {

		return null;
	}

	@Override
	public List<Item> getAll() {

		Query query = super.getSessionFactory().getCurrentSession()
				.createQuery("from Item ");

		return query.list();
	}

}
