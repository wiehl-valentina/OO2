package ar.edu.unlp.info.oo1._IteradoresCirculares;

public class IntRing extends Ring {
	
	private int[] source;

    public IntRing(int[] src) {
    	super(); 
        source = src;
    }

    public int next() {
        return source[getNextIndex(source.length)];
    }
    
}
