package com.jacaranda.country;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.address.Address;
import com.jacaranda.city.City;

public class Country {
	private int countryId;
	private String country;
	private List<City> cities;

	public Country() {
		super();
		this.cities = new LinkedList<>();
	}

	public Country(int countryId, String country) {
		super();
		this.countryId = countryId;
		this.country = country;
		this.cities = new LinkedList<>();
	}

	public Country(int countryId, String country, List<City> cities) {
		super();
		this.countryId = countryId;
		this.country = country;
		this.cities = cities;
	}

	public int getCountryId() {
		return countryId;
	}

	private void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	private void setCountry(String country) {
		this.country = country;
	}

	private List<City> getCities() {
		return cities;
	}

	private void setCities(List<City> cities) {
		this.cities = cities;
	}

	public boolean addCity(City ciudad) {
		boolean result = false;
		if (!existeCiudad(ciudad)) {
			cities.add(ciudad);
			result = true;
		}
		return result;
	}

	public boolean addAddressCiudad(City ciudad, Address direccion) {
		boolean result = false;

		int indice = this.cities.indexOf(ciudad);
		if (indice >= 0) {
			this.cities.get(indice).addAddress(direccion);
		} else {
			ciudad.addAddress(direccion);
			this.cities.add(ciudad);
		}

		return result;
	}

	public boolean existeCiudad(City ciudad) {
		boolean result = false;

		if (cities.contains(ciudad)) {
			result = true;
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return countryId == other.countryId;
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();

		result.append("COUNTRY: Id=" + countryId + ", country=" + country + "\n");

		Iterator<City> iterador = cities.iterator();
		City iCity;
		while (iterador.hasNext()) {
			iCity = iterador.next();

			result.append(iCity.toString() + "\n");

		}

		return result.toString();
	}

}
