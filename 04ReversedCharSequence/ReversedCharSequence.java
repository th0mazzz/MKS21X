public class ReverseCharSequence{

    private String storage;
    private String original;
    
    public ReverseCharSequence(String inputString){
	storage = "";
	original = inputString;
	for(int index = inputString.length() - 1; index >= 0; index--){
	    storage = storage + inputString.charAt(index);
	}
    }

    public char charAt(int index){
	return storage.charAt(index);
    }
    
    public int length(){
	return storage.length();
    }

    public ReverseCharSequence subSequence(int start, int end){
	ReverseCharSequence theSub = new ReverseCharSequence(storage);
	theSub.storage = storage.substring(start, end);
	return theSub;
    }

    public String toString(){
	return storage;
    }
    
    public static void main(String[] args){
	// Testing constructor
	ReverseCharSequence test = new ReverseCharSequence("gnirts a si sihT");
	System.out.println(test.storage); //prints This is a string
	System.out.println(test.length()); //prints 16
	System.out.println(test.charAt(2)); //prints i
	System.out.println(test.subSequence(0, 4)); //prints This
	System.out.println(test); //prints This is a string
	//This last one tests the toString method of ReverseCharSequence
	
    }
}
