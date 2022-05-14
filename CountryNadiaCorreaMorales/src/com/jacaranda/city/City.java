package com.jacaranda.city;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.address.Address;

public class City implements Comparable<City> {
	private int cityId;
	private String city;
	private int numDir;
	private List<Address> addresses;

	public City() {
		super();
		this.addresses = new LinkedList<>();
		this.numDir = 0;
	}

	public City(int cityId, String city) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.addresses = new LinkedList<>();
		this.numDir = 0;
	}

	public City(int cityId, String city, int numDir, List<Address> addresses) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.numDir = numDir;
		this.addresses = addresses;
		this.numDir = 0;
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

	private List<Address> getAddresses() {
		return addresses;
	}

	private void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public boolean addAddress(Address address) {
		boolean result = false;

		if (!this.addresses.contains(address)) {
			this.addresses.add(address);
			this.numDir = this.numDir + 1;
		}

		return result;
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

		StringBuilder result = new StringBuilder();

		result.append("City: Id=" + cityId + ", city=" + city + ", numDir=" + numDir + "\n");

		Iterator<Address> iterador = addresses.iterator();
		Address iAddress;
		while (iterador.hasNext()) {
			iAddress = iterador.next();

			result.append(iAddress.toString() + "\n");

		}

		return result.toString();
	}

	@Override
	public int compareTo(City o) {
		// Si hay dos ciudades con el mismo numero de direcciones nombre deberán
		// aparecer ordenadas alfabéticamente.
		int result;
		if (o == null) {
			result = -1;
		} else {
			result = this.numDir - o.getNumDir();

			if (result == 0) {
				result = this.city.compareTo(o.getCity());
			}
		}
		return result;
	}

}
