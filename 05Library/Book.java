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

    public String getAuthor(){return author;}
    public String getTitle(){return title;}
    public String getISBN(){return ISBN;}

    //public void setAuthor(String name){author = name;}
    //public void setTitle(String bookName){title = bookName;}
    //public void setISBN(String number){ISBN = number;}
}
