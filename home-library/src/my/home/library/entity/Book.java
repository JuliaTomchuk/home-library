package my.home.library.entity;

public class Book {

	private String name;
	private String author;
	private TypeOfBook type;

	public Book() {
	}

	public Book(String name, String author, TypeOfBook type) {
		this.name = name;
		this.author = author;
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setType(TypeOfBook type) {
		this.type = type;
	}
	
	public TypeOfBook getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (other.name == null) {
			if (this.name != null)
				return false;
		} else if (!other.name.equals(this.name)) {
			return false;
		}
		if (other.author == null) {
			if (this.author != null)
				return false;
		} else if (!other.author.equals(this.author))
			return false;
		if (other.type == null) {
			if (this.type != null)
				return false;
		} else if (!other.type.equals(this.type))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = result * prime + (name == null ? 0 : name.hashCode());
		result = result * prime + (author == null ? 0 : author.hashCode());
		result = result * prime + (type == null ? 0 : type.hashCode());
		return result;

	}
	
	@Override
	public String toString() {
		
		return getClass().getSimpleName() + "["+ "name = " + name+ " ,author = "+ author+ " ,type = " + type   +"]";
	}

	
}
