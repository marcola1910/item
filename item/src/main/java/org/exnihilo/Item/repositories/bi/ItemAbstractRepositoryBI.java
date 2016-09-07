package org.exnihilo.Item.repositories.bi;

import java.util.Collection;



public interface ItemAbstractRepositoryBI {

	public void delete( Object o)  throws Exception;
	public void deleObjects ( Collection<Object> co  );
	public Object findbyId (String oid);


}
