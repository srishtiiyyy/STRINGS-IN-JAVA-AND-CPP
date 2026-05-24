/*
File Name: lengthoflastword.java

LeetCode 58 - Length of Last Word

Problem Statement:
Given a string s consisting of words and spaces,
return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

--------------------------------------------------

Example 1:
Input:
Hello World

Output:
5

Explanation:
The last word is "World"
Length = 5

--------------------------------------------------

Example 2:
Input:
   fly me   to   the moon

Output:
4

Explanation:
The last word is "moon"
Length = 4

--------------------------------------------------

Example 3:
Input:
luffy is still joyboy

Output:
6

Explanation:
The last word is "joyboy"
Length = 6

--------------------------------------------------

Approach:
1. Remove leading and trailing spaces using trim().
2. Start traversing from the end of the string.
3. Count characters until a space is encountered.
4. Return the count.

--------------------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

--------------------------------------------------

Company Tags:
Amazon
Google
Microsoft
Adobe
Apple
Infosys
TCS
Wipro
Accenture

--------------------------------------------------

Topic Tags:
String
Traversal

--------------------------------------------------
*/

import java.util.*;

public class lengthoflastword {

    // Function to calculate length of last word
    public static int lengthOfLastWord(String s) {

        // Remove leading and trailing spaces
        String str = s.trim();

        int cnt = 0;

        // Traverse from end
        for (int i = str.length() - 1; i >= 0; i--) {

            // Count characters until space occurs
            if (str.charAt(i) != ' ') {
                cnt++;
            } 
            else {
                break;
            }
        }

        return cnt;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.println("Enter the string:");
        String s = sc.nextLine();

        // Calling function
        int ans = lengthOfLastWord(s);

        // Printing result
        System.out.println("Length of last word: " + ans);

        sc.close();
    }
}