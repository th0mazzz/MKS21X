import java.util.*;
import java.io.*;

public class WordSearch{

    private char[][] data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;
    private int seed;

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(){
	System.out.println("Hello, welcome to the WordSearch Generator, written by Thomas Zhao." + '\n' + '\n' + "To use the program, please enter the following: " + '\n' + "javac WordSearch <number of rows> <number of columns> <file name> [seed] [key]" + '\n' + '\n' + "The arguments in brackets are optional: entering the seed will replicate the same puzzle associated with that seed, and entering the key parameter with the word 'key' will display the solution.");
    }

    //Constructor with the file name
    public WordSearch(int rows, int cols, String fileName){
	data = new char[rows][cols];
	clear();
	wordsToAdd = new ArrayList<String>();
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);

	    while(in.hasNext()){
		String word = in.next();
		//System.out.println(word);
		wordsToAdd.add(word.toLowerCase());
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName + '\n' + "Make sure file is in the same directory as the WordSearch java file");
	    System.exit(1);
	}
	wordsAdded = new ArrayList<String>();

	int randomNum = (int)(Math.random() * 1000000);
	seed = randomNum;
	System.out.println("Seed: " + randomNum);
	randgen = new Random(randomNum);
    }

    //Constructor with the file name and the seed
    public WordSearch(int rows, int cols, String fileName, int randSeed){
	data = new char[rows][cols];
	clear();
	randgen = new Random(randSeed);
	wordsToAdd = new ArrayList<String>();
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);

	    while(in.hasNext()){
		String word = in.next();
		//System.out.println(word);
		wordsToAdd.add(word.toLowerCase());
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName + '\n' + "Make sure file is in the same directory as the WordSearch java file");
	    System.exit(1);
	}
	wordsAdded = new ArrayList<String>();
	seed = randSeed;
    }

    //Constructor with filename, seed, key
    public WordSearch(int rows, int cols, String fileName, int randSeed, String answer){
	data = new char[rows][cols];
	clear();
	randgen = new Random(randSeed);
	wordsToAdd = new ArrayList<String>();
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);

	    while(in.hasNext()){
		String word = in.next();
		//System.out.println(word);
		wordsToAdd.add(word.toLowerCase());
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName + '\n' + "Make sure file is in the same directory as the WordSearch java file");
	    System.exit(1);
	}
	wordsAdded = new ArrayList<String>();
	seed = randSeed;
    }

    //Returns seed
    public int getSeed(){
	return seed;
    }

    //Prints the puzzle (assuming it's been populated... or not for the solution)
    public void printPuzzle(){
	System.out.println(data);
    }
    
    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for(int rowIndex = 0; rowIndex < data.length; rowIndex++){
	    for(int colIndex = 0; colIndex < data[rowIndex].length; colIndex++){
		data[rowIndex][colIndex] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String theGrid = "";
	for(int rowIndex = 0; rowIndex < data.length; rowIndex++){
	    for(int colIndex = 0; colIndex < data[rowIndex].length; colIndex++){
		theGrid = theGrid + data[rowIndex][colIndex] + " ";
	    }
	    theGrid = theGrid + '\n';
	}
	return theGrid;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word, int row, int col){
	if(data[row].length - col < word.length()){
	    return false;
	}
	int wordIndex = 0;
	for(int colIndex = col; colIndex < col + word.length(); colIndex++){
	    if(data[row][colIndex] != word.charAt(wordIndex) && data[row][colIndex] != '_'){
		return false;
	    }
	    wordIndex++;
	}
	wordIndex = 0;
	for(int colIndex = col; colIndex < col + word.length(); colIndex++){
	    data[row][colIndex] = word.charAt(wordIndex);
	    wordIndex++;
	}
	return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word, int row, int col){
	if(data.length - row < word.length()){
	    return false;
	}
	int wordIndex = 0;
	for(int rowIndex = row; rowIndex < row + word.length(); rowIndex++){
	    if(data[rowIndex][col] != word.charAt(wordIndex) && data[rowIndex][col] != '_'){
		return false;
	    }
	    wordIndex++;
	}
	wordIndex = 0;
	for(int rowIndex = row; rowIndex < row + word.length(); rowIndex++){
	    data[rowIndex][col] = word.charAt(wordIndex);
	    wordIndex++;
	}
	return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */

    public boolean addWordDiagonal(String word,int row, int col){
	if(data.length - row < word.length() || data[row].length - col < word.length()){
	    return false;
	}
	int wordIndex = 0;
	for(int rowIndex = row, colIndex = col;
	rowIndex < row + word.length();
	rowIndex++, colIndex++){
	    if(data[rowIndex][colIndex] != word.charAt(wordIndex) &&
	       data[rowIndex][colIndex] != '_'){
		return false;
	    }
	    wordIndex++;
	}
	wordIndex = 0;
	for(int rowIndex = row, colIndex = col; rowIndex < row + word.length();
	rowIndex++, colIndex++){
	    data[rowIndex][colIndex] = word.charAt(wordIndex);
	    wordIndex++;
	}
	return true;
    }

    //formats wordsAdded
    private String formatAddedWords(){
	String returnString = "";
	for(int index = 0; index < wordsAdded.size(); index++){
	    returnString = returnString + " " +  wordsAdded.get(index);
	    if(index % 3 == 0){
		returnString = returnString + '\n';
	    }
	}
	return returnString;
    }

    //randomly populate
    private void populate(){
	for(int rowIndex = 0; rowIndex < data.length; rowIndex++){
	    for(int colIndex = 0; colIndex < data[rowIndex].length; colIndex++){
		if(data[rowIndex][colIndex] == '_'){
		    int randomLetter = randgen.nextInt(26);
		    if(randomLetter == 0){data[rowIndex][colIndex] = 'a';} 
		    if(randomLetter == 1){data[rowIndex][colIndex] = 'b';}
		    if(randomLetter == 2){data[rowIndex][colIndex] = 'c';}
		    if(randomLetter == 3){data[rowIndex][colIndex] = 'd';}
		    if(randomLetter == 4){data[rowIndex][colIndex] = 'e';}
		    if(randomLetter == 5){data[rowIndex][colIndex] = 'f';}
		    if(randomLetter == 6){data[rowIndex][colIndex] = 'g';}
		    if(randomLetter == 7){data[rowIndex][colIndex] = 'h';}
		    if(randomLetter == 8){data[rowIndex][colIndex] = 'i';}
		    if(randomLetter == 9){data[rowIndex][colIndex] = 'j';}
		    if(randomLetter == 10){data[rowIndex][colIndex] = 'k';}
		    if(randomLetter == 11){data[rowIndex][colIndex] = 'l';}
		    if(randomLetter == 12){data[rowIndex][colIndex] = 'm';}
		    if(randomLetter == 13){data[rowIndex][colIndex] = 'n';}
		    if(randomLetter == 14){data[rowIndex][colIndex] = 'o';}
		    if(randomLetter == 15){data[rowIndex][colIndex] = 'p';}
		    if(randomLetter == 16){data[rowIndex][colIndex] = 'q';}
		    if(randomLetter == 17){data[rowIndex][colIndex] = 'r';}
		    if(randomLetter == 18){data[rowIndex][colIndex] = 's';}
		    if(randomLetter == 19){data[rowIndex][colIndex] = 't';}
		    if(randomLetter == 20){data[rowIndex][colIndex] = 'u';}
		    if(randomLetter == 21){data[rowIndex][colIndex] = 'v';}
		    if(randomLetter == 22){data[rowIndex][colIndex] = 'w';}
		    if(randomLetter == 23){data[rowIndex][colIndex] = 'x';}
		    if(randomLetter == 24){data[rowIndex][colIndex] = 'y';}
		    if(randomLetter == 25){data[rowIndex][colIndex] = 'z';}
		}
	    }
	}
    }
    
    /** -when colIncrement and rowIncrement are both 0, return false. 
     *  -when you successfully add a word, move the word from wordsToAdd to wordsAdded, 
     *then return true.
     *  return false otherwise. 
     */
    private boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement){
	if(rowIncrement == 0 && colIncrement == 0){
	    return false;
	}
	int wordLength = word.length();
	int wordIndex = 0;
	try{
	    for(int rowIndex = row, colIndex = col; wordLength > 0;
		rowIndex = rowIndex + rowIncrement, colIndex = colIndex + colIncrement,
		    wordIndex++, wordLength--){
		if(data[rowIndex][colIndex] != word.charAt(wordIndex) &&
		   data[rowIndex][colIndex] != '_'){
		    return false;
		}
	    }
	}
	catch(ArrayIndexOutOfBoundsException out){
	    //System.out.println("Not viable!");
	    return false;
	}
	wordLength = word.length();
	wordIndex = 0;
	for(int rowIndex = row, colIndex = col; wordIndex < wordLength;
	    rowIndex = rowIndex + rowIncrement, colIndex = colIndex + colIncrement,
		wordIndex++){
	    data[rowIndex][colIndex] = word.charAt(wordIndex);
	}
	wordsAdded.add(word);
	wordsToAdd.remove(word);
	return true;
    }

    /**
     *-Attempt to add all of the words from the wordsToAdd list. 
     *Keep trying many times* or until you run out.
     *-Experiment with *many times, maybe 1000 is enough, maybe 10000. 
     *If it is slow, cut it down!
     */
    private boolean addAllWords(){
	try{
	    for(int numTries = 0; numTries < wordsToAdd.size() * 100; numTries++){
		int indexOfWord = randgen.nextInt(wordsToAdd.size());
		addWord(data.length - randgen.nextInt(data.length), //row
			data[0].length - randgen.nextInt(data.length), //column
			wordsToAdd.get(indexOfWord), //word
			1 - randgen.nextInt(3), //rowIncrement
			1 - randgen.nextInt(3)); //columnIncrement
	    }
	}
	catch(IndexOutOfBoundsException e){
	    return true;
	}
	return true;
    }

    
    public static void main(String[] args){
	if(args.length < 3){
	    WordSearch creation = new WordSearch();
	}
	
        if(args.length == 3){
	    try{
		WordSearch creation = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
		creation.addAllWords();
		creation.populate();
		System.out.println(creation.toString());
		System.out.println(creation.formatAddedWords());
	    }
	    catch(NumberFormatException e){
		System.out.println("Invalid dimensions or seed inputted!");
		System.exit(1);
	    }
	}
	
	if(args.length == 4){
	    try{
		WordSearch creation = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
		creation.addAllWords();
		creation.populate();
		System.out.println(creation.toString());
		System.out.println(creation.formatAddedWords());
	    }
	    catch(NumberFormatException e){
		System.out.println("Invalid dimensions or seed inputted!");
		System.exit(1);
	    }
	}
	
	if(args.length == 5){
	    try{
		WordSearch creation = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[4]);
		creation.addAllWords();
		if(args[4].equals("key")){
		    System.out.println(creation);
		}
		else{
		    creation.populate();
		    System.out.println("For the solution, please type the 'key' parameter correctly");
		    System.out.println(creation);
		}
	    }
	    catch(NumberFormatException e){
		System.out.println("Invalid dimensions or seed inputted!");
		System.exit(1);
	    }
	}
    }
}
