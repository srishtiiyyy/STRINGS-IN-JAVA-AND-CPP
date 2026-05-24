/*
File Name: ReverseWordsInAString.java

LeetCode 151 - Reverse Words in a String

Problem Statement:
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters.
The returned string should only have a single space separating the words.

--------------------------------------------------

Example 1:
Input:
s = "the sky is blue"

Output:
"blue is sky the"

--------------------------------------------------

Example 2:
Input:
s = "  hello world  "

Output:
"world hello"

--------------------------------------------------

Example 3:
Input:
s = "a good   example"

Output:
"example good a"

--------------------------------------------------

Approach:
1. Split the string using one or more spaces.
2. Traverse the words array from end to start.
3. Append words into StringBuilder.
4. Trim extra trailing space.

--------------------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(n)

--------------------------------------------------

Company Tags:
Amazon
Google
Microsoft
Adobe
Apple
Flipkart
Infosys
TCS

--------------------------------------------------

Topic Tags:
String
Two Pointers

--------------------------------------------------
*/

import java.util.*;

public class ReverseWordsInAString {

    // Function to reverse words
    public static String reverseWords(String s) {

        // Split string using one or more spaces
        String[] words = s.split(" +");

        // StringBuilder for result
        StringBuilder sb = new StringBuilder();

        // Traverse array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {

            sb.append(words[i]);
            sb.append(" ");
        }

        // Remove extra trailing space
        return sb.toString().trim();
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter the string:");
        String s = sc.nextLine();

        // Function call
        String result = reverseWords(s);

        // Output
        System.out.println("Reversed String:");
        System.out.println(result);

        sc.close();
    }
}