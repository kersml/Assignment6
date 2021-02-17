package csce247.assignments.singleton;
import java.util.HashMap;
import java.util.Map;
/**
 * Library class 
 * @author miller
 */
public class Library {
	//HashMap attribute
	public HashMap<String, Integer> books;
	/**
	 * default constructor
	 */
	public Library()
	{
		System.out.println("Creating our Library. Time to begin reading.");
		books = new HashMap<>();
	}
	/**
	 * makes a library object
	 * @return library object
	 */
	public static Library getInstance()
	{
		Library l = new Library();
		return l;
	}
	/**
	 * adds a key or ups the value of a key in the books HashMap
	 * @param bookName name of book
	 * @param numToAdd number of copies
	 */
	public void checkInBook(String bookName, int numToAdd)
	{
		if(books.containsKey(bookName))
		{
			books.replace(bookName, books.get(bookName), (books.get(bookName) + numToAdd));
		}
		else
		{
			books.put(bookName, numToAdd);
			System.out.println(bookName + " was added to the library.");
		}
	}
	/**
	 * removes one from the value of the corresponding key(bookName) in the HashMap
	 * @param bookName name of book
	 */
	public void checkoutBook(String bookName)
	{
		if(books.containsKey(bookName))
		{
			if(books.get(bookName) > 0)
			{
				books.replace(bookName, books.get(bookName), (books.get(bookName) - 1));
				System.out.println(bookName + " was successfully checked out");
			}
			else
			{
				System.out.println("Sorry, " + bookName + " is not in stock");
			}
		}
	}
	/**
	 * displays a list of all the books in the library and the number of copies
	 */
	public void displayBooks()
	{
		System.out.println("Inventory:");
		for(Map.Entry<String, Integer> e : books.entrySet())
		{
			System.out.println("-" + e.getKey() + ", copies: " + e.getValue());
		}
	}
}
