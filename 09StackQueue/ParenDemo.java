public class ParenDemo{
    public static boolean isMatching(String s){
	if (str.isEmpty()){
	    return true;
	}
	MyStack<Character> stack = new MyStack<Character>();
	int i = 0;
	while (i < str.length()){
	    char c = s.charAt(i);
	    if (c == '{' || c == '(' || c == '['){
		stack.push(c);
	    }
	    if (c == '}' || c == ')' || c == ']'){
		
	    }
	    i++;
	}
	return stack.isEmpty();
    }
}
