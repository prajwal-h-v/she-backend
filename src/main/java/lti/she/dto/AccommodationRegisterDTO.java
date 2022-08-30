package lti.she.dto;

import lti.she.entity.Accommodation;

public class AccommodationRegisterDTO {

	String name;
	int ngoId;
	String state;
	String city;
	String addressLane1;
	String addressLane2;
	String pinCode;
	int totalRooms;
	int capacity;
	boolean dayCareCenter;
	
	
	
	@Override
	public String toString() {
		return "AccommodationRegisterDTO [name=" + name + ", ngoId=" + ngoId + ", state=" + state + ", city=" + city
				+ ", addressLane1=" + addressLane1 + ", addressLane2=" + addressLane2 + ", pinCode=" + pinCode
				+ ", totalRooms=" + totalRooms + ", capacity=" + capacity + ", dayCareCenter=" + dayCareCenter + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNgoId() {
		return ngoId;
	}
	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressLane1() {
		return addressLane1;
	}
	public void setAddressLane1(String addressLane1) {
		this.addressLane1 = addressLane1;
	}
	public String getAddressLane2() {
		return addressLane2;
	}
	public void setAddressLane2(String addressLane2) {
		this.addressLane2 = addressLane2;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public int getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean isDayCareCenter() {
		return dayCareCenter;
	}
	public void setDayCareCenter(boolean dayCareCenter) {
		this.dayCareCenter = dayCareCenter;
	}
	
	public Accommodation toAccommodation() {
		Accommodation accommodation = new Accommodation();
		accommodation.setName(name);
		accommodation.setAddressLane1(addressLane1);
		accommodation.setAddressLane2(addressLane2);
		accommodation.setCity(city);
		accommodation.setState(state);
		accommodation.setPinCode(pinCode);
		accommodation.setCapacity(capacity);
		accommodation.setTotalRooms(totalRooms);
		accommodation.setRoomAvailable(totalRooms);
		accommodation.setDayCareCenter(dayCareCenter);
		return accommodation;
		
	}
	
}
