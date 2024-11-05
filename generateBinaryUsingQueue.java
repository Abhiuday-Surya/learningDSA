import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class generateBinaryUsingQueue {

    static String[] toBinary(int n) {
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of binary values to generate: ");
            int n = sc.nextInt();
            String[] binaryNumbers = toBinary(n);

            System.out.println("Generated binary numbers:");
            for (String binary : binaryNumbers) {
                System.out.println(binary);
            }
        }
    }
}
