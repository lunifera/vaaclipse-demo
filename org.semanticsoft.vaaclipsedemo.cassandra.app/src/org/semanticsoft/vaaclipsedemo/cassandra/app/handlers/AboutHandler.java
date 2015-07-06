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
package org.semanticsoft.vaaclipsedemo.cassandra.app.handlers;

import com.vaadin.ui.UI;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.semanticsoft.vaadin.optiondialog.OptionDialog;

/**
 * @author rushan
 *
 */
public class AboutHandler
{
	@Execute
	public void about(UI ui)
	{
		OptionDialog.show(ui, "About", String.format("Cassandra - demo application for Vaaclipse Framework"), new String[] {"OK"}, 500, 150, Component.UNITS_PIXELS, OptionDialog.CLOSE_LISTENER);
	}
}
