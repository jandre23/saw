package p1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadArith {

	public static Map<Integer, double[]> sqDis;

	public ThreadArith() {
		sqDis = new HashMap<Integer, double[]>();
	}

	public static void add(pseudoThread t) {
		if (sqDis.isEmpty()) {
			sqDis.putAll(t.sqDis);

		} else {
			for (int i = Globals.start_n; i <= Globals.n; i++) {
				double[] x = sqDis.get(i);
				double[] y = t.sqDis.get(i);

				x[0] += y[0];
				x[1] += y[1];
				sqDis.put(i, x);
			}

		}

	}

	public static void print(int i) {
		double[] x = sqDis.get(i);
		System.out.println("         " + i + "          " + x[0] / x[1] + "      "
				+ x[1] / (double) (Globals.N_T * Globals.N_W));

	}
	

}
