
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
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.semanticsoft.vaaclipse.demo.model.Contact;
import org.semanticsoft.vaaclipse.demo.utils.IContactsEvents;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.VerticalLayout;

public class NewContactPart {
	
	private Button button;
	private Form form;

	@Inject 
	MPart part;
	
	@PostConstruct
	private void pc(VerticalLayout vl, final IEventBroker broker){
		form = new Form();
		Contact contact = new Contact();
		form.setItemDataSource(new BeanItem<Contact>(contact));
		button = new Button("Save");
		vl.addComponent(form);
		vl.addComponent(button);
		button.addListener(new Button.ClickListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void buttonClick(ClickEvent event) {
				form.commit();
				Contact bean = ((BeanItem<Contact>)form.getItemDataSource()).getBean();
				broker.send(IContactsEvents.NEW_CONTACT, bean);
				broker.send(IContactsEvents.UPDATE_NEEDED, new Object());
			}
		});
	}

}
