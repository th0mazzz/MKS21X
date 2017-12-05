public class Barcode implements Comparable<Barcode>{

    private String zipcode;

    public Barcode(String zip){
	String copy = zip; //so that parseInt doesn't actually change the zip from a String
	if(zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	try{
	    Integer.parseInt(copy);
	}
	catch(NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	
	zipcode = zip;
    }

    public String getZip(){
	return zipcode;
    }

    public static String toCode(String zip){
	String[] key = new String[10];
	key[0] = "||:::";
	key[1] = ":::||";
	key[2] = "::|:|";
	key[3] = "::||:";
	key[4] = ":|::|";
	key[5] = ":|:|:";
	key[6] = ":||::";
	key[7] = "|:::|";
	key[8] = "|::|:";
	key[9] = "|:|::";
	
	String returnCode = "";
	int sumOfNumbers = 0; //will use after for loop

	returnCode = returnCode + '|'; //guard rail
	for(int digit = 0; digit < 5; digit++){
	    int number = zip.charAt(digit) - '0'; //gives the number using ASCII
	    returnCode = returnCode + key[number];
	    sumOfNumbers = sumOfNumbers + number;
	}
	
	int check = sumOfNumbers % 10; //calculates check number
	returnCode = returnCode + key[check];

	returnCode = returnCode + "|"; //other guard rail

	return returnCode;
    }

    public static String toZip(String code){
        String[] key = new String[10];
	key[0] = "||:::";
	key[1] = ":::||";
	key[2] = "::|:|";
	key[3] = "::||:";
	key[4] = ":|::|";
	key[5] = ":|:|:";
	key[6] = ":||::";
	key[7] = "|:::|";
	key[8] = "|::|:";
	key[9] = "|:|::";

	String returnZip = "";

	if(code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
	    throw new IllegalArgumentException();
	}
	code = code.substring(1, code.length() - 1);
	System.out.println(code);
	if(code.length() != 32){
	    throw new IllegalArgumentException();
	}
	
	for(int index = 0; index < code.length(); index++){
	    if(code.charAt(index) != ':' && code.charAt(index) != '|'){
		throw new IllegalArgumentException();
	    }
	}
	for(int index = 1; index < 25; index = index + 5){
	    for(int keyIndex = 0; keyIndex < 10; keyIndex++){
		System.out.println(code.substring(index, index + 5));
		System.out.println(code.substring(index + 5, index + 10));
		if(code.substring(index, index + 5).equals(key[keyIndex])){
		    System.out.println(code.substring(index, index + 5));
		    returnZip = returnZip + keyIndex;
		}
		else{
		    System.out.println("This is what you want");
		    throw new IllegalArgumentException();
		}
	    }
	}
			

	return "end";
    }

    public String toString(){
	return toCode(zipcode) + " (" + zipcode + ")";
    }

    public int compareTo(Barcode other){
	if(getZip().compareTo(other.getZip()) < 0){
	    return -1;
	}
	else{
	    if(getZip().compareTo(other.getZip()) > 0){
		return 1;
	    }
	    else{
		return 0;
	    }
	}
    }

    public boolean equals(Barcode other){
	return getCode().equals(other.getCode());
    }

    public String getCode(){
	return toCode(getZip());
    }

    public static void main(String[] args){
	Barcode test1 = new Barcode("01234");
	System.out.println(test1.getZip()); // prints 01234
	System.out.println(toCode(test1.getZip())); //prints |||::::::||::|:|::||::|::|||:::|
	System.out.println(test1.getCode()); //prints |||::::::||::|:|::||::|::|||:::|
	System.out.println(test1); //prints |||::::::||::|:|::||::|::|||:::| (01234)
        
	Barcode test2 = new Barcode("98765");
	System.out.println(test1.compareTo(test2)); //prints -1
	System.out.println(test2.compareTo(test1)); //prints 1
	System.out.println(test1.compareTo(test1)); //prints 0
	
	System.out.println(test1.equals(test1)); //true
	System.out.println(test1.equals(test2)); //false

	//Barcode test3 = new Barcode("00123");

        System.out.println(toZip("|||::::::||::|:|::||::|::|||:::|"));
    }
}

/* to do list
toZip static
-write to zip first lol
-give toCode and toZip their respective exception throws
-make getcode and getzip
*/
