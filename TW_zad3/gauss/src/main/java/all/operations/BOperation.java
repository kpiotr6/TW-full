package all.operations;
// Klasa reprezentująca operację B
public class BOperation extends AbstractOperation{
    private int j;
    //    mMatrix służy do przechowywania cząstkowych wartości obliczeń m
    private double[][] mMatrix;
    //    nMatrix służy do przechowywania cząstkowych wartości obliczeń n
    private double[][] nMatrix;
    public BOperation(int i, int k, int j) {
        super(i, k);
        this.j = j-1;
    }
    public void setmMatrix(double[][] mMatrix) {
        this.mMatrix = mMatrix;
    }
    public void setnMatrix(double[][] nMatrix) {
        this.nMatrix = nMatrix;
    }

    @Override
    public double[][] call(){
        nMatrix[k][j] = matrix[i][j]*mMatrix[k][i];
        return matrix;
    }
}
