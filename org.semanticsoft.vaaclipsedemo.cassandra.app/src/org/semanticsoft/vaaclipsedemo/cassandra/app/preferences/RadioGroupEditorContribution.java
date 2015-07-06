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
package org.semanticsoft.vaaclipsedemo.cassandra.app.preferences;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.lunifera.vaaclipse.ui.preferences.model.Entry;
import org.lunifera.vaaclipse.ui.preferences.model.RadioGroupFieldEditor;
import org.lunifera.vaaclipse.ui.preferences.model.metadata.PreferencesFactory;

/**
 * @author rushan
 *
 */
public class RadioGroupEditorContribution {
	@Inject
	RadioGroupFieldEditor editor;
	
	@Inject
	PreferencesFactory factory;
	
	@PostConstruct
	public void init() {
		addOption("contrib-option-1", "This is contributed option-1");
		addOption("contrib-option-2", "This is contributed option-2");
		addOption("contrib-option-3", "This is contributed option-3");
	}
	
	public void addOption(String key, String value) {
		Entry entry = factory.createEntry();
		entry.setValue(key);
		entry.setName(value);
		editor.getEntries().add(entry);
	}
}
