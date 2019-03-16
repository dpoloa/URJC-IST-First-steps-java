package es.urjc.ist.coolcoffee;

public enum Size {
	// Enumerates
	S, M, L;
	
	// Operations
	public boolean isSizeAppropriate() {
		if (this instanceof Size) {
			switch(this) {
				case S: case M: case L:
					return true;
				default:
					return false;
			} 	
		}
		return false;
	}
	
	public static void main (String[] args) {
		System.out.println(Size.S);
		System.out.println(Size.M);
		System.out.println(Size.L);
	}
}
