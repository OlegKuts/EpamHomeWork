package city;

import java.util.HashMap;
import java.util.Map;

public class City {
	private String cityName;
	private int population;
	Map<String, CityComponent> map = new HashMap<String, CityComponent>();

	enum ComponentType {
		Street, Square, Bulevar
	}

	enum ComponentLocation {
		UpTown, DownTown
	}

	public City(String cityName, int population) {
		this.cityName = cityName;
		this.population = population;
	}

	@SuppressWarnings("unused")
	private static class CityComponent {

		private String componentName;
		private ComponentType type;
		private double square;
		private ComponentLocation location;

		public CityComponent(String componentName, ComponentType type,
				double square, ComponentLocation location) {
			this.componentName = componentName;
			this.type = type;
			this.square = square;
			this.location = location;
		}

	}

	public void addCityComponent(String componentName, ComponentType type,
			double square, ComponentLocation location) {
		map.put(componentName, new CityComponent(componentName, type, square,
				location));
	}

	public CityComponent getCityComponent(String componentName) {
		return map.get(componentName);
	}

	public void changeCityComponentName(String oldName, String newName) {
		CityComponent curComponent = map.remove(oldName);
		curComponent.componentName = newName;
		map.put(newName, curComponent);
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCityName() {
		return cityName;
	}
}
