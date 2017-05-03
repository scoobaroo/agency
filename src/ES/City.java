package ES;

import Agency.Dispatcher;

public class City extends Dispatcher {
	String[][] cityblock = new String[10][10];
	Double threshold = 0.5;
	
	public static void main(String[] args){
		System.out.println("Inside Emergent Segregation Application");
	}
}
