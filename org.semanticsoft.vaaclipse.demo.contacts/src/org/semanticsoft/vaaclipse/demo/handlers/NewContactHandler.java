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
package org.semanticsoft.vaaclipse.demo.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class NewContactHandler {
	
	@CanExecute
	public boolean ce(EPartService ps){
		return ps.findPart("new.contact.part")==null;
	}
	
	@Execute
	public void execute(EModelService modelService, MApplication app, EPartService partService) {
		MPartStack partStack = (MPartStack) modelService.find("contacts.stack", app);
		MPart part = partService.createPart("new.contact.part");
		partStack.getChildren().add(part);
		partService.activate(part);
	}
		
}