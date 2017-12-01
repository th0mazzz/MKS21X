import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{

private int currentIndex;
private int stop;
private SuperArray theSuperArray;

public SuperArrayIterator(int start, int end, SuperArray ourSuperArray){
	currentIndex = start;
	stop = end;
	
}

    public boolean hasNext(){
	return currentIndex <= stop;
    }

    public String next(){
	if(hasNext()){
	    return theSuperArray.get(currentIndex++);
	}
	else{
	    System.exit(1);
	}
	return theSuperArray.get(currentIndex - 1);
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
