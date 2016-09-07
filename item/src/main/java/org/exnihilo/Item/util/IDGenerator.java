package org.exnihilo.Item.util;

import java.util.UUID;

public class IDGenerator { 


	public static String getId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}