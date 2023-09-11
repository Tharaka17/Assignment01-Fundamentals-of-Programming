import java.util.Scanner;

public class AssessmentStat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the assessment name from the user
        System.out.print("Enter the  name: ");
        String assessmentName = scanner.nextLine();

        //Create an array to store 30 students marks 
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

        // To Cal the stat
        int numStudents = 0; // If fewer than 30 students were entered, set the value to 0.
        int totalMarks = 0;
        int minMark = studentMarks[0];
        int maxMark = studentMarks[0];

        for (int j = 0; j < studentMarks.length && studentMarks[j] != 0; j++) {
            numStudents++;
            totalMarks += studentMarks[j];
            if (studentMarks[j] < minMark) {
                minMark = studentMarks[j];
            }
            if (studentMarks[j] > maxMark) {
                maxMark = studentMarks[j];
            }
        }

        double averageMark = (double) totalMarks / numStudents;

        System.out.println("\nAssessment Name: " + assessmentName);
        System.out.println("Number of Students: " + numStudents);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Mark: " + averageMark);
        System.out.println("Minimum Mark: " + minMark);
        System.out.println("Maximum Mark: " + maxMark);

        //Calculate and display the highest and lowest marks

        int highestMark = findHighestMark(studentMarks);
        int lowestMark = findLowestMark(studentMarks);

        System.out.println("\nHighest Mark: " + highestMark);
        System.out.println("Lowest Mark: " + lowestMark);

        scanner.close();

    }

    //  Find the highest mark
    public static int findHighestMark(int[] marks) {
        int highest = marks[0];
        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }
    // Find the lowest mark
    public static int findLowestMark(int[] marks) {
        int lowest = marks[0];
        for (int mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }

}
