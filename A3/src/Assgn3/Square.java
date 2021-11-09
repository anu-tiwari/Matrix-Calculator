package Assgn3;

public class Square extends Matrix{
    private int[][] data;

    Square(int r, int[][] data, int id)
    {
        super(r,r,id);
        if (data!=null) {
            this.data = new int[this.getRows()][this.getColumns()];

            for (int i = 0; i < this.getRows(); i++) {
                System.arraycopy(data[i], 0, this.data[i], 0, this.getColumns());
            }
        }
        else
        {
            this.data = null;
        }
    }

    public static boolean isSquare(int[][] A, int r, int c)
    {
        return r == c;
    }

    public static int[][] create(int r, int c)
    {
        int[][] arr = new int[r][c];
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                arr[i][j] = random.nextInt(20);
            }
        }
        return arr;
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {
        this.data[i][j] = a;
    }

    @Override
    public int[][] getData()
    {
        return this.data;
    }

    @Override
    public float[][] inverse()
    {
        if (this.determinant()==0)
        {
            System.out.println("This matrix is singular hence its inverse cannot be calculated");
            return null;
        }
        int[][] A = this.getData();
        float[][] adj = new float[this.getRows()][this.getColumns()];
        if (this.getRows()==2 && this.getColumns()==2)
        {
            adj[0][0] = (float)A[1][1];
            adj[1][1] = (float)A[0][0];
            adj[0][1] = (float)A[0][1]*(-1);
            adj[1][0] = (float)A[1][0]*(-1);
            return Matrix.multiplybyScalar(adj, (1/this.determinant()), 2, 2);
        }
        else
        {
            adj[0][0] = (float)A[0][0]*((float)A[1][1]*(float)A[2][2] - (float)A[2][1]*(float)A[1][2]);
            adj[0][1] = ((float)A[0][1]*((float)A[1][0]*(float)A[2][2] - (float)A[2][0]*(float)A[1][2]))*(-1);
            adj[0][2] = (float)A[0][2]*((float)A[1][0]*(float)A[2][1] - (float)A[2][0]*(float)A[1][1]);
            adj[1][0] = ((float)A[1][0]*((float)A[0][1]*(float)A[2][2] - (float)A[2][1]*(float)A[0][2]))*(-1);
            adj[1][1] = (float)A[1][1]*((float)A[0][0]*(float)A[2][2] - (float)A[2][0]*(float)A[0][2]);
            adj[1][2] = ((float)A[1][2]*((float)A[0][0]*(float)A[2][1] - (float)A[2][0]*(float)A[0][1]))*(-1);
            adj[2][0] = (float)A[2][0]*((float)A[0][1]*(float)A[1][2] - (float)A[1][1]*(float)A[0][2]);
            adj[2][1] = ((float)A[2][1]*((float)A[0][0]*(float)A[1][2] - (float)A[1][0]*(float)A[0][2]))*(-1);
            adj[2][2] = (float)A[2][2]*((float)A[0][0]*(float)A[1][1] - (float)A[2][1]*(float)A[1][2]);
        }
        float[][] transpose = new float[this.getColumns()][this.getRows()];

        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getColumns(); j++)
            {
                transpose[j][i] = adj[i][j];
            }
        }
        return Matrix.multiplybyScalar(transpose, (1/this.determinant()), 3, 3);
    }

    @Override
    public float[][] solveEq(Matrix other)
    {
        if (!(other instanceof Column))
        {
            System.out.println("The second matrix is not a column matrix");
            return null;
        }
        if (other.getRows()!=this.getRows())
        {
            System.out.println("The second matrix does not have same number of rows as first");
            return null;
        }
        float[][] A = this.inverse();
        if (A==null)
        {
            System.out.println("The first matrix does not have an inverse hence can't solve the linear equation");
            return null;
        }
        return ((Column) other).postMultiplywithInv(A);
    }

    @Override
    public float determinant()
    {
        float answer = 0;
        int[][] A = this.getData();
        if (this.getRows()==1 && this.getColumns()==1)
            return (float) A[0][0];
        if (this.getRows()==2 && this.getColumns()==2)
        {
            answer = A[0][0]*A[1][1] - A[0][1]*A[1][0];
            return answer;
        }
        answer = A[0][0]*(A[1][1]*A[2][2]-A[2][1]*A[1][2]) - A[0][1]*(A[1][0]*A[2][2]-A[2][0]*A[1][2]) + A[0][2]*(A[1][0]*A[2][1]-A[2][0]*A[1][1]);
        return answer;
    }

    @Override
    public float[] eigenvalues()
    {
        int a=1;
        int b;
        int c;
        int[][] A = this.getData();

        b = (-1)*(A[0][0]+A[1][1]);
        c = A[0][0]*A[1][1] - A[0][1]*A[1][0];
        float det = (float) Math.sqrt(b*b - 4*a*c);
        float[] ans = new float[2];
        ans[0] = ((-1)*b + det)/2*a;
        ans[1] = ((-1)*b - det)/2*a;

        return ans;
    }
}
