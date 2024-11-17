import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {

    public static boolean areBracketsBalanced(String exp) {
        Deque<Character> stack = new LinkedList<>();

        for (char ch : exp.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isCloseBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false; // Несоответствие или пустой стек
                }
            }
        }

        return stack.isEmpty(); // Стек должен быть пустым, если скобки сбалансированы
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }


    public static void main(String[] args) {
        String exp1 = "[()]{}{[()()]()}";
        String exp2 = "[(])";
        String exp3 = "{{}}";
        String exp4 = "({[}])";


        System.out.println(exp1 + ": " + areBracketsBalanced(exp1)); // true
        System.out.println(exp2 + ": " + areBracketsBalanced(exp2)); // false
        System.out.println(exp3 + ": " + areBracketsBalanced(exp3)); // true
        System.out.println(exp4 + ": " + areBracketsBalanced(exp4)); // false

    }
}