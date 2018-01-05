public class OrderedSuperArray extends SuperArray{

    //Default Constructor
    public OrderedSuperArray(){
	super();
    }

    //Capacity Constructor
     public OrderedSuperArray(int capacity){
    	super(capacity);
    }

    //Takes Array Constructor
    public OrderedSuperArray(String[] array){
	super(array);
    }

    public void add(int index, String value){
	add(value);
    }

    public boolean add(String value){
	if(size() == 0){
	    super.add(value);
	    return true;
      	}
	for(int index = 0; index < size(); index++){
	    System.out.println("Insert Index = " + findIndex(value));
	    int insertIndex = findIndex(value);
		super.add(insertIndex, value);
		return true;
	}
	return true;
    }

    private int findIndex(String value){
	for(int index = 0; index < size(); index++){
	    if(value.compareTo(get(index)) < 0){
		return index;
	    }
	}
	return size();
    }
        


    public int findIndexBinary(String value){
	int start = 0;
	int end = size() - 1;
	int current = (start + end) / 2;
	int oldCurrent = -1;
        while(start <= end){
	    if(value.compareTo(get(current)) > 0){
		start = current;
		oldCurrent = current;
		current = (start + end) / 2;
	    }
	    if(value.compareTo(get(current)) < 0){
		end = current;
		oldCurrent = current;
		current = (start + end) / 2;
	    }
	    if(current == oldCurrent){
		return current;
	    }
	    oldCurrent = current;
	    //System.out.println("Start: " + start + ", End: " + end + " Current: "+ current + "oldCurrent: " + oldCurrent);
		
	}
	return current;
    }
}
