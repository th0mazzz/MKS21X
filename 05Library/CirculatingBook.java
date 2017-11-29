public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String name, String bookName, String number, String callNum){
	super(name, bookName, number, callNum);
	currentHolder = null;
	dueDate = null;
    }

    public String getHolder(){return currentHolder;}
    public String getDate(){return dueDate;}

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if(getHolder() == null){
	    return "Book avaliable";
	}
	else{
	    return getHolder() + ", due: " + getDate();
	}
    }

    public String toString(){
	if(currentHolder == null){
	    return super.toString();
	}
	else{
	   return super.toString() + getHolder() + ", " + getDate();
	}
    }
}
