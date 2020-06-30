package p1;

public class Third extends Dimension {

	int x;
	int y;
	int z;

	public Third() {
		coordinates = null;
		x = y = z = 0;
	}

	public Third(int x, int y, int z) {
		coordinates = Integer.toString(x) + "," + Integer.toString(y) + "," + Integer.toString(z);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int[] moveY(int r) {
		int[] arr = new int[3];
		arr[0] = x;
		arr[1] = y + r;
		arr[2] = z;

		return arr;

	}

	public int[] moveX(int r) {

		int[] arr = new int[3];
		arr[0] = x + r;
		arr[1] = y;
		arr[2] = z;
		return arr;

	}

	public int[] moveZ(int r) {

		int[] arr = new int[3];
		arr[0] = x;
		arr[1] = y;
		arr[2] = z + r;
		return arr;

	}

	public void tran(Third s) {
		this.x = s.x;
		this.y = s.y;
		this.z = s.z;
		coordinates = s.coordinates;

	}
	
	public double squareD() {
		
		return Math.pow(x, 2)+Math.pow(y, 2)+ Math.pow(z, 2);
	}

}
