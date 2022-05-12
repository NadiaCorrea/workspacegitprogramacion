package com.jacaranda.city;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class City {
	private int cityId;
	private String city;
	private int numDir;
	private Map<Integer, String> addresses;

	public City() {
		super();
		this.addresses = new HashMap<>();
	}

	public City(int cityId, String city, int numDir, Map<Integer, String> addresses) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.numDir = numDir;
		this.addresses = addresses;
	}

	public int getCityId() {
		return cityId;
	}

	private void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	public int getNumDir() {
		return numDir;
	}

	private void setNumDir(int numDir) {
		this.numDir = numDir;
	}

	public Map<Integer, String> getAddresses() {
		return addresses;
	}

	private void setAddresses(Map<Integer, String> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return cityId == other.cityId;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", city=" + city + ", numDir=" + numDir + ", addresses=" + addresses + "]";
	}

}
