package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Book;
import pl.edu.agh.dronka.shop.model.Electronics;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Music;

public class ItemFilter {

	private Item itemSpec = new Item();
	private Book bookSpec = new Book();
	private Electronics electronicsSpec = new Electronics();
	private Music musicSpec = new Music();


	public Item getItemSpec() {
		return itemSpec;
	}

	public Book getBookSpec() {
		return bookSpec;
	}

	public Electronics getElectronicsSpec() {
		return electronicsSpec;
	}

	public Music getMusicSpec() {
		return musicSpec;
	}

	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		switch(itemSpec.getCategory()){
			case BOOKS:
				Book book = (Book) item;
				if (bookSpec.isHardCase() && !book.isHardCase())
					return false;
				break;

			case ELECTRONICS:
				Electronics electronics = (Electronics) item;
				if(electronicsSpec.isMobile() && !electronics.isMobile())
					return false;
				if(electronicsSpec.isWarranty() && !electronics.isWarranty())
					return false;
				break;

			case MUSIC:
				Music music = (Music) item;
				if(musicSpec.isVideo() && !music.isVideo())
					return false;
				break;
		}

		return true;
	}

}
