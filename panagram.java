/*
LeetCode 1832: Check if the Sentence Is Pangram

Question:
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, 
return true if sentence is a pangram, or false otherwise.

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true

Example 2:
Input: sentence = "leetcode"
Output: false

--------------------------------------------------------
Approach:
1. Maintain a frequency array of size 26 for each alphabet.
2. Traverse through the sentence:
   - Mark the character as visited if not already.
   - Maintain a counter of distinct characters.
3. If distinct characters = 26 → return true, else false.

Time Complexity: O(n)   (scan the string once)
Space Complexity: O(1)  (fixed 26-size array)
--------------------------------------------------------
*/

import java.util.*;

public class panagram {
    public static boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        int count = 0;

        for (char ch : sentence.toCharArray()) {
            int index = ch - 'a';
            if (freq[index] == 0) {
                freq[index] = 1;
                count++;
            }
        }
        return count == 26;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();

        if (checkIfPangram(sentence))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
 