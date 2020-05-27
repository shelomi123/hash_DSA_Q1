// Iterate through every element of set A and search it in set B, if any element is found, return false.
If no element is found, return true. Time complexity of this method is O(mn)

// Java program to check if two sets are disjoint 
  
public class disjoint1  
{ 
    // Returns true if set1[] and set2[] are  
    // disjoint, else false 
    boolean aredisjoint(int set1[], int set2[])  
    { 
         // Take every element of set1[] and  
         // search it in set2 
        for (int i = 0; i < set1.length; i++)  
        { 
            for (int j = 0; j < set2.length; j++)  
            { 
                if (set1[i] == set2[j]) 
                    return false; 
            } 
        } 
        // If no element of set1 is present in set2 
        return true; 
    } 
      
    // Driver program to test above function 
    public static void main(String[] args)  
    { 
        disjoint1 dis = new disjoint1(); 
        int set1[] = { 12, 34, 11, 9, 3 }; 
        int set2[] = { 7, 2, 1, 5 }; 
  
        boolean result = dis.aredisjoint(set1, set2); 
        if (result) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
} 

-------------------------------------------------------------

//This can be solved by using both Sorting and Merging.First sort both set A and B.Then use
merge like process to compare elements in sets.Time complexity of this method is O(mLogm +
nLogn). The above solution first sorts both sets, then takes O(m+n) time to find intersection. If
we are given that the input sets are sorted, then this method is best among all

// A Simple C++ program to check if two sets are disjoint 
#include<iostream> 
#include<algorithm> 
using namespace std; 

// Returns true if set1[] and set2[] are disjoint, else false 
bool areDisjoint(int set1[], int set2[], int m, int n) 
{ 
	// Sort the given two sets 
	sort(set1, set1+m); 
	sort(set2, set2+n); 

	// Check for same elements using merge like process 
	int i = 0, j = 0; 
	while (i < m && j < n) 
	{ 
		if (set1[i] < set2[j]) 
			i++; 
		else if (set2[j] < set1[i]) 
			j++; 
		else /* if set1[i] == set2[j] */
			return false; 
	} 

	return true; 
} 

// Driver program to test above function 
int main() 
{ 
	int set1[] = {12, 34, 11, 9, 3}; 
	int set2[] = {7, 2, 1, 5}; 
	int m = sizeof(set1)/sizeof(set1[0]); 
	int n = sizeof(set2)/sizeof(set2[0]); 
	areDisjoint(set1, set2, m, n)? cout << "Yes" : cout << " No"; 
	return 0; 
} 

------------------------------------------------------------

//Another way to solve this is using hashing.First create an empty hash table.Then iterate through
the set A and store every element in hash table.Next iterate through set B and check if any
element is present in hash table. If present, then return false, else ignore the element. If all
elements of set B are not present in hash table, return true.Time complexity of the above
implementation is O(m+n) under the assumption that hash set operations like add() and
contains() work in O(1) time.


/* Java program to check if two sets are distinct or not */
import java.util.*; 

class Main 
{ 
	// This function prints all distinct elements 
	static boolean areDisjoint(int set1[], int set2[]) 
	{ 
		// Creates an empty hashset 
		HashSet<Integer> set = new HashSet<>(); 

		// Traverse the first set and store its elements in hash 
		for (int i=0; i<set1.length; i++) 
			set.add(set1[i]); 

		// Traverse the second set and check if any element of it 
		// is already in hash or not. 
		for (int i=0; i<set2.length; i++) 
			if (set.contains(set2[i])) 
				return false; 

		return true; 
	} 

	// Driver method to test above method 
	public static void main (String[] args) 
	{ 
		int set1[] = {10, 5, 3, 4, 6}; 
		int set2[] = {8, 7, 9, 3}; 
		if (areDisjoint(set1, set2)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 
