public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String name, String bookName, String number, String callNum,
			   String currentHolder, String dueDate){
	super(name, bookName, number, callNum);
	currentHolder = null;
	dueDate = null;
    }
}
