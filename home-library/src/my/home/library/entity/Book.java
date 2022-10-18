package my.home.library.entity;

public class Book {
	
	private String name;
	private String author;
	private TypeOfBook type;
	
	public Book() {}
	public Book(String name, String author, TypeOfBook type) {
		this.name=name;
		this.author=author;
		this.type=type;
	}

}
