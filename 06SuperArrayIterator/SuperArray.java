public class SuperArray{

    //Important definitions

    //size means the number of non-null elements in an array
    //empty means that the list contains no non-null elements

    //changed my code to reflect the newly discovered fact that there should be no holes in the array e.g.:
    // ["one", null, "three"] ... apparently, there are no nulls between elements, good to know!
    
    private String[] data;
    private int size;

    // PHASE ONE //
    
    //Default Constructor
    public SuperArray(){
	size = 0;
	String[] emptyArray = new String[10];
	data = emptyArray;
    }

    //Constructor
    public SuperArray(String[] inputData){
    	data = inputData;
    	size = calcSize();
    }


    //Calc Size for Constructor
     public int calcSize(){
	int numberOfElements = 0;
	for(int index = 0; index < data.length; index++){
	    if(data[index] != null){
		numberOfElements++;
	    }
	}
	int size = numberOfElements;
	return size;
    }
    
    //clears the array, elements become null
    public void clear(){
	String[] clearedArray = new String[data.length];
	data = clearedArray;
	size = 0;
    }

    //returns size of array
    public int size(){
	return size;
    }

    //checks if array is empty
    public boolean isEmpty(){
	if(size() == 0){
	    return true;
	}
	return false;
    }

    //adds an element to the end of array,  increases array capacity by 1
    public boolean add(String element){
	resize();
	String[] newStrings = new String[size() + 1];
	for(int index = 0; index < size(); index++){
	    newStrings[index] = data[index];
	}
	SuperArray altered = new SuperArray(newStrings);
	data = altered.data;
	data[size] = element;
	size++;
	return true;
    }

    //allows for SuperArray / array to be viewable
    public String toString(){
	if(size() == 0){
	    return "[]";
	}
	String newStr = "[";
	for(int index = 0; index < size() - 1; index++){
	    newStr = newStr + data[index] + ", ";
	}
	newStr = newStr + data[size() - 1];
	return newStr + "]";
    }

    //Returns the element at the specified position in this list
    public String get(int index){
	if(index >= size() || index < 0){
	    return "You bad at index!";
	}
	return data[index];
    }

    //changes element of index and returns replaced element
    public String set(int index, String element){
	if(index >= size() || index < 0){
	    System.out.println("Index is out of range, moron! Learn to count!");
	    return null;
	}
	String oldElement = data[index];
	data[index] = element;
	return oldElement;
    }

    // PHASE TWO //

    //increases size of array *doubles it*
    private void resize(){
	if(data.length - 1 == size()){
	    String[] newStrings = new String[size() * 2 + 1];
	    for(int index = 0; index <size(); index++){
		newStrings[index] = data[index];
	    }
	    SuperArray altered = new SuperArray(newStrings);
	    data = altered.data;
	}
    }    


    // PHASE 3 //

    // checks if array contains element //
    public boolean contains(String element){
	if(size() == 0){
	    return false;
	}
	for(int index = 0; index < size(); index++){
	    if(data[index] == element){
		return true;
	    }
	}
	return false;
    }

    //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.//
    public int indexOf(String element){
	if(size() == 0){
	    return -1;
	}
	for(int index = 0; index < size(); index++){
	    if(data[index] == element){
		return index;
	    }
	}
	return -1;
    }

    //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int lastIndexOf(String element){
	if(size() == 0){
	    return -1;
	}
	for(int index = size() - 1; index >= 0; index--){
	    if(data[index] == element){
		return index;
	    }
	}
	return -1;
    }

    //adds string to given index and shifts rest of values over to right
    public void add(int targetIndex, String element){
	if(data.length == 0){
	    System.out.println("Empty array!");
	}
	if(targetIndex < 0 || targetIndex > size()){
	    System.out.println("Index out of range");
	}
	resize();
	int currentIndex = size() - 1;
	for(; currentIndex >= targetIndex; currentIndex--){
	    data[currentIndex + 1] = data[currentIndex];
	}
	data[targetIndex + 1] = element;
	size++;
    }

    //removes element by index, returns removed element
    public String remove(int targetIndex){
	if(size() == 0){
	    System.out.println("Empty array!");
	    return null;
	}
       	if(targetIndex < 0 || targetIndex > size()){
	    System.out.println("Index out of range");
	    return null;
	}
	int currentIndex = targetIndex;
	String removedElement = data[targetIndex];
	for(; currentIndex < data.length - 1; currentIndex++){
	    data[currentIndex] = data[currentIndex + 1];
	}
	data[currentIndex] = null;
	size--;
	return removedElement;
    }

    //Removes the first occurrence of the specified element from this list if it is present. Shift all the subsequent elements to the left.
    public boolean remove(String element){
	int targetIndex = indexOf(element);
	if(targetIndex == -1){
	    return false;
	}
	remove(targetIndex);
	    return true;
    }



    
}




