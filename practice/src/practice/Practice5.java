package practice;

import java.io.*;
import java.util.StringTokenizer;

public class Practice5 {
	public void practice5_1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int min = 1000000;
		int max = -1000000;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<a;i++) {
			int curr = Integer.parseInt(st.nextToken());
			if(curr<min) {
				min = curr;
			}
			if(curr>max) {
				max = curr;
			}
		}
		System.out.println(min+" "+max);
		
	}
	public void practice5_2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int max = 0;
		int cnt = 0;
		int max_cnt=0;;
		while( (input= br.readLine()) != null) {
			int a = Integer.parseInt(input);
			cnt++;
			if(a>max) {
				max = a;
				max_cnt = cnt;
			}
		}
		System.out.println(max);
		System.out.println(max_cnt);
	}
	public void practice5_3() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		String sum = Integer.toString(a*b*c);
		int[] sumCnt = new int[10];
		
		for(int i=0;i<sum.length();i++) {
			int x = Character.getNumericValue(sum.charAt(i));
			sumCnt[x]++;
		}
		for(int i=0;i<10;i++) {
			System.out.println(sumCnt[i]);
		}
		
	}
	public void practice5_4() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] val = new int[10];
		int cnt = 10;
		for(int i=0;i<val.length;i++) {
			val[i] = Integer.parseInt(br.readLine())%42;
		}
		for(int i=0;i<val.length-1;i++) {
			for(int j=i+1;j<10;j++) {
				if(val[i]==val[j]) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
	public void practice5_5() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] val = new int[Integer.parseInt(br.readLine())];
		double sum=0;
		int max=0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<val.length;i++) {
			val[i] = Integer.parseInt(st.nextToken());
			if(max<val[i]) max = val[i];
		}
		for(int i=0;i<val.length;i++) {
			sum = sum + ((double)val[i]/max*100);
		}
		System.out.println(sum/val.length);
	}
	public void practice5_6() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(br.readLine());
		int[] result = new int[val];
		int O = 0;
		for(int i=0;i<val;i++) {
			O = 0;
			String asd = br.readLine();
			for(int j=0;j<asd.length();j++) {
				if(asd.charAt(j)=='O') {
					O++;
				}else {
					O=0;
				}
				result[i]=result[i]+O;
			}
		}
		for(int i=0;i<val;i++) {
			System.out.println(result[i]);
		}
	}
	public void practice5_7() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		for(int i=0;i<cnt;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] avg = new int[Integer.parseInt(st.nextToken())];
			int sum = 0;
			int avgCnt = 0;
			for(int j=0;j<avg.length;j++) {
				avg[j]=Integer.parseInt(st.nextToken());
				sum = sum + avg[j];
			}
			double avg1 = (double)sum/avg.length;
			for(int j=0;j<avg.length;j++) {
				if(avg[j]>avg1) {
					avgCnt++;
				}
				
			}
			System.out.println(String.format("%.3f", avgCnt/(double)avg.length*100)+"%");
		}
		
		
		
	}
}	
