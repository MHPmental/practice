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
}	
