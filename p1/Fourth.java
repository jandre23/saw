package p1;

public class Fourth extends Dimension {
	
	

	int x;
	int y;
	int z;
	int k;

	public Fourth() {
		coordinates = null;
		x = y = z = k= 0;
	}

	public Fourth(int x, int y, int z, int k) {
		coordinates = Integer.toString(x) + "," + Integer.toString(y) + "," + Integer.toString(z)+","+Integer.toString(k);
		this.x = x;
		this.y = y;
		this.z = z;
		this.k=k;
	}

	public int[] moveY(int r) {
		int[] arr = new int[4];
		arr[0] = x;
		arr[1] = y + r;
		arr[2] = z;
		arr[3]= k;

		return arr;

	}

	public int[] moveX(int r) {

		int[] arr = new int[4];
		arr[0] = x + r;
		arr[1] = y;
		arr[2] = z;
		arr[3]=k;
		return arr;

	}

	public int[] moveZ(int r) {

		int[] arr = new int[4];
		arr[0] = x;
		arr[1] = y;
		arr[2] = z + r;
		arr[3]=k;
		return arr;

	}
	
	public int[] moveK(int r) {

		int[] arr = new int[4];
		arr[0] = x;
		arr[1] = y;
		arr[2] = z;
		arr[3]=k+r;
		return arr;

	}

	public void tran(Fourth s) {
		this.x = s.x;
		this.y = s.y;
		this.z = s.z;
		this.k=s.k;
		coordinates = s.coordinates;

	}
public double squareD() {
		
		return Math.pow(x, 2)+Math.pow(y, 2)+ Math.pow(z, 2)+ Math.pow(k, 2);
	}

}
