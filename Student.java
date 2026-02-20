public class Student {
    int rollNo;
    String name;
    int[] marks;
    int total;
    double average;
    char grade;

    public Student() {
        marks = new int[5];
    }

    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        calculate();
    }

    public void calculate() {
        total = 0;
        for (int m : marks) {
            total += m;
        }
        average = total / 5.0;
        grade = GradeCalculator.calculate(average);
    }

    // Method Overloading
    public void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Total   : " + total);
        System.out.println("Average : " + average);
        System.out.println("Grade   : " + grade);
    }

    public void display(boolean detailed) {
        display();
        if (detailed) {
            System.out.print("Marks   : ");
            for (int m : marks) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }

    public boolean isFailed() {
        return grade == 'F';
    }
}