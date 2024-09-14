import java.util.*;

public class StudentGrade_Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        int numberOfSubjects = 5;
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

       
        System.out.println("Enter marks obtained in " + numberOfSubjects + " subjects (out of 100 each):");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        
        int totalPossibleMarks = numberOfSubjects * 100;
        double averagePercentage = (double) totalMarks / totalPossibleMarks * 100;

        // Determine grade based on average percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else {
            grade = 'D';
        }

      
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}