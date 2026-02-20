import java.io.*;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    public static void writeStudent(Student s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(s.rollNo + "," + s.name);
            for (int m : s.marks) {
                bw.write("," + m);
            }
            bw.write("," + s.total + "," + s.average + "," + s.grade);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("File write error!");
        }
    }

    public static void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n---- STUDENT RECORDS ----");
            while ((line = br.readLine()) != null) {
                printLine(line);
            }
        } catch (IOException e) {
            System.out.println("No records found!");
        }
    }

    public static void search(int roll) {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == roll) {
                    printLine(line);
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("File read error!");
        }
        if (!found) System.out.println("Student not found!");
    }

    public static void displayFailed() {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n---- FAILED STUDENTS ----");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[data.length - 1].charAt(0) == 'F') {
                    printLine(line);
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println("File read error!");
        }
        if (!found) System.out.println("No failed students!");
    }

    private static void printLine(String line) {
        String[] d = line.split(",");
        System.out.println("Roll: " + d[0] + " Name: " + d[1] +
                " Total: " + d[7] + " Avg: " + d[8] + " Grade: " + d[9]);
    }
}