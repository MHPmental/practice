package practice.programmers.step3;

public class BaseStation {
	//4g 기지국이 설치되어있고 5g로 바꾸려는데 통신 범위가 좁아서 추가로 기지국을 설치해야한다. 이때 최소값으로 기지국을 설치하는 방법

	//입력 : 아파트의 갯수 n, 현재 설치되어있는 기지국위치 배열 stations, 전파 도달 거리 w

	//출력 : 최소한으로 설치되는 기지국의 개수

	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		//기지국을 설치할 현재 위치
		int crrIdx = 1;
		//설치된 기지국 인덱스
		int idx = 0;

		//위치를 넘어가기전에
		while(crrIdx <= n) {
			//다음으로 설치된 기지국이 배열 범위를 넘어가지 않으면서,
			//다음 기지국의 범위 안에 현재 위치가 있는 경우
			if (idx < stations.length && crrIdx >= stations[idx]-w) {
				//설치된 기지국의 범위보다 큰 위치로 이동
				crrIdx = stations[idx]+w+1;
				//다음 설치된 기지국 위치로 넘어간다
				idx++;
			} else {
				//설치된 기지국 범위 밖일 때,
				//설치를 해줘야 하므로 범위*2+1의 범위에 설치가 되었으므로 위치를 이동해준다.
				crrIdx += 2*w+1;
				answer++;
			}
		}
		return answer;
	}
}
