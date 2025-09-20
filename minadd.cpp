#include <bits/stdc++.h>
using namespace std;

// Function to calculate minimum additions required
int minAddToMakeValid(string s) {
    int open = 0, extra = 0;

    for (char ch : s) {
        if (ch == '(') {
            open++;
        } else if (open > 0) {
            open--; // match a '('
        } else {
            extra++; // unmatched ')'
        }
    }

    return open + extra;
}

int main() {
    string s1 = "())";
    string s2 = "(((";
    string s3 = "()";
    string s4 = "()))((";

    cout << "Input: " << s1 << " -> Minimum additions: " << minAddToMakeValid(s1) << endl;
    cout << "Input: " << s2 << " -> Minimum additions: " << minAddToMakeValid(s2) << endl;
    cout << "Input: " << s3 << " -> Minimum additions: " << minAddToMakeValid(s3) << endl;
    cout << "Input: " << s4 << " -> Minimum additions: " << minAddToMakeValid(s4) << endl;

    return 0;
}
