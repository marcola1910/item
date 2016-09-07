/**
 *
 */
package org.exnihilo.Item.spring;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;


public class ServiceExceptionInterceptor implements MethodInterceptor,
		Serializable {

	private static final long serialVersionUID = -8154257445586066644L;

	/**
	 * Constructor.
	 */
	public ServiceExceptionInterceptor() {

	}

	
	@Override
	public Object invoke(MethodInvocation aMethodInvocation) throws Throwable {
		try {

			return aMethodInvocation.proceed();

		} catch (Throwable e) {

			if (e.getClass().equals(
					HibernateOptimisticLockingFailureException.class)) {

				throw new ItemConcurrentModificationException();

			} else {

				// throw new ItemGenericException();
				throw e;

			}
		}
	}

}
