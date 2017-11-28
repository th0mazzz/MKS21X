public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String name, String bookName, String number, String callNum){
	super(name, bookName, number);
	callNumber = callNum;
    }

    public String getCallNum(){return callNumber;}

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public int compareTo(LibraryBook other){
	if(getCallNum().compareTo(other.getCallNum()) > 0){
	    return -1;
	}
	if(getCallNum().compareTo(other.getCallNum()) < 0){
	    return 1;
	}
	return 0;
    }

    public String toString(){
	return super.toString() + circulationStatus() + getCallNum();
    }

}
    
