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
package org.semanticsoft.vaaclipsedemo.mediaplayer.handlers.medialib;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MInputPart;
import org.semanticsoft.e4extension.service.EPartServiceExt;
import org.semanticsoft.vaaclipsedemo.mediaplayer.model.Media;
import org.semanticsoft.vaaclipsedemo.mediaplayer.model.MediaLibrary;

/**
 * @author rushan
 *
 */
public class EditSelectedMedia
{	
	@CanExecute
	public boolean canExecute(MediaLibrary medialib)
	{
		return medialib.getSelectedMediaEntry() instanceof Media;
	}
	
	@Execute
	public void edit(MediaLibrary medialib, EPartServiceExt partServiceExt)
	{
		if (medialib.getSelectedMediaEntry() instanceof Media)
		{
			Media selectedInPlaylist = (Media) medialib.getSelectedMediaEntry();
			MInputPart part = partServiceExt.openUri(selectedInPlaylist.getUri());
			part.setLabel(selectedInPlaylist.getName());
		}
		
	}
}
