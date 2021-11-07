package Assgn3;

public class Column extends Rectangular{
    private int[] elements;

    Column(int r, int[] arr, int id) {
        super(r, 1, null, id);
        System.arraycopy(arr, 0, elements, 0, arr.length);
    }

    public static boolean isColumn(int[][] A, int r, int c)
    {
        return c == 1 && r != 1;
    }

    @Override
    protected void changeValue(int i, int j, int a)
    {
        this.elements[i] = a;
    }

    @Override
    public int[][] getData()
    {
        int[][] data = new int[this.getRows()][1];
        for (int i=0; i<this.getRows(); i++)
        {
            data[i][0] = this.elements[i];
        }
        return data;
    }

    public int[][] postMultiply(Matrix other){
        int[][] ans = new int[other.getRows()][1];
        int[][] A = other.getData();
        int answer;

        for (int i=0; i<other.getRows(); i++)
        {   answer = 0;
            for (int j=0; j<this.getRows(); j++)
            {
                answer+= A[i][j]*this.elements[j];
            }
            ans[i][0] = answer;
        }
        return ans;
    }

    public float[][] postMultiplywithInv(float[][] inv)
    {
        float[][] answer = new float[this.getRows()][1];
        for(int a =0; a<this.getRows(); a++)
        {
            answer[a][0] = 0;
        }
        for (int i=0; i<this.getRows(); i++)
        {
            for (int j=0; j<this.getRows(); j++)
            {
                answer[i][0]+= inv[i][j]*this.elements[j];
            }
        }
        return answer;
    }

    @Override
    public float rowMean(int row)
    {
        return (float) this.elements[row];
    }

    @Override
    public float colMean(int col)
    {
        float sum = 0;
        for (int ele:this.elements)
        {
            sum+=ele;
        }
        return sum;
    }

    @Override
    public float allMean()
    {
        return this.colMean(0);
    }
}
