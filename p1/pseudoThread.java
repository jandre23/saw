package p1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class pseudoThread extends Thread {

	int dimension;

	public double sqDistanceTot;
	public Map<Integer, double[]> sqDis = new HashMap<Integer, double[]>();
	double n_saw;
	boolean poly;

	public pseudoThread(int numDim, boolean poly) {

		dimension = numDim;

		sqDistanceTot = 0;
		n_saw = 0;
		this.poly = poly;

	}

	public void run() {
		try {
			// dimensionRun();

			for (int i = Globals.start_n; i < Globals.n + 1; i++) {

				dimensionRun(i);

			}

		} catch (Exception e) {
			System.out.println("exception caught");
		}

	}

	static int[] next(int r, Dimension pos) {
		int[] temp = null;

		if (pos instanceof Second) {

			if (r == 0) {
				temp = ((Second) pos).moveX(1);
			} else if (r == 1) {
				temp = ((Second) pos).moveX(-1);
			} else if (r == 2) {
				temp = ((Second) pos).moveY(1);
			} else {
				temp = ((Second) pos).moveY(-1);
			}

		}

		else if (pos instanceof Third) {
			if (r == 0) {
				temp = ((Third) pos).moveX(1);
			} else if (r == 1) {
				temp = ((Third) pos).moveX(-1);
			} else if (r == 2) {
				temp = ((Third) pos).moveY(1);
			} else if (r == 3) {
				temp = ((Third) pos).moveY(-1);
			} else if (r == 4) {
				temp = ((Third) pos).moveZ(1);
			}

			else {
				temp = ((Third) pos).moveZ(-1);
			}

		} else if (pos instanceof Fourth) {
			if (r == 0) {
				temp = ((Fourth) pos).moveX(1);
			} else if (r == 1) {
				temp = ((Fourth) pos).moveX(-1);
			} else if (r == 2) {
				temp = ((Fourth) pos).moveY(1);
			} else if (r == 3) {
				temp = ((Fourth) pos).moveY(-1);
			} else if (r == 4) {
				temp = ((Fourth) pos).moveZ(1);
			} else if (r == 5) {
				temp = ((Fourth) pos).moveZ(-1);
			} else if (r == 6) {
				temp = ((Fourth) pos).moveK(1);
			}

			else {
				temp = ((Fourth) pos).moveK(-1);
			}

		}

		return temp;
	}

	public String getCoorStr(int[] arr) {

		if (arr.length == 2)
			return "(" + arr[0] + "," + arr[1] + ")";
		else if (arr.length == 3)
			return "(" + arr[0] + "," + arr[1] + "," + arr[2] + ")";
		else
			return "(" + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + ")";

	}

//for run of start value to n value 
	public void dimensionRun(int n2) {

		double[] sqDis2 = new double[2];

		if (dimension == 2) {
			double sqDistanceTot2 = 0;
			double n_saw2 = 0;
			Map<String, Dimension> stringC = new HashMap<String, Dimension>();

			for (int j = 0; j < Globals.N_W; j++) {

				Dimension current = new Second();

				for (int i = 0; i < n2 + 1; i++) {

					int x;
					int y;
					int r = 
					if (i == 0) {

						Dimension location = new Second(0, 0);

						stringC.put(((Second) location).getCoor(), location);
						((Second) current).tran((Second) location);

					} else {
						int[] next = next(r, current);

						if (i == n2 && poly == true) {

							if (next[0] == 0 && next[1] == 0) {
								{
									stringC.clear();

									n_saw2++;
									sqDis2[0] = 0;
									sqDis2[1] = n_saw2;

									break;

								}

							}
							break;
						}

						if (!(stringC.containsKey(getCoorStr(next))))

						{

							x = next[0];
							y = next[1];

							Dimension location = new Second(x, y);
							stringC.put(((Second) location).getCoor(), location);
							((Second) current).tran((Second) location);

						}

						else {
							stringC.clear();
							break;

						}
					}
					if (i == n2) {

						stringC.clear();

						n_saw2++;

						sqDis2[1] = n_saw2;

						break;
					}

				}

				sqDis.put(n2, sqDis2);
			}

		}

		else if (dimension == 3) {
			double sqDistanceTot2 = 0;
			Map<String, Third> stringC = new HashMap<String, Third>();
			double n_saw2 = 0;
			for (int j = 0; j < Globals.N_W; j++) {

				Dimension current = new Third();

				for (int i = 0; i < n2 + 1; i++) {

					int x;
					int y;
					int z;
					int r = ThreadLocalRandom.current().nextInt(6);

					if (i == 0) {

						Dimension location = new Third(0, 0, 0);

						stringC.put(((Third) location).getCoor(), (Third) location);
						((Third) current).tran((Third) location);

					} else {
						int[] next = next(r, (Third) current);
						if (i == n2 && poly == true) {

							if (next[0] == 0 && next[1] == 0 && next[2] == 0) {
								{
									stringC.clear();
									System.out.println(n_saw2);
									n_saw2++;

									sqDis2[1] = n_saw2;

									break;

								}

							}
							break;
						}

						if (!(stringC.containsKey(getCoorStr(next))))

						{

							x = next[0];
							y = next[1];
							z = next[2];
							Dimension location = new Third(x, y, z);
							stringC.put(((Third) location).getCoor(), (Third) location);
							((Third) current).tran((Third) location);

						}

						else {

							stringC.clear();

							break;

						}
					}
					if (i == n2) {

						stringC.clear();
						sqDistanceTot2 += current.squareD();
						n_saw2++;
						sqDis2[0] = sqDistanceTot2;
						sqDis2[1] = n_saw2;
						break;
					}
				}
				sqDis.put(n2, sqDis2);
			}

		} else if (dimension == 4) {
			double sqDistanceTot2 = 0;
			double n_saw2 = 0;
			Map<String, Fourth> stringC = new HashMap<String, Fourth>();

			for (int j = 0; j < Globals.N_W; j++) {

				Dimension current = new Fourth();

				for (int i = 0; i < n2 + 1; i++) {

					int x;
					int y;
					int z;
					int k;
					int r = ThreadLocalRandom.current().nextInt(8);

					if (i == 0) {

						Dimension location = new Fourth(0, 0, 0, 0);

						stringC.put(((Fourth) location).getCoor(), (Fourth) location);
						((Fourth) current).tran((Fourth) location);

					} else {
						int[] next = next(r, (Fourth) current);

						if (i == n2 && poly == true) {

							if (next[0] == 0 && next[1] == 0 && next[2] == 0 && next[3] == 0) {
								{
									stringC.clear();

									n_saw2++;

									sqDis2[1] = n_saw2;

									break;

								}

							}
							break;
						}

						if (!(stringC.containsKey(getCoorStr(next))))

						{

							x = next[0];
							y = next[1];
							z = next[2];
							k = next[3];
							Dimension location = new Fourth(x, y, z, k);
							stringC.put(((Fourth) location).getCoor(), (Fourth) location);
							((Fourth) current).tran((Fourth) location);

						}

						else {

							stringC.clear();

							break;

						}
					}
					if (i == n2) {

						stringC.clear();
						sqDistanceTot2 += current.squareD();
						n_saw2++;
						sqDis2[0] = sqDistanceTot2;
						sqDis2[1] = n_saw2;
						break;
					}
				}

				sqDis.put(n2, sqDis2);
			}

		}

	}

}
