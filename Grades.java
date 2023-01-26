import java.util.InputMismatchException;
import java.util.Scanner;

class Grades {

    private int[] arr;
    private static int totalGrades;

    public Grades() {
        arr = new int[0];
    }

    public Grades(int[] myArr) {
        arr = myArr;
    }

    public void setValues(int[] myArr) {
        arr = myArr;
    }

    public int[] getValues() {
        return arr;
    }

    public int getHighest() {
        int highest = 0;
        for (int x : arr) {
            if (x > highest) {
                highest = x;
            }
        }
        return highest;
    }

    public int getLowest() {
        int lowest = arr[0];
        for (int x : arr) {
            if (x < lowest) {
                lowest = x;
            }
        }
        return lowest;
    }

    public int numOfGrades() {
        return arr.length;
    }

    public double getAvg() {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = (sum / arr.length) / 1.0;
        return avg;
    }

    public int failing(int gradeValue) {
        int failed = 0;
        for (int x : arr) {
            if (x < gradeValue) {
                failed++;
            }
        }
        return failed;
    }

    public void histogram() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int f = 0;
        for (int x : arr) {
            if (x < 60) {
                f++;
            } else if (x < 70) {
                d++;
            } else if (x < 80) {
                c++;
            } else if (x < 90) {
                b++;
            } else {
                a++;
            }
        }
        String star = "*";
        String A = "";
        for (int i = 0; i < a; i++) {
            A = A + star;
        }
        String B = "";
        for (int i = 0; i < b; i++) {
            B = B + star;
        }
        String C = "";
        for (int i = 0; i < c; i++) {
            C = C + star;
        }
        String D = "";
        for (int i = 0; i < d; i++) {
            D = D + star;
        }
        String F = "";
        for (int i = 0; i < f; i++) {
            F = F + star;
        }
        System.out.println("90 - 100 | " + A);
        System.out.println("80 - 89 | " + B);
        System.out.println("70 - 79 | " + C);
        System.out.println("60 - 69 | " + D);
        System.out.println("< 60 | " + F);
    }

    public static void scan() {

        try {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter the number of grades to input");

            totalGrades = myObj.nextInt();
            if(totalGrades < 0){
                System.out.println("Please enter a positive number");
                scan();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a positive number");
            scan();
        }
    }

    public static int checkGrade(){
        int grade = 0;
        try{
            Scanner myObj = new Scanner(System.in);
            grade = myObj.nextInt();
            if( grade > 100 || grade < 0){
                System.out.println("Please enter a number from 0 - 100");
                checkGrade();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number from 0 - 100");
            checkGrade();
        }
        return grade;
    }

    public static void main(String[] args) {
        scan();

        int[] myArr = new int[totalGrades];
        for (int i = 0; i < myArr.length; i++) {
            System.out.println("Enter grade #" + (i + 1));
            myArr[i] = checkGrade();
        }

        Grades gradeBook = new Grades(myArr);

        System.out.println("Highest = " + gradeBook.getHighest());
        System.out.println("Lowest = " + gradeBook.getLowest());
        System.out.println("Total grades = " + gradeBook.numOfGrades());
        System.out.println("Grade average = " + gradeBook.getAvg());
        System.out.println("Failed grades = " + gradeBook.failing(60));
        gradeBook.histogram();
    }
}
