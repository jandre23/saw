package p1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class main {

	public static void main(String[] args) throws InterruptedException {

		// long startTime = System.nanoTime();
		List<pseudoThread> threads = new ArrayList<>();
		int dim = 3;

		for (int i = 0; i < Globals.N_T; i++) {
			// pseudoThread takes as parameter the number of dimensions and if it is a self
			// avoiding polygon
			pseudoThread thread1 = new pseudoThread(dim, false);

			threads.add(thread1);
			thread1.start();
		}

		double N_SAW_tot = 0;
		double end_sq_distance_tot = 0;

		
		ThreadArith thr = new ThreadArith();

		for (Thread t : threads) {
			double N_SAW_tot2 = 0;
			double end_sq_distance_tot2 = 0;

			t.join();
			
			ThreadArith.add((pseudoThread) t);

		}
		System.out.println("running in " + dim + " dimensions");
		System.out.println("****** value of N ******* value of Rn^2 ******* Value of F_SAW ******");
		
		
		for (int i = Globals.start_n; i <= Globals.n; i++) {

			ThreadArith.print(i);

		}
		
		

	}

}
