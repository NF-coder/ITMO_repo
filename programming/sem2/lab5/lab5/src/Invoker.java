import java.util.Scanner;

public class Invoker {
    private Scanner input = new Scanner(System.in);

    public void main() {
        while (this.input.hasNextLine()) {
            String line = input.nextLine();
            String[] tokens = line.split(" ");
            this.printTokens(tokens);
        }
    }

    private void printTokens(String[] tokens){
        int idx = 0;
        for (String token : tokens) {
            System.out.print("Token #" + idx + ": ");
            System.out.println(token);
            idx++;
        }
    }
}
