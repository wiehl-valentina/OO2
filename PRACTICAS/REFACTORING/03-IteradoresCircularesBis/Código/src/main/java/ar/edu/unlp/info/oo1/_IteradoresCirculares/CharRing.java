package ar.edu.unlp.info.oo1._IteradoresCirculares;

public class CharRing extends Ring {
	
	private char[] source;

    public CharRing(String src) {
    	super(); 
        source = src.toCharArray();
    }

    public char next() {
    	return source[getNextIndex(source.length)];
    }
    
}
