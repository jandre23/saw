package p1;

public class Second extends Dimension {

	int x;
	int y;

	public Second() {
		coordinates = null;
		x = y = 0;
	}
	public Second(Second s) {
		this.x = s.x;
		this.y = s.y;
		coordinates = s.coordinates;
		
		
	}

	public Second(int x, int y) {
		coordinates = Integer.toString(x) + "," + Integer.toString(y);
		this.x = x;
		this.y = y;
	}

	public int[] moveY(int r) {
		int[] arr = new int[2];
		arr[0] = x;
		arr[1] = y + r;

		return arr;

	}

	public int[] moveX(int r) {

		int[] arr = new int[2];
		arr[0] = x + r;
		arr[1] = y;

		return arr;

	}

	public void tran(Second s) {
		this.x = s.x;
		this.y = s.y;
		coordinates = s.coordinates;

	}
public double squareD() {
		
		return Math.pow(x, 2)+Math.pow(y, 2);
	}

}
