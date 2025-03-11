package BOOKSMANAGEMENT;

import java.util.Scanner;

public class BOOK {
	//Class data
	public int sNo;
	public String bookName;
	public String authorName;
	public int bookQty;
	public int bookQtyCopy;
	

	//Contructor book
	public BOOK(int sNo, String bookName, String authorName, int bookQty, int bookQtyCopy) {
		this.sNo = sNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookQty = bookQty;
		this.bookQtyCopy = bookQtyCopy;
	}
	
	//Hien thi thong tin sach
	public void displayBookInfo() {
		System.out.println("S.No: " + sNo + " | Name: " + bookName + " | Author: " + authorName +
                " | Available Copies: " + bookQtyCopy + "/" + bookQty);
	}
}
