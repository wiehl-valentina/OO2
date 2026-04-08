package ar.edu.unlp.info.oo1._IteradoresCirculares;

public abstract class Ring {
	
	protected int idx;
	
	public Ring() {
		idx = 0;
	}
	
	protected int getNextIndex(int length) {
		if (idx >= length)
            idx = 0;
    	return idx++;
	}
	
}
