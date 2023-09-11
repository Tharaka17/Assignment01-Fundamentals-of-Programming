import java.util.Scanner;

public class AssessmentStat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the assessment name from the user
        System.out.print("Enter the  name: ");
        String assessnmentName = scanner.nextLine();

        // Create an array to store 30 students marks 
        int[] studentMarks = new int[30];

        //Get the marks for each student
        for (int i = 0; i < studentMarks.length; i++) {
            System.out.print("Please input the marks for Student " + (i + 1) + ": ");
            int mark = scanner.nextInt();

            // For check Validation of the mark
            if (mark < 0 || mark > 30) {
                System.out.println("Error: Invalid mark. Please enter a mark between 0 and 30.");
                i--; 
            } else {
                studentMarks[i] = mark;
            }

            // Check if all students have been assigned marks
            if (i == studentMarks.length - 1) {
                System.out.println("Maximum number of students get.");
            } else {
                System.out.print("Do you wish to enter marks for another student? (yes/no): ");
                String response = scanner.next();

                if (!response.equalsIgnoreCase("yes")) {
                    break; 
                }
            }
        }
    }
}
