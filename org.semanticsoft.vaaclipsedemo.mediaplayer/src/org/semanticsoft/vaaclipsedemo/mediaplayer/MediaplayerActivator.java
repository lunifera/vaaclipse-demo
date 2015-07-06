

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

package org.semanticsoft.vaaclipsedemo.mediaplayer;

import java.util.Date;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.semanticsoft.vaaclipsedemo.mediaplayer.login.UserCounter;

public class MediaplayerActivator implements BundleActivator
{
	private static MediaplayerActivator instance;
	private BundleContext context;
	private UserCounter userCounter;
	private Date startTime;

	public void start(BundleContext context) throws Exception
	{
		instance = this;
		this.context = context;
		this.userCounter = new UserCounter();
		this.startTime = new Date();
	}

	public void stop(BundleContext context) throws Exception
	{
		this.context = null;
		instance = null;
	}

	public static MediaplayerActivator getInstance()
	{
		return instance;
	}

	public BundleContext getBundleContext()
	{
		return context;
	}
	
	public UserCounter getUserCounter()
	{
		return userCounter;
	}
	
	public Date getStartTime()
	{
		return startTime;
	}
}
