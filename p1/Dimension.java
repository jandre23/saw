package p1;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

//1200 on venus

abstract class Dimension {
	String coordinates;

	String getCoor() {
		return "(" + coordinates + ")";
	}
	
	public abstract double squareD();

}
