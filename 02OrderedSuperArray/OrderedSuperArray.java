public class OrderedSuperArray extends SuperArray{

    //Default Constructor
    public OrderedSuperArray(){
	super();
    }

    //Capacity Constructor
    // public OrderedSuperArray(int capacity){
    //	super(capacity);
    //}

    public void add(int index, String value){

    }

    public boolean add(String value){
	if(size() == 0){
	    super.add(value);
	    return true;
      	}
        int index = 0;
	//	while(!(data[index].compareTo(value) > data[index - 1] && data[index].compareTo(value) < data[index + 1])){
	//	    if(data[index].compareTo(value) > data[index - 1] && data[index].compareTo(value) > data[index + 1]){
	//		index = size() + size / 2;
	//	    }
	//	    if(data[index].compareTo(value) < data[index + 1] && data[index].compareTo(value) < data[index + 1]){
	//		index = size() - size() / 2;
	//	    }
	//	}x

	for(; index < size(); index++){
	    //System.out.println(get(index).compareTo(value));
	    if(value.compareTo(get(index)) > 0){
		super.add(index + 1, value);

	    }
	}
	return true;
    }
}
