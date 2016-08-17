package com.vaadin.javaone.samples.crud;

import java.util.Collection;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.javaone.samples.backend.DataService;
import com.vaadin.javaone.samples.backend.data.Availability;
import com.vaadin.javaone.samples.backend.data.Category;
import com.vaadin.javaone.samples.backend.data.Product;
import com.vaadin.server.Page;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Field;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;

/**
 * A form for editing a single product.
 *
 * Using responsive layouts, the form can be displayed either sliding out on the
 * side of the view or filling the whole screen - see the theme for the related
 * CSS rules.
 */
@SuppressWarnings("serial")
public class ProductForm extends ProductFormDesign {

	private SampleCrudLogic viewLogic;
	private BeanFieldGroup<Product> fieldGroup;

	public ProductForm(SampleCrudLogic sampleCrudLogic) {
		viewLogic = sampleCrudLogic;

		category.setMultiSelect(true);
		availability.addItems((Object[]) Availability.values());

		fieldGroup = new BeanFieldGroup<Product>(Product.class);
		fieldGroup.bindMemberFields(this);
		configureFields(fieldGroup.getFields());

		save.addClickListener(this::saveClicked);
		cancel.addClickListener(this::cancelClicked);
		delete.addClickListener(this::deleteClicked);
	}

	public void setCategories(Collection<Category> categories) {
		category.removeAllItems();
		category.addItems(categories);
	}

	public void editProduct(Product product) {
		if (product == null) {
			product = new Product();
		}
		fieldGroup.setItemDataSource(new BeanItem<Product>(product));

		// before the user makes any changes, disable validation error indicator
		// of the product name field (which may be empty)
		productName.setValidationVisible(false);

		// Scroll to the top
		// As this is not a Panel, using JavaScript
		String scrollScript = "window.document.getElementById('" + getId() + "').scrollTop = 0;";
		Page.getCurrent().getJavaScript().execute(scrollScript);
	}

	private void configureFields(Collection<Field<?>> fields) {
		// perform validation and enable/disable buttons while editing
		for (Field<?> field : fieldGroup.getFields()) {
			field.addValueChangeListener(event -> formHasChanged());
			if (field instanceof TextField) {
				((TextField) field).setNullRepresentation("");
			}
		}
	}

	private void saveClicked(ClickEvent event) {
		try {
			fieldGroup.commit();
			DataService.get().updateProduct(fieldGroup.getItemDataSource().getBean());
			// only if validation succeeds
			Product product = fieldGroup.getItemDataSource().getBean();
			viewLogic.saveProduct(product);
		} catch (CommitException e) {
			Notification n = new Notification("Please re-check the fields", Type.ERROR_MESSAGE);
			n.setDelayMsec(500);
			n.show(getUI().getPage());
		}
	}

	private void cancelClicked(ClickEvent event) {
		viewLogic.cancelProduct();
	}

	private void deleteClicked(ClickEvent event) {
		Product product = fieldGroup.getItemDataSource().getBean();
		viewLogic.deleteProduct(product);
	}

	private void formHasChanged() {
		// show validation errors after the user has changed something
		productName.setValidationVisible(true);

		// only products that have been saved should be removable
		boolean canRemoveProduct = false;
		BeanItem<Product> item = fieldGroup.getItemDataSource();
		if (item != null) {
			Product product = item.getBean();
			canRemoveProduct = product.getId() != -1;
		}
		delete.setEnabled(canRemoveProduct);
	}

}
