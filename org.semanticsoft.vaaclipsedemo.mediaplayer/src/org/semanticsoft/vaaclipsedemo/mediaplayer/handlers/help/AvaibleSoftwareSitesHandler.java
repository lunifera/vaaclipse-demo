

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

package org.semanticsoft.vaaclipsedemo.mediaplayer.handlers.help;

import org.eclipse.e4.core.di.annotations.Execute;
import org.semanticsoft.vaaclipse.p2.sites.ui.ISitesView;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class AvaibleSoftwareSitesHandler {
	@Execute
	public void execute(ISitesView sitesView, UI ui) {
		// TODO Your code goes here

		Window window = new Window("Install new Software");

		window.setContent((Component) sitesView.getUIComponent());
		window.center();

		ui.addWindow(window);
	}

}