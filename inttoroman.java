/*
LeetCode 12: Integer to Roman

Question:
Given an integer, convert it to a Roman numeral.

Roman numerals are represented by the following symbols:
 I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000.

Roman numerals are formed by combining symbols and subtractive rules:
 - 2 is written as "II" (two ones)
 - 4 is written as "IV" (one before five)
 - 9 is written as "IX" (one before ten)
 - 58 is "LVIII" = L + V + III
 - 1994 is "MCMXCIV" = M + CM + XC + IV

Constraints:
1 <= num <= 3999

--------------------------------------------------------
Approach:
1. Define arrays of Roman numeral values and their symbols.
2. Iterate through values:
   - While num >= values[i], append symbols[i] to result and subtract values[i].
3. Continue until num becomes 0.

Time Complexity: O(1) (bounded by fixed number of Roman numeral values ~13).
Space Complexity: O(1).
--------------------------------------------------------
*/

import java.util.*;

public class inttoroman {

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC",
                            "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(intToRoman(num));
    }
}
