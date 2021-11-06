package Assgn3;

public class Column extends Rectangular{
    private int[] elements;

    Column(int r, int[] arr, int id) {
        super(r, 1, null, id);
        System.arraycopy(arr, 0, elements, 0, arr.length);
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
        return null;
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
}
