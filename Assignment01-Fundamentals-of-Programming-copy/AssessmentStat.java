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

        /*  Algorithm 1 (Pseudo Code):

        1. Initialize `highestMark` and `lowestMark` as the first student's mark.
        2. For each student's mark from the second student to the last student:
        a. If the current mark is higher than `highestMark`, update `highestMark`.
        b. If the current mark is lower than `lowestMark`, update `lowestMark`.
        3. Print `highestMark` as the highest mark.
        4. Print `lowestMark` as the lowest mark.*/

        // Implement Algorithm 1 to print the highest and lowest marks
        int highestMark = studentMarks[0]; // Begin with the first student's mark.
        int lowestMark = studentMarks[0];  // Begin with the first student's mark.

        for (int i = 1; i < studentMarks.length && studentMarks[i] != 0; i++) {
            if (studentMarks[i] > highestMark) {
                highestMark = studentMarks[i];
            }
            if (studentMarks[i] < lowestMark) {
                lowestMark = studentMarks[i];
            }
        }

        // Display the highest and lowest marks
        System.out.println("\nHighest Mark: " + highestMark);
        System.out.println("Lowest Mark: " + lowestMark);
        
        /*  Algorithm 2 (Pseudo Code):

        1. Initialize `sum` as 0 and `sumSquares` as 0.
        2. For each student's mark from the first student to the last student:
           a. Add the current mark to `sum`.
           b. Add the square of the current mark to `sumSquares`.
        3. Calculate the mean as `sum` divided by the number of students.
        4. Calculate the standard deviation as the square root of [(sum of squares - (sum * sum) / number of students) / (number of students - 1)].
        5. Print the mean.
        6. Print the standard deviation.*/
        
        // Step 7: Calculate the mean and standard deviation
        
        double sum = 0;
        double sumSquares = 0;

        for (int i = 0; i < studentMarks.length && studentMarks[i] != 0; i++) {
            sum += studentMarks[i];
            sumSquares += Math.pow(studentMarks[i], 2);
        }

        double mean = sum / numStudents;

        double variance = (sumSquares - (Math.pow(sum, 2) / numStudents)) / (numStudents - 1);
        double stdDeviation = Math.sqrt(variance);

        // Step 8: Display the mean and standard deviation
        System.out.println("\nMean: " + mean);
        System.out.println("Standard Deviation: " + stdDeviation);

        scanner.close();
        
        

    }


}
