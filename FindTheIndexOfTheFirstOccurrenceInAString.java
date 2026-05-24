/*
File Name: FindTheIndexOfTheFirstOccurrenceInAString.java

LeetCode 28 - Find the Index of the First Occurrence in a String

Problem Statement:
Given two strings needle and haystack,
return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

--------------------------------------------------

Example 1:
Input:
haystack = "sadbutsad"
needle = "sad"

Output:
0

Explanation:
"sad" occurs at index 0 and 6.
The first occurrence is at index 0.

--------------------------------------------------

Example 2:
Input:
haystack = "leetcode"
needle = "leeto"

Output:
-1

Explanation:
"leeto" does not occur in "leetcode".

--------------------------------------------------

Approach:
1. Traverse the haystack string.
2. Check if current character matches first character of needle.
3. Extract substring of needle length.
4. Compare substring with needle.
5. Return index if match found.
6. Otherwise return -1.

--------------------------------------------------

Time Complexity:
O((n - m + 1) * m)

Where:
n = length of haystack
m = length of needle

--------------------------------------------------

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
Accenture
Wipro

--------------------------------------------------

Topic Tags:
String
Two Pointers

--------------------------------------------------
*/

import java.util.*;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    // Function to find first occurrence
    public static int strStr(String haystack, String needle) {

        // If needle length is greater than haystack
        if (needle.length() > haystack.length()) {
            return -1;
        }

        // Traverse haystack
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

            // Check first character match
            if (haystack.charAt(i) == needle.charAt(0)) {

                // Compare substring with needle
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.println("Enter haystack string:");
        String haystack = sc.nextLine();

        System.out.println("Enter needle string:");
        String needle = sc.nextLine();

        // Function call
        int result = strStr(haystack, needle);

        // Printing result
        System.out.println("First occurrence index: " + result);

        sc.close();
    }
}