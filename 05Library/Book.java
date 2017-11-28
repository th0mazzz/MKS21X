public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
    }
    
    public Book(String name, String bookName, String number){
	author = name;
	title = bookName;
	ISBN = number;
    }

    public String getAuthor(){return author}
    public String getTitle(){return title}
    public String getISBN(){return ISBN}

}
