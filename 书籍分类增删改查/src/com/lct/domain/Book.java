package com.lct.domain;

public class Book {
private String isbn;
private String name;
private String author;
private String publish;
private String category;
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublish() {
	return publish;
}
public void setPublish(String publish) {
	this.publish = publish;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
@Override
public String toString() {
	return "Book [isbn=" + isbn + ", name=" + name + ", author=" + author + ", publish=" + publish + ", category="
			+ category + "]";
}
public Book(String isbn, String name, String author, String publish, String category) {
	super();
	this.isbn = isbn;
	this.name = name;
	this.author = author;
	this.publish = publish;
	this.category = category;
}
public Book() {
	super();
}


}
