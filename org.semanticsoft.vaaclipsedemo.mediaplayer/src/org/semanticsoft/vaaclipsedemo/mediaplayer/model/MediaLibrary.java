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
public class MediaLibrary extends MediaCategory 
{
	private MediaEntry selectedMedia;
	
	public MediaEntry getSelectedMediaEntry()
	{
		return selectedMedia;
	}
	
	public void setSelectedMediaEntry(MediaEntry selectedMedia)
	{
		this.selectedMedia = selectedMedia;
	}
	
	@Override
	protected void mediaEntryRemoved(MediaEntry mediaEntry)
	{
		if (this.selectedMedia == mediaEntry)
			this.selectedMedia = null;
	}
}
