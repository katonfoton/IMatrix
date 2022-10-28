package Matrix;

public class SquareMatrix extends UsualMatrix implements IMatrix{
	private int size;
	public SquareMatrix(int s){
		super(s,s);
		size = s;
		for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (i == j)
                    this.setElement(i, j, 1);
	}
}