package Matrix;
import java.util.HashMap;

public class SparseMatrix2 extends UsualMatrix implements IMatrix{
	
	public HashMap <Element,Integer> matrix;
	public int row;
	public int column;
	
	public SparseMatrix2 (int r, int c){
		super(r, c);
		matrix = new HashMap <Element, Integer>();
	}
	
	public void setElement (int r, int c, int v){
		Element el = new Element(r, c); 
		if(matrix.get(el) != null)
			matrix.remove(el);
	    if(v != 0)
	    	matrix.put(el, v);
	}
	
	public int getElement (int row, int column) {
		Element el = new Element(row,column);
        if(matrix.get(el) == null)
        	return 0;
        return matrix.get(el);
	}
	
	class Element {
		
		int row;
		int column;
		
		public Element(int r, int c) {
			row = r;
			column = c;
		}
		
		int getR() {
			return row;
		}
		
		int getC() {
			return column;
		}
	}
}