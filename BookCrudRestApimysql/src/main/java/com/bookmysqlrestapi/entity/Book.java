package com.bookmysqlrestapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="book")
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookid;
	
	@NotBlank
	private String bookTitle;
	@NotBlank
	private String author;
	@NotBlank
	private String publication;
	
	private Integer price;
	
	private Integer noOfPages;
	
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookTitle=" + bookTitle + ", author=" + author + ", publication="
				+ publication + ", price=" + price + ", noOfPages=" + noOfPages + "]";
	}
	
	
	

}
