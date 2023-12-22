package all.operations;

public abstract class AbstractOperation extends Thread{
    private int i;
    private int k;
    private double matrix[][];
    public AbstractOperation(int i, int k) {
        this.i = i;
        this.k = k;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public abstract void run();
}
