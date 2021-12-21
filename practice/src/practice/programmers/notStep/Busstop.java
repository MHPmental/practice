package practice.programmers.notStep;

public class Busstop {
	
	//버스정류장 n개가 주어지고 특정 정류장에서 갈수 있는지 없는지를 구하는 문제
	
	//입력 : n*n의 배열이 주어지고 들어있는 값은 특정 정류장에서 다른 정류장 까지 갈수있으면 1 없으면 0이 들어있는 배열이 주어짐
	
	//출력 : 주어진 배열을 통해 어찌어찌해서 다음 정류장에 갈수있으면 1 없으면 0의 값을 가지게 되는데 이 값을 가지는 n*n의 배열을 출력하면된다
	
	//결과값을 저장해줄 배열
	int[][] answer;
	//정류장의 갯수를 저장해줄 변수
	int N;
	//갈수있는 정류장을 확인할것
	int[][] signed;
	
	int[][] solution(int n, int[][] signs){
		//결과를 저장해줄 n*n배열 선언
        answer = new int[n][n];
        //정류장의 갯수 N선언
        N = n;
        //정류장 선언
        signed = signs;
        //0~n-1까지 dfs 실행
        for(int i=0;i<N;i++)
        	dfs(i,i);
        return answer;
    }
	
    // 경로만 찾으면 되므로 dfs를 이용.
    private void dfs(int from,int next) {
  
        for(int i=0;i<N;i++) {
        	//갈수 있는 장소인지 판단을 한다
            if(signed[next][i]==0) continue;
            //이미 갔던 곳이라면 구할 필요가 없다.
            if(answer[from][i]!=0) continue;
            answer[from][i] = 1;
            dfs(from,i);
        }
    }
}
