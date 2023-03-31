package bit.basic.obj1;
// 생성자, this
public class Book {
	private String author="장영주";
	{
		author = "장영주2";
	}
	private int price;
	private String publisher;
	private String regdate;
	private String bookName;
	public Book() {
		this("");
	}
	public Book(String author) {
//		this.author = author;
		this(author, 0);
	}
	public Book(String author, int price) {
//		this.author = author;
//		this.price = price;
		this(author, price, "");
	}
	public Book(String author, int price, String publisher) {
//		this.author = author;
//		this.price = price;
//		this.publisher = publisher;
		this(author, price, publisher, "");
	}
	public Book(String author, int price, String publisher, String regdate) {
//		this.author = author;
//		this.price = price;
//		this.publisher = publisher;
//		this.regdate = regdate;
		this(author, price, publisher, regdate, "");
	}
	public Book(String author, int price, String publisher, String regdate, String bookName) {
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.regdate = regdate;
		this.bookName = bookName;
	}
	public Book(Book obj) {
//		this(obj.author, obj.price, obj.publisher, obj.regdate, obj.bookName);
		this.author = obj.author;
		this.price = obj.price;
		this.publisher = obj.publisher;
		this.regdate = obj.regdate;
		this.bookName = obj.bookName;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", price=" + price + ", publisher=" + publisher + ", regdate=" + regdate
				+ ", bookName=" + bookName + ", toString()=" + super.toString() + "]";
	}	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public static void main(String[] args) {
		Book book = new Book("가영");
		Book book2 = new Book("가영", 8000, "비트출판");
		Book book3 = new Book(book2);
		
		System.out.println(book.toString());
		System.out.println(book2.toString());
		System.out.println(book3.toString());
	}
}
