import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ STUDENT RESULT SYSTEM ------");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Display Failed Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    int[] marks = new int[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Enter mark " + (i + 1) + ": ");
                        marks[i] = sc.nextInt();
                    }

                    Student s = new Student(roll, name, marks);
                    FileHandler.writeStudent(s);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    FileHandler.readAll();
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int r = sc.nextInt();
                    FileHandler.search(r);
                    break;

                case 4:
                    FileHandler.displayFailed();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}