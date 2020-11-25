package model;

public class Book {
	private int year;
	private String title, ISBN;
	private double price;
	
	public Book(String ISBN, String title, int year, double price) {
		super();
		this.ISBN = ISBN;
		this.year = year;
		this.title = title;
		this.price = price;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}