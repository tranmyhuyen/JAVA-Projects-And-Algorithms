package BOOKSMANAGEMENT;

import java.util.Scanner;

//Java Program to Illustrate books class
//To Do all the Operations related to Books such as
//add, check-in, check-out,Valid books,Update books


public class BOOKS {
	
	//mang luu danh sach
	BOOK[] theBooks = new BOOK[1000];
	
	//so luong sach hien co
	public static int count;
	
	Scanner input = new Scanner(System.in);
	
	//Method 1: Kiem tra co trung
	public boolean isDuplicateBook(BOOK newBook) {
		for(int i = 0; i < count; i++) {
			if(theBooks[i].bookName.equalsIgnoreCase(newBook.bookName) || theBooks[i].sNo == newBook.sNo) {
				System.out.println("Book already exists with the same name or Serial Number.");
                return true;
			}
		}
		
		return false;
	}
	
	//Method 2: them add book
	public void addBook() {
		System.out.println("\n Enter Serial Number of Book: ");
		int sNo = input.nextInt();
		input.nextLine(); // clear buffer
		
		System.out.println("Enter Book Name: ");
		String bookName = input.nextLine();
		
		System.out.println("Author name of Books: ");
		String authorName = input.nextLine();
		
		System.out.println("Enter Quantity of Books: ");
		int bookQty = input.nextInt();
		
		System.out.println("Enter Quantity Copy of Books: ");
		int bookQtyCopy = input.nextInt();
		
		//tao sach moi
		BOOK newBook = new BOOK(sNo, bookName, authorName, bookQty, bookQtyCopy);
		
		
		if(!isDuplicateBook(newBook)) {
			theBooks[count] = newBook;
			count++;
			System.out.println("✅ Book added successfully!");
		}	
	}
	
	//hien thi danh sach
	public void displayAllBook() {
		if(count == 0) {
			System.out.println("📭 No books available.");
			return;
		}
		System.out.println("\n📚 List of Books:");
		for(int i = 0; i < count; i++) {
			theBooks[i].displayBookInfo();
		}
	}
}
