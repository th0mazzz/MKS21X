import java.util.Arrays;
public class Sorts{
    public static String name(){
	return "09.Zhao.Thomas";
    }

    /* Selection sort of an int array. */
    public static void selectionSort(int[] data){
	int min, innerIndex;
	int minIndex = -1;
	for(int outerIndex = 0; outerIndex < data.length; outerIndex++){
	    min = data[outerIndex];
	    innerIndex = outerIndex;
	    for(; innerIndex < data.length; innerIndex++){
		if(min >= data[innerIndex]){
		    min = data[innerIndex];
		    minIndex = innerIndex;
		}
	    }
	    int temp = data[minIndex];
	    data[minIndex] = data[outerIndex];
	    data[outerIndex] = temp;
	}
    }

    /* Insertion sort of an int array */
    public static void insertionSort(int[] data){
	//loops through each element of the array starting at index 1
	for(int outerIndex = 1; outerIndex < data.length; outerIndex++){
	    //compares elememt above to already sorted part of array
	    for(int innerIndex = 0; innerIndex < outerIndex; innerIndex++){
		if(data[outerIndex] < data[innerIndex]){ //if the element is less
		    int insertValue = data[outerIndex];  //than an element in the
		    int indexMoving = outerIndex;        //the sorted portion of the array,
		    while(indexMoving != innerIndex){    //then move rest over and insert
			data[indexMoving] = data[indexMoving - 1];
			indexMoving--;
		    }
		    data[innerIndex] = insertValue;
		}
		//if element is not greater than any element in sorted portion of array,
		//then it is fine where it is
	    }
	}	    
    }

    public static void bubbleSort(int[] data){
	for(int outerIndex = 0; outerIndex < data.length; outerIndex++){
	    for(int innerIndex = 0; innerIndex < data.length - 1 - outerIndex; innerIndex++){
		if(data[innerIndex] > data[innerIndex + 1]){
		    int tempValue = data[innerIndex + 1];
		    data[innerIndex + 1] = data[innerIndex];
		    data[innerIndex] = tempValue;
		}
	    }
	}
    }

    public static void main(String[] args){
	int[] test = new int[10];
	for(int index = 0; index < test.length; index++){
	    test[index] = (int)(Math.random()*100);
	}

	System.out.println(Arrays.toString(test));
	selectionSort(test);
	System.out.println('\n' + "Selection Sort:" + '\n' + Arrays.toString(test));

	System.out.println("--------------------");
	
	int[] test2 = new int[10];
	for(int index = 0; index < test2.length; index++){
	    test2[index] = (int)(Math.random()*100);
	}

	System.out.println(Arrays.toString(test2));
	insertionSort(test2);
	System.out.println('\n' + "Insertion Sort:" + '\n' + Arrays.toString(test2));

	System.out.println("--------------------");

	int[] test3 = new int[10];
	for(int index = 0; index < test3.length; index++){
	    test3[index] = (int)(Math.random()*100);
	}

	System.out.println(Arrays.toString(test3));
	bubbleSort(test3);
	System.out.println('\n' + "Bubble Sort:" + '\n' + Arrays.toString(test2));
    }
}
