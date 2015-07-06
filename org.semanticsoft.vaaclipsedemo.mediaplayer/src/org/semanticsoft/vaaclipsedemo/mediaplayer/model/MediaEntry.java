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
package org.semanticsoft.vaaclipsedemo.mediaplayer.model;

/**
 * @author rushan
 *
 */
public abstract class MediaEntry
{
	protected String name = "NoName";
	protected MediaCategory parent;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public MediaCategory getParent()
	{
		return parent;
	}
	
	void setParent(MediaCategory parent)
	{
		this.parent = parent;
	}
}
