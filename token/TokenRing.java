import java.util.Scanner;

public class TokenRing {
    private int numProcesses;
    private int tokenHolder;

    public TokenRing(int numProcesses) {
        this.numProcesses = numProcesses;
        this.tokenHolder = 0;
    }

    public void displayRing() {
        StringBuilder ring = new StringBuilder();
        for (int i = 0; i < numProcesses; i++) {
            ring.append(i);
        }
        System.out.println("Ring formed is as below: " + ring.toString());
    }

    public void processWantsAccess(int processId) {
        System.out.println("Process " + processId + " is in the critical section.");
        System.out.println("Process " + processId + " is accessing the shared resource.");
        System.out.println("Process " + processId + " releases the token.");
        tokenHolder = (processId + 1) % numProcesses;
    }

    public void execute() {
        displayRing();
        System.out.println("Process " + tokenHolder + " has the token.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the process ID that wants to access the shared resource: ");
            int processId = scanner.nextInt();
            if (processId == tokenHolder) {
                processWantsAccess(processId);
                displayRing();
            } else {
                System.out.println("Error: Process " + processId + " does not have the token.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();
        TokenRing tokenRing = new TokenRing(numProcesses);
        tokenRing.execute();
    }
}

