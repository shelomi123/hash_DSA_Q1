package javaapplication13;

import java.util.Arrays;

public class Hash {
	
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public static void main(String[] args) {
		
		Hash theFunc = new Hash(30);
		//String[] elementsToAdd = {"1", "5", "17", "21", "26"};
		//theFunc.hashFunction1(elementsToAdd, theFunc.theArray);
		
		String[] elementsToAdd2 = {"100", "102", "309", "546", "345", "276", "107", "490", "200", "300",
									"400", "500", "600", "700", "800", "900", "10", "20", "30", "40",
									"50", "60", "70", "80", "90", "2", "5", "56", "76", "87"};
		
		theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
		
		theFunc.findKey("500");
		
		theFunc.displayTheStack();
	}
	
	public void hashFunction1(String[] stringsForArray, String[] theArray){
		
		for(int n = 0; n < stringsForArray.length; n++){
			
			String newElementVal = stringsForArray[n];
			theArray[Integer.parseInt(newElementVal)] = newElementVal;
			
		}
	}
	
	public void hashFunction2(String[] stringsForArray, String[] theArray){
		
		for(int n = 0; n < stringsForArray.length; n++){
			
			String newElementVal = stringsForArray[n];
			int arrayIndex = Integer.parseInt(newElementVal) % 29;
			System.out.println("Modules Index= " + arrayIndex + "for value " + newElementVal);
			while(theArray[arrayIndex] != "-1"){
				
				++arrayIndex;
				System.out.println("Collision Try " + arrayIndex + "Instead");
				arrayIndex %= arraySize;
			}
			
			theArray[arrayIndex] = newElementVal;
			
		}
		
	}
	
	public String findKey(String key){
		
		int arrayIndexHash = Integer.parseInt(key) % 29;
		while(theArray[arrayIndexHash] != "-1"){
			
			if(theArray[arrayIndexHash] == key){
				System.out.println(key + " was found in index " + arrayIndexHash);
				return theArray[arrayIndexHash];
			}
			
			++arrayIndexHash;
			arrayIndexHash %= arraySize;
		}
		
		return null;
	} 
	
	Hash(int size){
		
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray, "-1");
		
	}
	
	public void displayTheStack(){
		
		int incriment = 0;
	}
}