import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();
        double[] marks = new double[subjects];

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " out of 100: ");
            marks[i] = scanner.nextDouble();
        }

        
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        
        double averagePercentage = totalMarks / subjects;

        
        char grade = calculateGrade(averagePercentage);

        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90 && averagePercentage <= 100) {
            return 'A';
        } else if (averagePercentage >= 80 && averagePercentage < 90) {
            return 'B';
        } else if (averagePercentage >= 70 && averagePercentage < 80) {
            return 'C';
        } else if (averagePercentage >= 60 && averagePercentage < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
