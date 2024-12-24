public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks

        // Solve the Tower of Hanoi puzzle with n disks
        solveHanoi(n, 'A', 'C', 'B'); // A, B, and C are names of rods
    }
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        // Base case: If there's only one disk, move it from 'fromRod' to 'toRod'
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }

        // Recursive case: Move n-1 disks from 'fromRod' to 'auxRod' using 'toRod' as auxiliary
        solveHanoi(n - 1, fromRod, auxRod, toRod);

        // Move the nth disk from 'fromRod' to 'toRod'
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);

        // Move the n-1 disks from 'auxRod' to 'toRod' using 'fromRod' as auxiliary
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    // Main function
}
