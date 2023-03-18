package com.training.inventory.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

	private int carId;
	private String carName;
	private String carBand;
	private String status;
	private String color;
	private double price;

	public Car() {
		super();

	}

	public Car(int carId, String carName, String carBand, double price,String color, String status ) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carBand = carBand;
		this.status = status;
		this.color = color;
		this.price = price;
	}

	public Car(String carName, String carBand, double price, String color, String status) {
		super();
		this.carName = carName;
		this.carBand = carBand;
		this.price = price;
		this.status = status;
		this.color = color;
		
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarBand() {
		return carBand;
	}

	public void setCarBand(String carBand) {
		this.carBand = carBand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return carId == other.carId;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carBand=" + carBand + ", status=" + status
				+ ", color=" + color + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Car o) {

		return this.getCarId() - o.getCarId();
	}

}
