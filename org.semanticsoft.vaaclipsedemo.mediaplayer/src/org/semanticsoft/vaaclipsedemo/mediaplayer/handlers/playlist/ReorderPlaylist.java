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
package org.semanticsoft.vaaclipsedemo.mediaplayer.handlers.playlist;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.semanticsoft.vaaclipsedemo.mediaplayer.constants.MediaConstants;
import org.semanticsoft.vaaclipsedemo.mediaplayer.model.Playlist;

/**
 * @author rushan
 *
 */
public class ReorderPlaylist
{
	@CanExecute
	public boolean canExecute(Playlist playlist)
	{
		return playlist.getMediaList().size() > 1;
	}
	
	@Execute
	public void reorder(Playlist playlist, IEventBroker eventBroker)
	{
		playlist.reverseMediaList();
		eventBroker.send(MediaConstants.reversePlaylist, playlist);
	}
}
