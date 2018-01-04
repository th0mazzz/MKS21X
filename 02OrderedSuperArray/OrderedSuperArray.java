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
	while(!(get((end - start) / 2).compareTo(value) < 0 && get((end - start) / 2).compareTo(value) > 0)){
	    if(get((end - start) / 2).compareTo(value) < 0){
	        start = start + (end - start) / 2;
	    }
   	    if(get((end - start) / 2).compareTo(value) > 0){
		end = end - (end - start) / 2;
	    }
	}
	return end;

    }
}
