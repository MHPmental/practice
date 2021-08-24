package practice;

import java.io.*;
import java.util.StringTokenizer;

public class Practice7 {
	public void practice7_1() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int b = a.charAt(0);
		System.out.println(b);
	}
	public void practice7_2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		int sum = 0;
		for(int i=0;i<a;i++) {
			sum+=Character.getNumericValue(b.charAt(i));
		}
		System.out.println(sum);
	}
	public void practice7_3() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int[] result = new int[26];
		for(int i=0;i<result.length;i++) {
			result[i] = -1;
		}
		//97 = 'a'
		for(int i=0;i<a.length();i++) {
			int b = a.charAt(i);
			if(result[b-97]==-1) {
				result[b-97] = i;
			}
		}
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		
	}
	public void practice7_4() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCnt = Integer.parseInt(br.readLine());
		for(int i=0;i<testCnt;i++){
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			String y = st.nextToken();
			for(int j=0;j<y.length();j++) {
				for(int h=0;h<x;h++) {
					System.out.print(y.charAt(j));
				}
			}
			System.out.println();
			
		}
	}
	public void practice7_5() throws IOException{
		//단어를 받아서 가장 많이 사용된 알파벳이 무엇인가
		//1-1 입력받을 버퍼 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1-2. 사용된 문자수를 저장할 int 배열선언 및 초기화
		int[] storedCnt = new int[26];
		for(int i=0; i<storedCnt.length;i++) {
			storedCnt[i] = 0;
		}
		//2. 문자를 입력받는다.
		//3. 대소문자 구별이 없으므로 toLowwercase 사용
		String str = br.readLine().toLowerCase();
		//4. 문자열 길이만큼 돌리면서 배열에 저장을한다.
		for(int i=0;i<str.length();i++) {
			int a = str.charAt(i);
			storedCnt[a-97]++;
		}
		//5. 배열에서의 최대값을 구한다.
		int max = 0;
		int max2 = -1;
		for(int i=0;i<storedCnt.length;i++) {
			if(max<storedCnt[i]) {
				max = storedCnt[i];
				max2 = i;
			}
		}
		int maxCnt = 0;
		for(int i=0;i<storedCnt.length;i++) {
			if(max==storedCnt[i]) {
				maxCnt++;
			}
		}
		if(maxCnt>1) {
			System.out.println("?");
		}else {
			char asdf = (char)(max2+97);
			System.out.println(Character.toUpperCase(asdf));
		}
	}
	public void practice7_6() throws IOException{
		//문자열에서 문자가 몇개인가.
		//1. 입력받을 버퍼 및 스트링 토큰 선언하고 문자를 자른다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//2. st next가 없을때까지 돌리고 숫자늘리기
		int cnt=0;
		while(st.hasMoreTokens()) {
			cnt++;
			st.nextToken();
		}
		System.out.println(cnt);
	}
	public void practice7_7() throws IOException{
		//두 숫자를 받아서 뒤집은 다음 최댓값을 구한다.
		//1. 입력받을 버퍼 및 스트링 토큰 선언하고 문자를 자른다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = reverseNum(st.nextToken());
		int b = reverseNum(st.nextToken());
		if(a>b) {
			System.out.println(a);
		}else {
			System.out.println(b);
		}
		
		
	}
	public int reverseNum(String a) {
		int result=0;
		StringBuffer sb = new StringBuffer();
		for(int i=a.length()-1;i>=0;i--) {
			sb.append(a.charAt(i));
		}
		result = Integer.parseInt(sb.toString());
		return result;
	}
	public void practice7_8() throws IOException{
		//문자를 입력 받아서 다이얼 돌리는데 걸리는 시간 구하기
		//1. 입력받을 버퍼 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. 입력 받고 받은 문자 대문자
		String a = br.readLine().toLowerCase();
		char[] chs = a.toCharArray();
		int result=0;
		for(int i=0;i<chs.length;i++) {
			result += charNum(chs[i]);
		}
		System.out.println(result);
		
	}
	public static int charNum(char a) {
		if(a=='a'||a=='b'||a=='c') {
			return 3;
		}else if(a=='d'||a=='e'||a=='f') {
			return 4;
		}else if(a=='g'||a=='h'||a=='i') {
			return 5;
		}else if(a=='j'||a=='k'||a=='l') {
			return 6;
		}else if(a=='m'||a=='n'||a=='o') {
			return 7;
		}else if(a=='p'||a=='q'||a=='r'||a=='s') {
			return 8;
		}else if(a=='t'||a=='u'||a=='v') {
			return 9;
		}else {
			return 10;
		}
	}
	
	public void practice7_9() throws IOException{
		//문자열을 입력받아서 크로아티아 문자갯수 구하기
		//앞에서부터 천천히 나가면서 경우의수를 하면서 숫자 늘리기해야지
		//끝에 올경우를 생각해야됨..
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			if(i<str.length()-1&&str.charAt(i)=='c'&&str.charAt(i+1)=='=') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='c'&&str.charAt(i+1)=='-') {
				i++;
			}else if(i<str.length()-2&&str.charAt(i)=='d'&&str.charAt(i+1)=='z'&&str.charAt(i+2)=='=') {
				i++;
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='d'&&str.charAt(i+1)=='-') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='l'&&str.charAt(i+1)=='j') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='n'&&str.charAt(i+1)=='j') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='s'&&str.charAt(i+1)=='=') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='z'&&str.charAt(i+1)=='=') {
				i++;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	public void practice7_10() throws IOException{
		//그룹단어 체크
		//aavvdd 는 avd가 연속으로 나오므로 그룹단어 aavvdda는 avda이므로 a가 2번 나와서 그룹단어가 아니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//들어올 문자 수
		int trycnt = Integer.parseInt(br.readLine());
		for(int i=0; i<trycnt;i++) {
			String str = br.readLine();
			StringBuffer sb = new StringBuffer();
			//1. 일단 문자열 연속되는걸 없애는걸 목표로 해서  aavvdda > avda
			for(int j=0; j<str.length();j++) {
				if(j==0) {
					sb.append(str.charAt(j));
				}
				else if(j>0&&str.charAt(j)==str.charAt(j-1)){
					
				}
				else {
					sb.append(str.charAt(j));
				}
			}
			//2. avda에서 2번 연속으로 나오는 친구가 있으면 문제있는친구
			for(int j=0;j<sb.length();j++) {
				
			}
		}
		
		
		
		
		
		
	}
	
}
