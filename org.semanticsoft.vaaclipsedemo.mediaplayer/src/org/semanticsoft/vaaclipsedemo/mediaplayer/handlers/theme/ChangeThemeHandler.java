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
package org.semanticsoft.vaaclipsedemo.mediaplayer.handlers.theme;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.semanticsoft.vaaclipse.publicapi.theme.ThemeManager;

/**
 * @author rushan
 *
 */
public class ChangeThemeHandler
{
	@Execute
	public void changeTheme(ThemeManager themeManager, @Named("theme") String theme)
	{
		if (theme != null)
			themeManager.setTheme(theme);
	}
}
