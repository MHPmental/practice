package practice.practice3;

import java.io.*;
import java.util.*;

public class Practice3 {
	public void practice3_1() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i=1;i<10;i++) {
			System.out.println(a+" * "+i+" = "+a*i);
		}
	}
	public void practice3_2() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		for(int i=0;i<a;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(x+y);
		}
	}
	public void practice3_3() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int result=0;
		for(int i=1;i<=a;i++) {
			result+=i;
		}
		System.out.println(result);
	}
	public void practice3_4() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		line = br.readLine();
		int a = Integer.parseInt(line);
		for(int i=0;i<a;i++) {
			line = br.readLine();
			int x = Integer.parseInt(line.split(" ")[0])+Integer.parseInt(line.split(" ")[1]);
			
			bw.write(Integer.toString(x));
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public void practice3_5() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		for(int i=1;i<=a;i++) {
			System.out.println(i);
		}
	}
	public void practice3_6() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		for(int i=a;i>0;i--) {
			System.out.println(i);
		}
	}
	public void practice3_7() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		for(int i=1;i<=a;i++) {
			int x = sc.nextInt()+sc.nextInt();
			System.out.println("Case #"+i+": "+x);
		}
	}
	public void practice3_8() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		for(int i=1;i<=a;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = x+y;			
			System.out.println("Case #"+i+": "+x+" + "+y+" = "+z);
		}
	}
	public void practice3_9() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		String star = "";
		for(int i=1;i<=a;i++) {
			star = star+"*";
			System.out.println(star);
		}
	}
	public void practice3_10() {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		String star = "";
		for(int i=0;i<a;i++) {
			star = star+" ";
		}
		for(int i=a;i>0;i--) {
			star = star.substring(0,i-1)+"*"+star.substring(i);
			System.out.println(star);
			
		}
	}
	public void practice3_11() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		String result = "";
		line = br.readLine();
		int a = Integer.parseInt(line.split(" ")[0]);
		int b = Integer.parseInt(line.split(" ")[1]);
		line = br.readLine();
		String[] c = line.split(" ");
		for(int i=0;i<a;i++) {
			int d = Integer.parseInt(c[i]);
			if(d<b) {
				if(result.equals("")) {
					result=result+d;
				}else {
					result=result+" "+d;
				}
				
			}
		}
		System.out.println(result);
	}
	public void practice3_11_2()  {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int a= sc.nextInt();
		int b = sc.nextInt();
		for(int i=0;i<a;i++) {
			int d =  sc.nextInt();
			if(d<b) {
				if(result.equals("")) {
					result=result+d;
				}else {
					result=result+" "+d;
				}
				
			}
		}
		System.out.println(result);
	}
	public void practice3_11_3() throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
 
		StringBuilder sb = new StringBuilder();
 
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
 
			if (value < X)
				sb.append(value).append(' ');
		}
		System.out.println(sb);
	}
}
