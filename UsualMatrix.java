package Matrix;
public class UsualMatrix implements IMatrix {
	
	protected int [][] matrix;
	protected int row;
	protected int column;
	
	public UsualMatrix(int r, int c) {
		row = r;
		column = c;
		matrix  = new int[row][column];
	}
	public int getRows() {
		return row;
	}
	
	public int getColumns() {
		return column;
	}
	 public UsualMatrix(IMatrix other) {
	        this.row = other.getRows();
	        this.column = other.getColumns();
	        this.matrix = new int[row][column];
	        for (int i = 0; i < row; i++)
	            for (int j = 0; j < column; j++)
	                this.setElement(i, j, other.getElement(i, j));
	    }
	
	 public IMatrix sum (IMatrix q){
		IMatrix t = new UsualMatrix(row, column);
		if(this.column == q.getColumns() + 1){
			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){
					t.setElement(i, j, 0);
				}
			}
			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){
					int temp = q.getElement(i, j) + this.getElement(i, j);
					t.setElement(i, j, temp);
				}
			}
		}
		else{
			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){
					t.setElement(i, j, 0);
				}
			}
			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){
					int temp = q.getElement(i, j) + this.getElement(i, j);
					t.setElement(i, j, temp);
					}
				}
			}
			return t;
		}

		public IMatrix product (IMatrix q){ 
			UsualMatrix matrix = new UsualMatrix(row, q.getColumns());
			for(int i = 0; i < row; i++){
				for(int j = 0; j < q.getColumns(); j++){
					matrix.setElement(i, j, 0);
				}
			}
			for(int i = 0; i < row; i++){
				for(int j = 0; j < q.getColumns(); j++){
					for(int k = 0; k < column; k++){
						int temp = matrix.getElement(i, j) + this.getElement(i, k) * q.getElement(k, j);
						matrix.setElement(i, j, temp);
					}
				}
			}
			return matrix;
		}

	public int getElement(int r, int c) {
		return matrix[r][c];
	}
	
	public void setElement(int r, int c, int v) {
		matrix[r][c] = v;
	}
	
	final public boolean equals (IMatrix m){
		int flag = 0;
		if(row == m.getRows() && column == m.getColumns()){
			for(int i = 0; i < row; i++){
				for(int j = 0; j < column; j++){
					if(this.getElement(i, j) != m.getElement(i, j)){
						flag = 1;
					} 
				}
			}
		}
		else{
			flag = 1;
		}

		if(flag == 0) return true;
		else return false;
	}
	
	public final String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){ 
				sb.append(getElement(i, j) + " ");
			}
			sb.append("\n");
		} 
		String text = sb.toString();
		return text;
	}
}