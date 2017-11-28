public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String name, String bookName, String number,
			 String callNum, String collectName){
	super(name, bookName, number, callNum);
	collection = collectName;
    }
}
