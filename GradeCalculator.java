public class GradeCalculator {

    public static char calculate(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 50) return 'D';
        else return 'F';
    }
}