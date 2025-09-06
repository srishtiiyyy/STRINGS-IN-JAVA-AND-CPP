/*
LeetCode 38: Count and Say

Question:
The count-and-say sequence is a sequence of digit strings defined as follows:

- countAndSay(1) = "1"
- countAndSay(n) is the way you would "say" the previous term.
  For example:
  "1" is read off as "one 1" → "11"
  "11" is read off as "two 1s" → "21"
  "21" is read off as "one 2, then one 1" → "1211"

Given a positive integer n, return the nth term of the count-and-say sequence.

--------------------------------------------------------
Example:
Input: n = 4
Output: "1211"

Explanation:
countAndSay(1) = "1"
countAndSay(2) = "11"
countAndSay(3) = "21"
countAndSay(4) = "1211"

--------------------------------------------------------
Approach:
1. Base case: if n == 1 → return "1".
2. Recursively compute countAndSay(n-1).
3. Traverse the string and "say" it:
   - Count consecutive identical digits.
   - Append "<count><digit>" to result.
4. Return the built result string.

Time Complexity: O(k * n) where k is average length of strings up to n.
Space Complexity: O(k) for building strings.
--------------------------------------------------------
*/

import java.util.*;

public class countandsay {

    public static String countAndSay(int n) {
        if (n == 1) return "1";

        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < prev.length(); i++) {
            char ch = prev.charAt(i);
            int count = 1;
            while (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            res.append(count).append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(countAndSay(n));
    }
}
