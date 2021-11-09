package Assgn3;

public class Row extends Rectangular{
    private int[] elements;

    Row(int c, int[] arr, int id) {
        super(1, c, null, id);
        System.arraycopy(arr, 0, elements, 0, arr.length);
    }

    public static int[][] create(int r, int c)
    {
        return null;
    }

    public static boolean isRow(int[][] A, int r, int c)
    {
        return r == 1 && c != 1;
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {
        this.elements[j] = a;
    }

    @Override
    public int[][] getData()
    {
        int[][] data = new int[1][this.getColumns()];
        for (int i=0; i<this.getColumns(); i++)
        {
            data[0][i] = this.elements[i];
        }
        return data;
    }

    @Override
    public int[][] multiply(Matrix other)
    {
        if (this.getColumns()!=other.getRows())
        {
            System.out.println("Dimensions do not match for multiplication");
            return null;
        }
        int[][] product = new int[1][other.getColumns()];
        int[][] A = this.getData();
        int[][] B = other.getData();
        int answer;

        for(int i=0; i<other.getColumns(); i++)
        {   answer = 0;
            for (int j=0; j<this.getColumns(); j++)
            {
                answer+=A[0][j]*B[i][j];
            }
            product[0][i] = answer;
        }
        return product;
    }

    @Override
    public float rowMean(int row)
    {
        float sum = 0;
        for (int ele:this.elements)
        {
            sum+=ele;
        }
        return sum;
    }

    @Override
    public float colMean(int col)
    {
        return (float) this.elements[col];
    }

    @Override
    public float allMean()
    {
        return this.rowMean(0);
    }
}
