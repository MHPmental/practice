package practice;

public class Test {
	public long sum(int[] a) {
		long sumNum = 0;
		for(int i =0;i<a.length;i++) {
			sumNum += a[i];
		}
		return sumNum;
	}
}
