package com.jacaranda.address;

import java.util.Objects;

public class Address {
	private int addressId;
	private String address;

	public Address() {
		super();
	}

	public Address(int id, String address) {
		super();
		this.addressId = id;
		this.address = address;
	}

	public int getId() {
		return addressId;
	}

	private void setId(int id) {
		this.addressId = id;
	}

	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return addressId == other.addressId;
	}

	@Override
	public String toString() {
		return "Address [id=" + addressId + ", address=" + address + "]";
	}

}
