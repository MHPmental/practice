package practice.programmers.step4;

public class Arithmetic {
	//문제 : 사칙연산은 계산 순서에 따라서 결과값이 달라진다. 그중에서 최댓값을 구하는 문제
	
	//입력 : 문자열로 숫자와 사칙연산이 들어온다.
	
	//출력 : 이것을 이용하여 구했을때에 최대로 나올수있는 결과값
	
	//+가 나올 경우에는 A + B 에서 A와 B 둘다 최댓값이 되어야하고 
	//-가 나올 경우에는 A - B 에서 A는 최댓값이 나와야하지만 B는 최솟값이 나와야 최댓값을 구할 수 있다.
	
	//그러므로 최대값과 최소값을을 저장해둘 배열을 만들자
	int dp[][][] = new int[2][101][101];
	
	char ari[];
	int nums[];
	
	
	//최댓값 최솟값을 위해 넣어줄 값
	int tmp = Integer.MAX_VALUE;
	int tmp2 = Integer.MIN_VALUE;
	
	
	public int solution(String arr[]) {
        int answer = -1;
        //사칙연산의 갯수
        int n = arr.length/2;
        //숫자와 변수를 담을 배열 선언
        nums = new int[n+1];
        ari = new char[n];
        //dp 초기화 [0]에는 최대값 [1]에는 최소값이 들어갈 예정이기 때문에 초기화를 해준다
        for(int i=0;i<n+1;i++) {
        	for(int j=0;j<n+1;j++) {
        		dp[0][i][j] = tmp2;
        		dp[1][i][j] = tmp;
        	}
        }
        
        //arr의 짝수에는 숫자 홀수에는 연산자가 들어있다.
        for(int i=0;i<arr.length;i++) {
        	//짝수일때에는 숫자
        	if(i%2==0) {
        		nums[i/2] = Integer.parseInt(arr[i]);
        	}
        	//홀수일때에는 연산자
        	else {
        		ari[i/2] = arr[i].charAt(0);
        	}
        }
        
        answer = pro2(arr);
        
        
        
        return answer;
    }
	public int pro(int n, int start, int end) {
		//범위가 자기 한정일 경우
		if(start == end) {
			return dp[n][start][end] = nums[start];
		}
		//이미 한번 했던 것이라면
		//최대값을 구할때에는 tmp2가 있는지 확인 tmp2가 들어있지 않으면 이미 해결
		if(n == 0 && dp[n][start][end]!=tmp2) {
			return dp[n][start][end];
		}
		//최소값을 구할때에는 tmp가 있는지 확인 tmp가 들어있지 않으면 이미 해결
		if(n == 1 && dp[n][start][end]!=tmp) {
			return dp[n][start][end];
		}
		//여기까지 진행했는데 별일이 없었다면
		int result = (n==0)? tmp2:tmp;
		dp[n][start][end] = 0;
		
		//최대를 구해야하는경우
		if(n==0) {
			//중간값을 바꾸면서 진행
			for(int mid = start ; mid < end ; mid++) {
				//연산자가 -일 경우에는 최대 - 최소
				if(ari[mid]=='-') {
					result = Math.max(result,pro(0,start,mid)-pro(1,mid+1,end));
				}
				//연산자가 +일 경우에는 최대 + 최대
				else {
					result = Math.max(result,pro(0,start,mid)+pro(0,mid+1,end));
				}
			}
		}
		//최소를 구해야된느경우
		else {
			for(int mid = start ; mid < end ; mid++) {
				//연산자가 -일 경우에는 최대 - 최대
				if(ari[mid]=='-') {
					result = Math.min(result,pro(1,start,mid)-pro(0,mid+1,end));
				}
				//연산자가 +일 경우에는 최소 + 최소
				else {
					result = Math.min(result,pro(1,start,mid)+pro(1,mid+1,end));
				}
			}
		}
		return dp[n][start][end] = result;
	}
	public int pro2(String arr[]){
		int num = arr.length/2 +1;
		for(int i=0;i<num;i++) {
        	for(int j=0;j<num;j++) {
        		dp[0][i][j] = tmp2;
        		dp[1][i][j] = tmp;
        	}
        }
		for(int i = 0;i<num;i++) {
			dp[0][i][i] = Integer.parseInt(arr[i*2]);
			dp[1][i][i] = Integer.parseInt(arr[i*2]);
		}
		
		for(int calc = 1; calc<num;calc++) {
			for(int i=0;i<num-calc;i++) {
				int j = calc +i;
				for(int k=i;k<j;k++) {
					if(arr[k*2+1].charAt(0)=='-') {
						dp[0][i][j] = Math.max(dp[0][i][k]-dp[1][k+1][j],dp[0][i][j]);
						dp[1][i][j] = Math.min(dp[1][i][k]-dp[0][k+1][j],dp[1][i][j]);
					}else {
						dp[0][i][j] = Math.max(dp[0][i][k]+dp[0][k+1][j],dp[0][i][j]);
						dp[1][i][j] = Math.min(dp[1][i][k]+dp[1][k+1][j],dp[1][i][j]);
					}
				}
			}
		}
		return dp[0][0][num-1];
	}
	
}
	

