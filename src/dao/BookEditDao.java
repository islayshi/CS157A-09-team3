package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectDB;
import model.Book;

public class BookEditDao 
{
	public int editBook(Book book) throws ClassNotFoundException
	{
	    String updateBook = "UPDATE books "
	    		+ "SET title = ?, year = ?, price = ?, author_id = ? "
	    		+ "WHERE ISBN = ?;";
	    String updateAuthor = "UPDATE authors "
	    		+ "SET first_name = ?, last_name = ? "
	    		+ "WHERE author_id = ?;";
	    String updateInventory = "UPDATE inventory "
	    		+ "SET numberOfBooks = ? "
	    		+ "WHERE ISBN = ?;";
	    int result = 0;
	    int result2 = 0;
	    int result3 = 0;
	    try (Connection con = ConnectDB.connect();) 
        {
        	PreparedStatement preparedStatement = con.prepareStatement(updateBook);
        	preparedStatement.setString(1, book.getTitle());
        	preparedStatement.setInt(2, book.getYear());
        	preparedStatement.setDouble(3, book.getPrice());
        	preparedStatement.setInt(4, book.getAuthorID());
        	preparedStatement.setString(5, book.getISBN());

        	PreparedStatement preparedStatement2 = con.prepareStatement(updateAuthor);
        	preparedStatement2.setString(1, book.getFirstName());
            preparedStatement2.setString(2, book.getLastName());
            preparedStatement2.setInt(3, book.getAuthorID());

        	PreparedStatement preparedStatement3 = con.prepareStatement(updateInventory);
        	preparedStatement3.setInt(1,book.getNumBooks());
        	preparedStatement3.setString(2,book.getISBN());
        	
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
            System.out.println(preparedStatement2);
            result2 = preparedStatement2.executeUpdate();
            
            System.out.println(preparedStatement3);
            result3 = preparedStatement3.executeUpdate();
        } 
        catch (SQLException e) 
        {
            //printSQLException(e);
        	e.printStackTrace();
        }
        return result;

	}
}
