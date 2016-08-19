package com.vaadin.javaone.samples.about;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.Version;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class StatsView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "Statistics";

    public StatsView() {

    	/**
    	 * Uncomment the following to show how to add a spreadsheet with charts to your app
    	 */
    	
//        Spreadsheet externalStats = null;
//		try {
//			externalStats = new Spreadsheet(getClass().getResourceAsStream("/Stats.xlsx"));
//		} catch (IOException e) {
//			// IMPOSSIBLE I TELL YOU!! :)
//			e.printStackTrace();
//		}
//		externalStats.setSizeFull();
//        addComponent(externalStats);
        
        setSizeFull();
        setStyleName("about-view");
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
