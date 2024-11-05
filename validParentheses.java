import java.util.Stack;

public class validParentheses {
    public static void main(String[] args) {
        System.out.println(checkValidParentheses("[{()}]"));
        System.out.println(checkValidParentheses("[{)}]"));
        System.out.println(checkValidParentheses("[{()}"));
    }

    static boolean checkValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars=str.toCharArray();
        for(char c : chars) {
            if (c=='{'||c=='['||c=='(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (c==')'&&top=='('||c=='}'&&top=='{'||c==']'&&top=='[') {
                        stack.pop();
                    } else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
