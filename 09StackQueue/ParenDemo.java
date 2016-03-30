public class ParenDemo{
    public static boolean isMatching(String s){
	if (s.length() == 0){
	    return true;
	}
	MyStack<Character> stack = new MyStack<Character>();
	int i = 0;
	while (i < s.length()){
	    char c = s.charAt(i);
	    if (c == '{' || c == '(' || c == '[' || c == '<'){
		stack.push(c);
	    }
	    if (c == '}' || c == ')' || c == ']' || c == '>'){
		if (stack.isEmpty()){
		    return false;
		} else {
		    if (matchingParenHelper(stack, c)){
			stack.pop();
		    } else {
			return false;
		    }
		}
	    }
	    i++;
	}
	return stack.isEmpty();
    }

    public static boolean matchingParenHelper(MyStack stack, char c){
	return (stack.peek() == '{' && c == '}' ||
		stack.peek() == '(' && c == ')' ||
		stack.peek() == '[' && c == ']' ||
		stack.peek() == '<' && c == '>');
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }
}
