
/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */



package org.semanticsoft.vaaclipsedemo.cassandra.app.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserCounter
{
	private AtomicInteger value = new AtomicInteger(0);

	public int getValue()
	{
		return value.get();
	}

	public int increment()
	{
		int v;
		do
		{
			v = value.get();
		}
		while (!value.compareAndSet(v, v + 1));
		return v + 1;
	}
}
