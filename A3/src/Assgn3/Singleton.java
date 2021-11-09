package Assgn3;

public class Singleton extends Square{
    private int element;

    Singleton(int element, int id) {
        super(1, null, id);
        this.element = element;
    }

    public static int[][] create(int r, int c)
    {
        return null;
    }

    public static boolean isSingleton(int[][] A, int r, int c)
    {
        return c == 1 && r == 1;
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {
        element = a;
    }

    @Override
    public int[][] getData()
    {
        int[][] temp = new int[1][1];

        temp[0][0] = this.element;

        return temp;
    }

    @Override
    public float determinant()
    {
        return this.element;
    }

    @Override
    public float[][] inverse()
    {
        float[][] answer = new float[1][1];
        answer[0][0] = 1/(float)element;
        return answer;
    }

    @Override
    public float rowMean(int row)
    {
        return this.element;
    }

    @Override
    public float colMean(int col)
    {
        return this.element;
    }

    @Override
    public float allMean()
    {
        return this.element;
    }

    @Override
    public float[][] SingletonAsScalar(Matrix other, int mode)
    {   //3 is mul, 4 is div
        int[][] A = other.getData();
        float[][] ans = new float[this.getRows()][this.getColumns()];

        for (int i=0; i<other.getRows(); i++)
        {
            for (int j=0; j<other.getColumns(); j++)
            {
                if (mode==1)
                {
                    ans[i][j] = A[i][j]*this.element;
                }
                else if (mode==2)
                {
                    ans[i][j] = (float)A[i][j]/this.element;
                }
                else
                {
                    System.out.println("Wrong operation entered!");
                    return null;
                }
            }
        }
        return ans;
    }
}
