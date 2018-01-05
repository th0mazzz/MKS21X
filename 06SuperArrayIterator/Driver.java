public class Driver{
    public static void main(String[] args) {
	SuperArray data = new SuperArray();
	int i = 0;
	while(i < 26){
	    data.add(""+(char)('A'+i%26));
	    i++;
	}
	
	System.out.println(data);
	System.out.println("Standard loop:");
	
	for(int n = 0; n < data.size(); n++){
	    System.out.print(data.get(n)+" ");
	}
	System.out.println();
	System.out.println("for-each loop:");
	for(String s : data){
	    System.out.print(s+" ");
	}
	/*
	String[] wow = {"3", "hello", "48yrewh", "oh baby", "9f", "111", "abc"};
	SuperArray data2 = new SuperArray(wow);

	System.out.println(data2);
	System.out.println("Standard loop:");
	
	for(int n = 0; n < data2.size(); n++){
	    System.out.print(data2.get(n)+" ");
	}
	System.out.println();
	System.out.println("for-each loop:");
	for(String s : data2){
	    System.out.print(s+" ");
	}
	*/
    }
}

