package LibraryManagementSystem;

public class Book {
	int id;
	String name;
	String status;
	 public Book(int id,String name,String status) {
		 this.id=id;
		 this.name=name;
		 this.status=status;
	 }
	 public String toString() {
		return "Book ID: " + id + ", Name: " + name + ", Status: " + status;
		 
	 }
	 


}
