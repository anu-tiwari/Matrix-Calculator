package Assgn3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static ArrayList<Matrix> matrices;
    public static void main(String[] args)
    {
        matrices = new ArrayList<>();
        int ch1;
        do
        {
            displayMainMenu();
            ch1 = scan.nextInt();
            if (ch1==1)
            {
                enterMatrix();
            }
            else if (ch1==2)
            {
                createMatrix();
            }
            else if (ch1==3)
            {
                editMatrix();
            }
        } while(true);
    }

    private static void editMatrix() {

    }

    private static void createMatrix() {

    }

    private static void enterMatrix() {

    }

    public static void displayMainMenu()
    {
        System.out.println("Choose among the following tasks:");
        System.out.println("1. Enter matrix");
        System.out.println("2. Create matrix of requested type");
        System.out.println("3. Edit matrix");
        System.out.println("4. Display labels of a matrix");
        System.out.println("5. Perform addition, subtraction, multiplication & division");
        System.out.println("6. Perform element-wise operations");
        System.out.println("7. Transpose matrix");
        System.out.println("8. Invert matrix");
        System.out.println("9. Compute means: row-wise mean, column-wise mean, mean of all the elements");
        System.out.println("10. Compute determinant");
        System.out.println("11. Use singleton matrices as scalars");
        System.out.println("12. Compute A+AT for a matrix A");
        System.out.println("13. Compute Eigen vectors and values");
        System.out.println("14. Solve sets of linear equations using matrices");
        System.out.println("15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels");
        System.out.println("16. Exit");
    }
}
