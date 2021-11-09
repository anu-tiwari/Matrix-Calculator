package Assgn3;

public class Singular extends Square{
    Singular(int r, int[][] data, int id) {
        super(r, data, id);
    }

    public static int[][] create(int r, int c)
    {
        int num = random.nextInt(20);
        int[][] arr = new int[r][c];
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                arr[i][j] = num;
            }
        }
        return arr;
    }

    @Override
    public float determinant()
    {
        return 0;
    }

    public static boolean isSingular(int[][] A, int r, int c)
    {
        if (r!=c)
            return false;
        Square temp = new Square(r, A, -1);
        float det = temp.determinant();
        temp = null;
        return det == 0;
    }

    @Override
    public float[][] inverse()
    {
        System.out.println("Singular matrices do not have an inverse");
        return null;
    }
}
