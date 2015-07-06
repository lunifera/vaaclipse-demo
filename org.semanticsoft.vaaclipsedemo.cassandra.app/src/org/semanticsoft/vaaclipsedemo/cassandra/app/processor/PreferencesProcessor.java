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

import e4modelextension.VaaclipseApplication;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.core.di.annotations.Execute;

/**
 * @author rushan
 *
 */
public class PreferencesProcessor {

	@Execute
	public void setupPreferences(VaaclipseApplication app) {
		VaaclipseApplication vaaclipseApp = (VaaclipseApplication) app;
		System.out.println(vaaclipseApp.getPreferencesCategories().get(0).getName());
	}

}
