

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


package org.semanticsoft.vaaclipse.demo;

import javax.annotation.PostConstruct;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class ContributedPart {
	
	@PostConstruct
	public void postConstruct(VerticalLayout vl) {
		vl.addComponent(new Button("Test button from contributed part"));
	}
	
	
	
	
}