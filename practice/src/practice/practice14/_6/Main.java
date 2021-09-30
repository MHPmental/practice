package practice.practice14._6;

import java.io.*;
import java.util.*;

public class Main {
	//배열
	public static int[][] arr= new int[9][9];;
		
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//스도쿠하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//기본 9x9배열 지정
		
		StringTokenizer st;
		//넣어준값 확인
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sdoku(0,0);
		
		
		
	}	
	//백트랙킹할 함수
	public static void sdoku(int a,int b) {
		//끝까지 오면 다음줄
		if (b == 9) {
			sdoku(a+1, 0);
			return;
		}
		
		//끝까지 가면 출력하고 종료
		if (a==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append('\n');
			}
			System.out.println(sb);
			
			System.exit(0);
		}
		
		//값이 0이라면 수를 찾아서 넣는다
		if(arr[a][b]== 0) {
			for(int i=1;i<=9;i++) {
				if(possible(a,b,i)) {
					arr[a][b] = i;
					sdoku(a, b+1);
				}
			}
			arr[a][b]=0;
			return;
		}
		sdoku(a,b+1);
		
	}
	//들어온 수가 맞는지 확인하는 함수
	public static boolean possible(int row, int col, int a) {
		//같은행에 값이 존재하면 false
		for(int i=0;i<9;i++) {
			if(arr[row][i] == a) {
				return false;
			}
		}
		//같은열에 값이 존재하면 true
		for(int i=0; i<9; i++) {
			if(arr[i][col] == a) {
				return false;
			}
		}
		//3*3에서 같은값이 있는지
		int rowLocation = (row/3)*3;
		int colLocation = (col/3)*3;
		for(int i=rowLocation;i<rowLocation+3;i++) {
			for(int j=colLocation;j<colLocation+3;j++) {
				if(arr[i][j]==a) {
					return false;
				}
			}
		}
		return true;
	}
	
}