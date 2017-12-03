public class Barcode {

    private String zipcode;
    private String[] key;

    public Barcode(String zip){
	zipcode = zip;
	key = new String[10];
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
    }

    public String getZip(){
	return zipcode;
    }

    public String getCode(){
	String returnCode = "";
	int sumOfNumbers = 0; //will use after for loop

	returnCode = returnCode + '|'; //guard rail
	for(int digit = 0; digit < 5; digit++){
	    int number = zipcode.charAt(digit) - '0'; //gives the number using ASCII
	    returnCode = returnCode + key[number];
	    sumOfNumbers = sumOfNumbers + number;
	}
	
	int check = sumOfNumbers % 10; //calculates check number
	returnCode = returnCode + key[check];

	returnCode = returnCode + "|"; //other guard rail

	return returnCode;
    }

    public String toString(){
	return getCode() + " (" + zipcode + ")";
    }

    public static void main(String[] args){
	Barcode test1 = new Barcode("01234");
	System.out.println(test1.getZip()); // prints 01234
	System.out.println(test1.getCode()); //prints |||::::::||::|:|::||::|::|||:::|
	System.out.println(test1); //prints |||::::::||::|:|::||::|::|||:::| (01234)
    }
}
