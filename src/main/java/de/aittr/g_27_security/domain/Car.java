package de.aittr.g_27_security.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "brand")
  private String brand;
  @Column(name = "year")
  private int year;
  @Column(name = "price")
  private double price;

  public Car() {
  }

  public Car(int id, String brand, int year, double price) {
    this.id = id;
    this.brand = brand;
    this.year = year;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Car car = (Car) o;

    if (id != car.id) {
      return false;
    }
    if (year != car.year) {
      return false;
    }
    if (Double.compare(price, car.price) != 0) {
      return false;
    }
    return Objects.equals(brand, car.brand);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = id;
    result = 31 * result + (brand != null ? brand.hashCode() : 0);
    result = 31 * result + year;
    temp = Double.doubleToLongBits(price);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", brand='" + brand + '\'' +
        ", year=" + year +
        ", price=" + price +
        '}';
  }
}
