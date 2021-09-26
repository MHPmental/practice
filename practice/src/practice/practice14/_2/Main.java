package practice.practice14._2;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//글자를 입력받아서 길이순 정렬
		//입력받아서 나이순 정렬 후 가입순 정렬
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		
		int[] arr2 ;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		for(int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		//복사
		arr2 = arr.clone();
		//순서 정하기
		Arrays.sort(arr2);
		
		//포함되어있는거
		Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int a : arr2)
            if (!map.containsKey(a))
                map.put(a, idx++);

		
		StringBuilder sb = new StringBuilder();
		
		for (int a : arr)
            sb.append(map.get(a)).append(' ');
		
		System.out.println(sb);
	}	
}