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
package org.semanticsoft.vaaclipsedemo.cassandra.app.processor;

import org.eclipse.e4.core.di.annotations.Execute;
import org.semanticsoft.vaaclipsedemo.cassandra.app.CassandraActivator;

/**
 * @author rushan
 *
 */
public class UsersCountProcessor
{
	@Execute
	public void incUserCount()
	{
		CassandraActivator.getInstance().getUserCounter().increment();
	}
}
