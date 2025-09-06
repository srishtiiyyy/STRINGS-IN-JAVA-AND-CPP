/*
LeetCode 443: String Compression

Question:
You are given an array of characters chars. 
You need to compress it using the following algorithm:
- Begin with an empty string s. For each group of consecutive repeating characters in chars:
    * Append the character to s.
    * If the group length is greater than 1, append the length of the group.
- The compressed string s should not be returned separately, 
  but instead be stored in the input character array chars.
- After you are done modifying the input array, 
  return the new length of the array.

You must write an algorithm that uses only O(1) extra space.

Example:
Input: ["a","a","b","b","c","c","c"]
Output length: 6
The array is modified to: ["a","2","b","2","c","3"]

--------------------------------------------------------
Approach:
1. Use two pointers:
   - i to iterate the array
   - index to store the compressed result
2. For each group of identical characters:
   - Place the character at chars[index]
   - If frequency > 1, convert the count to string and write each digit
3. Return index as the new compressed length.

Time Complexity: O(n)   (each character visited once)
Space Complexity: O(1)  (in-place compression)
--------------------------------------------------------
*/

import java.util.*;

public class stringcompression {

    public static int compress(char[] chars) {
        int n = chars.length;
        int index = 0; // position to write
        int i = 0;

        while (i < n) {
            char currChar = chars[i];
            int count = 0;

            // count occurrences
            while (i < n && chars[i] == currChar) {
                count++;
                i++;
            }

            // write the character
            chars[index++] = currChar;

            // if count > 1, write digits
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] chars = new char[n];
        for (int i = 0; i < n; i++) chars[i] = sc.next().charAt(0);

        int newLen = compress(chars);

        System.out.println(newLen);
        for (int i = 0; i < newLen; i++) System.out.print(chars[i] + " ");
    }
}
