public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String name, String bookName, String number,
			 String callNum, String collectName){
	super(name, bookName, number, callNum);
	collection = collectName;
    }

    public String getCollection(){return collection;}

    public void checkout(String patron, String due){
	System.out.println("Sorry, reference books are not avaliable for checkout");
    }

    public void returned(){
	System.out.println("Impossible, shouldn't have been checked out in the first place");
    }

    public String circulationStatus(){
	return "Non-circulating reference book";
    }
}
