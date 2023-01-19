import java.util.Scanner;

public class Grades {

    private int[] arr;

    public Grades(){
        arr = new int[0];
    }

    public Grades(int n){
        arr = new int[n];
    }

    public void setValues(int[] myArr){
        for(int x: arr){
            arr[x] = myArr[x];
        }
    }

    public int[] getValues(){
        return arr;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the number of grades to input");

        String totalGradesStr = myObj.nextLine();
        int totalGrades = Integer.parseInt(totalGradesStr);

        Grades gradeBook = new Grades(totalGrades);

        for (int i = 0; i < totalGrades; i++) {
            System.out.println("Enter grade #" + (i + 1));
            int grade = myObj.nextInt();

            gradeBook.arr[i] = grade;
        }
        System.out.println("Highest = " + gradeBook.getHighest());
        System.out.println("Lowest = " + gradeBook.getLowest());
        System.out.println("Total grades = " + gradeBook.getNumberOfGrades());
        System.out.println("Grade average = " + gradeBook.getAvg());
        System.out.println("Failed grades = " + gradeBook.failing(60));
        gradeBook.histogram();
    }

    public int getHighest(){
        int highest = 0;
        for(int x : arr){
            if(x > highest){
                highest = x;
            }
        }
        return highest;
    }

    public int getLowest(){
        int lowest = arr[0];
        for(int x : arr){
            if(x < lowest){
                lowest = x;
            }
        }
        return lowest;
    }

    public int getNumberOfGrades(){
        return arr.length;
    }

    public double getAvg(){
        double sum = 0.0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        double avg = (sum/arr.length)/1.0;
        return avg;
    }

    public int failing(int n){
        int failed = 0;
        for(int x : arr){
            if(x < n){
                failed++;
            }
        }
        return failed;
    }

    public void histogram(){
        int a = 0; int b = 0; int c = 0; int d = 0; int f = 0;
        for(int x : arr){
            if(x < 60){
                f++;
            }
            else if(x < 70){
                d++;
            }
            else if(x < 80){
                c++;
            }
            else if(x < 90){
                b++;
            }
            else{
                a++;
            }
        }
        String star = "*";
        String A = "";
        for(int i = 0; i < a; i++){
            A = A + star;
        }
        String B = "";
        for(int i = 0; i < b; i++){
            B = B + star;
        }
        String C = "";
        for(int i = 0; i < c; i++){
            C = C + star;
        }
        String D = "";
        for(int i = 0; i < d; i++){
            D = D + star;
        }
        String F = "";
        for(int i = 0; i < f; i++){
            F = F + star;
        }
        System.out.println("90 - 100 | " + A);
        System.out.println("80 - 89 | " + B);
        System.out.println("70 - 79 | " + C);
        System.out.println("60 - 69 | " + D);
        System.out.println("< 60 | " + F);
    }


}
