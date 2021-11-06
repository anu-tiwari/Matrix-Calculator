package Assgn3;

public class Singleton extends Square{
    private int element;

    Singleton(int element) {
        super(1, null);
        this.element = element;
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
}
