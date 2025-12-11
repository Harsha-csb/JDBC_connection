package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class library {
	private static final String URL="jdbc:mysql://localhost:3306/librarydb";
	private static final String USERNAME="root";
	private static final String PASS="12345";
	
	private static Connection getconnection() throws ClassNotFoundException, SQLException   {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		return DriverManager.getConnection(URL,USERNAME,PASS);
	}
	
private static List<Book> books=new ArrayList<Book>();

private static void addbook(Book newbook) {
	books.add(newbook);
	try(Connection con=getconnection()){
	String sql="insert into books(book_id,book_name,status) values (?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, newbook.id);
	ps.setString(2, newbook.name);
	ps.setString(3, newbook.status);
	ps.executeUpdate();
	
	System.out.println("Sucessfull");
	}catch(Exception e) {
		System.out.println(e);
	}
}
private static void display() {
	try(Connection con=getconnection()){
		String sql="select * from books";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Book_Id= "+rs.getInt(1)+" Book_Name= "+rs.getString(2)+" Status= "+rs.getString(3));
		}
		System.out.println(" All books");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

private static void DisplayAvailableBooks() {
	try(Connection con=getconnection()){
	String sql="select * from books where status='Available'";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	while(rs.next()) {
		System.out.println("Book_Id= "+rs.getInt(1)+" Book_Name= "+rs.getString(2)+" Status= "+rs.getString(3));
	}
	System.out.println("This are the available books");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
private static void DisplayUN_AvailableBooks() {
	try(Connection con=getconnection()){
	String sql="select * from books where status='UN_Available'";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	while(rs.next()) {
		System.out.println("Book_Id= "+rs.getInt(1)+" Book_Name= "+rs.getString(2)+" Status= "+rs.getString(3));
	}
	System.out.println("This are the available books");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
//option2
private static void PurchasingBook(int purchase_ID) {
	try(Connection con=getconnection()){
	String sql="UPDATE books SET status='UN_Available' WHERE book_id=?";	
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1,purchase_ID);
	int updatecount=ps.executeUpdate();
	if(updatecount>0) {
		for(Book book : books) {
			if(book.id== purchase_ID) {
				book.status="UN_Available";
				System.out.println("Thank you for purchasing the Book ");
				break;
			}
		} 
	}else {
		System.out.println("Book not found");
	}
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
}

public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	int n;
	System.out.println();
	System.out.println();
	while(true) {
	System.out.println("Choice the below options:");
	System.out.println("1.add book");
	System.out.println("2.purchase books");
	System.out.println("3.Display available books");
	System.out.println("4.Display UN_Available books");
	System.out.println("5.display all the books");
	System.out.println("6.exit");
	
	n= sc.nextInt();
	
	
 switch(n) {
 case 1:
	 System.out.println("Enter id:");
	 int book_id=sc.nextInt();
	 sc.nextLine();
	 System.out.println("Enter Book name:");
	 String book_name=sc.nextLine();
	 Book newbook=new Book(book_id,book_name,"Available");
	 
	
		addbook(newbook);
	
	
	 break;
 case 2:
	 System.out.println("Enter purchasing book ID:");
	 int purchase_ID=sc.nextInt();
	 PurchasingBook(purchase_ID);
	 break;
 case 3:
	 DisplayAvailableBooks();
	 break;
 case 4:
	 DisplayUN_AvailableBooks();
	 break;
 case 5:
	 System.out.println("Displayed all the books");
	 display();
	 break;
 case 6:
	 System.out.println("********Thank you for visiting***********");
	 sc.close();
	 System.exit(0);
	 break;
	 default:
		 System.out.println("Select valid option");
		 break;
 }
	}
}

}
