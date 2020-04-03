package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Book;
import pl.edu.agh.dronka.shop.model.Electronics;
import pl.edu.agh.dronka.shop.model.Music;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter = new ItemFilter();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();

		filter.getItemSpec().setCategory(shopController.getCurrentCategory());
		add(createPropertyCheckbox("Tanie bo polskie", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setPolish(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		add(createPropertyCheckbox("Używany", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setSecondhand(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		switch(shopController.getCurrentCategory()){
			case BOOKS:
				add(createPropertyCheckbox("Twarda okładka", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getBookSpec().setHardCase(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;

			case ELECTRONICS:

				add(createPropertyCheckbox("Mobilny", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getElectronicsSpec().setMobile(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				add(createPropertyCheckbox("Gwarancja", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getElectronicsSpec().setWarranty(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;

			case MUSIC:
				add(createPropertyCheckbox("Wideo", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getMusicSpec().setVideo(
								((JCheckBox) event.getSource()).isSelected());
						shopController.filterItems(filter);
					}
				}));
				break;
		}
	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
