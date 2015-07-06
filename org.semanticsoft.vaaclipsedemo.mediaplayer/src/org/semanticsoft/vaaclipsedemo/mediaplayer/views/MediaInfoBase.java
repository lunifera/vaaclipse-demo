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
package org.semanticsoft.vaaclipsedemo.mediaplayer.views;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.semanticsoft.vaaclipsedemo.mediaplayer.model.Media;

import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author rushan
 *
 */
public abstract class MediaInfoBase
{

	protected Media media;
	private HorizontalLayout layout = new HorizontalLayout();
	private GridLayout grid;

	public MediaInfoBase(VerticalLayout parent, IEclipseContext context)
	{
		layout.setSizeFull();
		parent.addComponent(layout);
	}
	
	public Media getMedia()
	{
		return media;
	}
	
	public void setMedia(Media media)
	{
		this.media = media;
		
		if (grid == null)
		{
			grid = new GridLayout(2, 3);
			grid.setMargin(true);
			
			int k = 0;
			
			grid.addComponent(new Label("Name: "), 0, k);
			Component nc = getNameComponent();
			nc.setWidth("100%");
			grid.addComponent(nc, 1, k++);
			
			Component uc = getUriComponent();
			if (uc != null)
			{
				grid.addComponent(new Label("URI: "), 0, k);
				uc.setWidth("100%");
				grid.addComponent(uc, 1, k++);
			}
			
			grid.addComponent(new Label("Description: "), 0, k);
			Component dc = getDescriptionComponent();
			dc.setSizeFull();
			grid.addComponent(dc, 1, k);
			layout.addComponent(grid);
			
			grid.setColumnExpandRatio(0, 20);
			grid.setColumnExpandRatio(1, 80);
			
			grid.setRowExpandRatio(k, 100);
			grid.setRowExpandRatio(--k, 20);
			if (--k >= 0)
				grid.setRowExpandRatio(k, 20);
			
			grid.setSizeFull();
		}
		
		insertMedia(media);
	}
	
	protected abstract void insertMedia(Media media);

	protected abstract Component getNameComponent();
	
	protected abstract Component getDescriptionComponent();
	
	protected abstract Component getUriComponent();
}
