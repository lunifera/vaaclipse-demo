package com.vaadin.addon.toolbar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.vaadin.peter.contextmenu.ContextMenu;
import org.vaadin.peter.contextmenu.ContextMenu.ClickEvent;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItem;

import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;

/*
 * This uses NativeButtons and some of the css from the tutorial. The tutorial states that
 * NativeButtons work better for this purpose.
 */
public class NativeToolbar extends HorizontalLayout implements Toolbar {

    private static final long serialVersionUID = 2666221646559979346L;
    private static final ThemeResource menuArrow = new ThemeResource(
            "../images/bullet_arrow_down.png");
    private final String height;
    private Map<Button, ContextMenu> menus = new HashMap<Button, ContextMenu>();
    private Map<String, Command> actions = new HashMap<String, Command>();
    public int numStyles = 0;

    public NativeToolbar(final String height) {
        this.height = height;
        setMargin(false);
        setHeight(height);
        this.addStyleName("rounded-corners");
    }

    @Override
    public Button createAndAddButton(final String caption, final Resource icon, final String width) {
        final Button b = createButton(caption, icon, width);
        addComponent(b);
        updateButtonStyles();
        return b;
    }

    @Override
    public Button createAndAddButton(final String caption, final Resource icon) {
        final Button b = createButton(caption, icon);
        addComponent(b);
        updateButtonStyles();
        return b;
    }

    @Override
    public Button createButton(final String caption, final Resource icon, final String width) {
        final Button b = new NativeButton(caption);
        b.addStyleName("small-text");
        b.addStyleName("center-icon");
        b.addStyleName("line-wrap");
        b.addStyleName("no-idea");
        b.addStyleName("transparent-background");
        b.setIcon(icon);
        b.setImmediate(true);
        b.setWidth(width);
        b.setHeight(height);
        return b;
    }

    @Override
    public Button createButton(final String caption, final Resource icon) {
        return createButton(caption, icon, "-1px");
    }

    @Override
    public Button createMenu(final String caption, final String width) {
        final Button b;
        if (null == width) {
            b = createButton(caption, menuArrow);
        } else {
            b = createButton(caption, menuArrow, width);
        }
        b.addStyleName("icon-on-right");
        final ContextMenu cm = new ContextMenu();
        this.addComponent(cm);
        cm.addListener(this);
        b.addListener(new ClickListener() {
            private static final long serialVersionUID = -3199636718233539982L;
            @Override
            public void buttonClick(final com.vaadin.ui.Button.ClickEvent event) {
                NativeToolbar.this.setDebugId("(" + event.getClientX() + ", " + event.getClientY()
                        + ")");
                // put menu at bottom left of button
                cm.show(event.getClientX() - event.getRelativeX() + 5,
                        event.getClientY() - event.getRelativeY()
                                + (int) NativeToolbar.this.getHeight() - 5);
            }
        });
        menus.put(b, cm);
        return b;
    }

    @Override
    public Button createMenu(final String caption) {
        return createMenu(caption, null);
    }

    @Override
    public Button createAndAddMenu(final String caption, final String width) {
        final Button b = createMenu(caption, width);
        super.addComponent(b);
        updateButtonStyles();
        return b;
    }

    @Override
    public Button createAndAddMenu(final String caption) {
        return createAndAddMenu(caption, null);
    }

    /*
     * The menu item needs to have a unique caption
     */
    @Override
    public void addMenuItem(final Button menu, final String caption, final Resource icon,
            final boolean separator, final Toolbar.Command command) {
        final ContextMenu cm = menus.get(menu);
        final ContextMenuItem cmi = cm.addItem(caption);
        actions.put(caption, command);
        cmi.setSeparatorVisible(separator);
        cmi.setIcon(icon);
        if (null == command) {
            cmi.setEnabled(false);
        }
    }

    @Override
    public void contextItemClick(final ClickEvent event) {
        // Get reference to clicked item
        final ContextMenuItem clickedItem = event.getClickedItem();
        final String caption = clickedItem.getName();
        if (actions.containsKey(caption)) {
            final Toolbar.Command command = actions.get(caption);
            if (null != command) {
                command.menuSelected(clickedItem);
            }
        }
    }

    @Override
    public void groupTwoButtons(final Button firstButton, final Button nextButton) {
        firstButton.addStyleName("no-right-border");
        nextButton.addStyleName("no-left-border");
    }

    private void updateButtonStyles() {
        int i = 0;
        Component c = null;
        for (final Iterator<Component> iterator = getComponentIterator(); iterator.hasNext();) {
            c = iterator.next();
            c.removeStyleName("first");
            c.removeStyleName("last");
            if (i == 0) {
                c.addStyleName("first");
            }
            i++;
        }
        if (c != null) {
            c.addStyleName("last");
        }
    }
}
