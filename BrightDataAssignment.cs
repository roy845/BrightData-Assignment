using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

public class Solution {
    public static int IsValid(string s) {
        Stack<char> st = new Stack<char>();
        Dictionary<char, char> m = new Dictionary<char, char>();
        char[] parenthesis = { '(', ')', '<', '>', '[', ']' };

        m.Add(parenthesis[0], parenthesis[1]);
        m.Add(parenthesis[2], parenthesis[3]);
        m.Add(parenthesis[4], parenthesis[5]);

        foreach (char c in s) {
            if (m.ContainsKey(c)) {
                st.Push(m[c]);
            } else if (st.Count == 0 || st.Pop() != c) {
                return 0;
            }
        }
        return st.Count == 0 ? 1 : 0;
    }
  
    public static int Func(string s, string a, string b) {
        bool bo = Regex.IsMatch(s, "^$");

        if (bo) {
            return -1;
        } else {
            int i = s.Length - 1;
            int aIndex = -1;
            int bIndex = -1;

            while ((aIndex == -1) && (bIndex == -1) && (i >= 0)) {
                if (s.Substring(i, 1) == a) {
                    aIndex = i;
                }
                if (s.Substring(i, 1) == b) {
                    bIndex = i;
                }

                i--;
            }

            if (aIndex != -1) {
                if (bIndex == -1) {
                    return aIndex;
                } else {
                    return Math.Max(aIndex, bIndex);
                }
            } else {
                if (bIndex != -1) {
                    return bIndex;
                } else {
                    return -1;
                }
            }
        }
    }
  
    public static int Func1(string s, string a, string b) {
        return s.Length == 0 ? -1 : Math.Max(s.LastIndexOf(a), s.LastIndexOf(b));
    }
}
