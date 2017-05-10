package PD;

public class Strategy {
	public String strategy;
	int[] strategyArray = new int[4];
	public Strategy(String s){
		strategy = s;
		char[] charArray = strategy.toCharArray();
		for(int i = 0; i< charArray.length; i++){
			int value = Character.getNumericValue(charArray[i]);
			strategyArray[i] = value;
		}
		System.out.println(strategyArray[0]+""+strategyArray[1]+""+strategyArray[2]+""+strategyArray[3]);
	}
}
