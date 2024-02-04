import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoDimMatrixChallenge {
    static Scanner sc = new Scanner(System.in);
    static int rows = 5;
    static int columns = 3;

    static int[][] matrix = new int[rows][columns];

    public static void initialize() {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                System.out.println("Please enter the element [" + (i + 1) + "][" + (j + 1) + "] of the matrix");
                try {
                    matrix[i][j] = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("You have made a mistake inserting the element [" + (i + 1) + "][" + (j + 1) + "] of the matrix");
                }
            }
        }
    }
    public static void print(){
        System.out.println("The matrix elements are");
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void sum(){
        int sum=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum+=matrix[i][j];
            }
        }
        System.out.println("The sum of all elements of the matrix is "+sum);
    }

    public static void transposeTheMatrix(){
        int[][] transposedMatrix = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i]=matrix[i][j];
            }
        }
        System.out.println("The transposed matrix elements are");
        System.out.println(Arrays.deepToString(transposedMatrix));
    }

    public static void main(String[] args) {
        initialize();
        print();
        sum();
        transposeTheMatrix();
    }
}
