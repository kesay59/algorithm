import java.io.*;
import java.util.*;

public class BJ3425 {
    private static class GoStack {
        private final static int LIMIT = (int) Math.pow(10, 9);
        Stack<Integer> stack = new Stack<>();
        List<String> orders = null;
        GoStack(List<String> orders) {
            this.orders = orders;
        }
        String calculate(int n) {
            stack.clear();
            stack.push(n);
            for(String order : orders) {
                if (order.matches("NUM \\d*")) {
                    stack.push(Integer.parseInt(order.split(" ")[1]));
                } else if (order.equals("POP")) {
                    if (stack.isEmpty()) {
                        return "ERROR";
                    }
                    stack.pop();
                } else if (order.equals("INV")) {
                    if (stack.isEmpty()) {
                        return "ERROR";
                    }
                    stack.push(stack.pop() * -1);
                } else if (order.equals("DUP")) {
                    if (stack.isEmpty()) {
                        return "ERROR";
                    }
                    stack.push(stack.peek());
                } else if (order.equals("SWP")) {
                    if (stack.size() < 2) {
                        return "ERROR";
                    }
                    Queue<Integer> tmp = new LinkedList<>();
                    tmp.offer(stack.pop());
                    tmp.offer(stack.pop());
                    stack.push(tmp.poll());
                    stack.push(tmp.poll());
                } else if (order.equals("ADD")) {
                    if (stack.size() < 2) {
                        return "ERROR";
                    }
                    int num = stack.pop() + stack.pop();
                    if (Math.abs(num) > LIMIT) {
                        return "ERROR";
                    }
                    stack.push(num);
                } else if (order.equals("SUB")) {
                    if (stack.size() < 2) {
                        return "ERROR";
                    }
                    int num = stack.pop();
                    num = stack.pop() - num;
                    if (Math.abs(num) > LIMIT) {
                        return "ERROR";
                    }
                    stack.push(num);
                } else if (order.equals("MUL")) {
                    if (stack.size() < 2) {
                        return "ERROR";
                    }
                    long num = ((long) stack.pop()) * stack.pop();
                    if (Math.abs(num) > LIMIT) {
                        return "ERROR";
                    }
                    stack.push((int) num);
                } else if (order.equals("DIV")) {
                    if (stack.size() < 2) {
                        return "ERROR";
                    }
                    int divisor = stack.pop();
                    if(divisor == 0) {
                        return "ERROR";
                    }
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                } else if (order.equals("MOD")) {
                    if (stack.size() < 2) {
                        return "ERROR";
                    }
                    int divisor = stack.pop();
                    if(divisor == 0) {
                        return "ERROR";
                    }
                    int dividend = stack.pop();
                    stack.push(dividend % divisor);
                }
            }
            if(stack.size() != 1) {
                return "ERROR";
            }
            return Integer.toString(stack.pop());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while(true) {
            String inp = br.readLine();
            if("QUIT".equals(inp)) {
                break;
            } else {
                List<String> orders = new ArrayList<>();
                while(!"END".equals(inp)) {
                    orders.add(inp);
                    inp = br.readLine();
                }
                GoStack goStack = new GoStack(orders);
                int N = Integer.parseInt(br.readLine());
                for(int n = 0; n < N; n++) {
                    answer.append(goStack.calculate(Integer.parseInt(br.readLine()))).append('\n');
                }
                answer.append('\n');
                br.readLine();
            }
        }
        System.out.println(answer.toString());
    }
}