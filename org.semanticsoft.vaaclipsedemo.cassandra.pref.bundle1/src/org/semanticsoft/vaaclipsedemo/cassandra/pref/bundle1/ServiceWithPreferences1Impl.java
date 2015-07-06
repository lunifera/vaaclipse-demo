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
package org.semanticsoft.vaaclipsedemo.cassandra.pref.bundle1;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.prefs.Preferences;
import org.osgi.service.prefs.PreferencesService;
import org.semanticsoft.vaaclipsedemo.cassandra.pref.api.ServiceWithPreferences;

/**
 * @author rushan
 *
 */
@Component(property = {"(provider=bundle1)"}, service = ServiceWithPreferences.class)
public class ServiceWithPreferences1Impl implements ServiceWithPreferences {

	private PreferencesService osgiPreferencesService;

	@Reference(service = PreferencesService.class)
	public void bindPrefrencesService(PreferencesService osgiPreferencesService) {
		
		this.osgiPreferencesService = osgiPreferencesService;
		
	}
	
	@Activate
	public void activate() {
		
	}

	@Override
	public Preferences getSystemPreferences() {
		return osgiPreferencesService.getSystemPreferences();
	}

	@Override
	public Preferences getUserPrefrences(String user) {
		return osgiPreferencesService.getUserPreferences(user);
	}
	
	
}
