package pl.edu.agh.dronka.shop.model.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.*;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		switch(item.getCategory()){
			case BOOKS:
				Book book = (Book) item;
				propertiesMap.put("Liczba stron", Integer.toString(book.getPages()));
				propertiesMap.put("Twarda oprawa", book.isHardCase());
				break;
			case ELECTRONICS:
				Electronics electronics = (Electronics) item;
				propertiesMap.put("Gwarancja", Boolean.toString(electronics.isWarranty()));
				propertiesMap.put("Mobilny", Boolean.toString(electronics.isMobile()));
				break;
			case FOOD:
				Food food = (Food) item;
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				propertiesMap.put("Data przydatności do spożycia", dateFormat.format(food.getExpiryDate()));
				break;
			case MUSIC:
				Music music = (Music) item;
				propertiesMap.put("Gwarancja", music.getGenre().getDisplayName());
				propertiesMap.put("Wideo", Boolean.toString(music.isVideo()));
				break;
		}
		
		return propertiesMap;
	}
}
