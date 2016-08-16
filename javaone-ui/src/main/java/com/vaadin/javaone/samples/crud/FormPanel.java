package com.vaadin.javaone.samples.crud;

import com.vaadin.ui.CssLayout;

public class FormPanel extends CssLayout {
	public FormPanel() {
		setStyleName("product-form-wrapper");
	}
	
	public void show() {
        addStyleName("visible");
        setEnabled(true);
	}
	
	public void hide() {
        removeStyleName("visible");
        setEnabled(false);
	}
}
