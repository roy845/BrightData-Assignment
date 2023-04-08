package date;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class BrightDataAssignment {
	
	  public static int isValid(String s) {
	        Stack <Character> st = new Stack<>();
	        final Map<Character,Character> m = new HashMap<>();
	        final char[] parenthesis = {'(',')','<','>','[',']'};
	        
	        m.put(parenthesis[0],parenthesis[1]);
	        m.put(parenthesis[2],parenthesis[3]);
	        m.put(parenthesis[4],parenthesis[5]);

	        for(char c:s.toCharArray()){
	           if (m.containsKey(c))
	               st.push(m.get(c));
	          
	          else if(st.isEmpty() || st.pop()!=c)
	               return 0;
	        
	        }
	        return st.isEmpty() ? 1:0;
	    }
	  
	  public static int func(String s, String a, String b) {
			boolean bo = Pattern.matches("^$", s);

			if (bo)
				return -1;
			else {
				int i = s.length() - 1;
				int aIndex = -1;
				int bIndex = -1;

				while ((aIndex == -1) && (bIndex == -1) && (i >= 0)) {
					if (s.substring(i, i + 1).equals(a))
						aIndex = i;
					if (s.substring(i, i + 1).equals(b))
						bIndex = i;

					i--;
				}

				if (aIndex != -1) {
					if (bIndex == -1)
						return aIndex;
					else
						return Math.max(aIndex, bIndex);
				} else {
					if (bIndex != -1)
						return bIndex;
					else
						return -1;
				}
			}
		}
	  
	  public static int func1(String s,String a,String b) {
		  return s.isEmpty() ? -1 : Math.max(s.lastIndexOf(a), s.lastIndexOf(b));
	  }

	public static void main(String[] args) {
		
	}

}
