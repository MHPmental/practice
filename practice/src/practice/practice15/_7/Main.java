package practice.practice15._7;

import java.io.*;
import java.util.*;

public class Main {

	static int[] stairs;
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		//계단 오르기
		//입력 > 계단 개수는 300이하의 자연수이고 점수는 10000이하의 자연수
		//계단은 연속으로 3개를 밟을수 없고 3칸뒤에있는것을 밟을수 없다.
		//전 계단을 밟았나 안밟았나를 판단해야하고
		//전에거를 안밟았으면 무조건 밟아야되고
		//전에거를 밟았으면 전전 거를 보고 밟았으면 못밟는거고 
		//110
		//1011
		//1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		stairs = new int[n+1];
		arr = new int[n+1];
		//1번째 계단은 무조건 밟아야함
		for(int i=1;i<=n;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
			arr[i]=-1;
		}
		//1개는 밟았으니 1부터 시작
		arr[0] = stairs[0];
		arr[1] = stairs[1];
		
		//n이 1이 입력이 되면 바로 넘어가야된다.
		if(n>=2) {
			arr[2] = stairs[1]+stairs[2];
		}
		
		System.out.println(sumScore2(n));
	
	}
	//n부터 시작해서 아래로 내려가는 방식
	public static int sumScore1(int n) {
		
		if(arr[n]==-1) {
			arr[n] = Math.max(sumScore1(n-2), sumScore1(n-3)+stairs[n-1])+stairs[n];
		}
		
		return arr[n];
	}
	//1부터 시작해서 올라가는 방식
	public static int sumScore2(int n) {
		for(int i=3;i<=n;i++) {
			//비교할 가짓수는 2가지 전에거를 안밟은 경우 > arr[i-2] 밟았을 경우에는 그전에거를 안밟아야 이번걸 밟을수있다. > arr[i-3]+stairs[i-1]
			arr[i] = Math.max(arr[i-2], arr[i-3]+stairs[i-1])+stairs[i];
		}
		return arr[n];
	}
	
	
}