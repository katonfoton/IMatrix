package Matrix;
import java.util.Iterator;
import java.util.LinkedList;

public class SparseMatrix extends UsualMatrix implements IMatrix{
	
	public LinkedList <Element> matrix;
	public int row;
	public int column;
	
	public SparseMatrix (int r, int c){
		super(r, c);
		matrix = new LinkedList <Element>();
	}
	
	public void setElement (int r, int c, int v){
		Element el = new Element(v, r, c); 
		Iterator <Element> it = matrix.listIterator();
		while(it.hasNext()) {
			Element a = it.next();
			if(a.getR() == el.getR() && a.getC() == el.getC()) {
				it.remove();
			}
		}
		
		if(v != 0) {
			matrix.add(el);
		}
	}
	
	public int getElement (int row, int column) {
		Iterator <Element> it = matrix.listIterator();
		while(it.hasNext()) {
			Element a = it.next();
			if(a.getR() == row && a.getC() == column) {
				return a.getV();
			}
		}
		return 0;
	}
	
	class Element {
		
		int value;
		int row;
		int column;
		
		public Element(int v, int r, int c) {
			value = v;
			row = r;
			column = c;
		}
		
		int getV() {
			return value;
		}
		
		int getR() {
			return row;
		}
		
		int getC() {
			return column;
		}
	}
}

