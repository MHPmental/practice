package practice.programmers.step4;

public class SnackSon {
	//1~n까지의 바구니를 일렬로 놓고 파는데, 
	//두 아들에게 과자를 사줄거다 근데 숫자는 같아야하고 연결된 바구니만을 살수있을 경우 아들에게 최대한 많은 과자가 갈수있을 방법

	//입력 : 과자가 담겨있는 갯수를 담은 인트배열

	//출력 : 아들들이 최대한으로 먹을수 있는 과자의 갯수



	public int solution(int[] cookie) {
		//정방향에서 값을 더해나갈 배열
		int[] forward = new int[cookie.length];
		//역방향에서 값을 더해나갈 배열
		int[] backward = new int[cookie.length];
		int answer = 0;
		int l = cookie.length;
		//바구니 길이가 1이면 아들들에게 먹일 수 없으므로 0을 return
		if(cookie.length == 1)
			return answer;
		//배열에값을 넣어준다.
		forward[0] = cookie[0];
		backward[l-1] = cookie[l-1];
		for(int i = 1; i < cookie.length; i++){
			forward[i] = forward[i-1] + cookie[i];
			backward[l-1-i] = backward[l-1 - i+1] + cookie[l-1-i];
		}
		//포인터
		int toLeft;
		int toRight;
		//backward forward와 비교할값
		int left; 
		int right;

		for(int i = 0; i < l-1; i++){
			toLeft = i;
			toRight = i+1;
			left = backward[i+1];
			right = forward[i];
			//right포인터가 범위를 넘어가지 않게 하고 결과값보다 클때까지 포인터 이동
			while(toRight < l && forward[toRight]-right < answer)
				toRight++;
			//left포인터가 범위를 넘어가지 않게 하고 결과값보다 커질때까지 포인터 이동
			while(toLeft > -1 && backward[toLeft]-left < answer)
				toLeft--;
			//포인터가 결과값안에 제대로 있을경우
			while(toLeft > -1 && toRight < l){
				//비교할 값과 현재 포인터에 있는 값을 연산
				int leftValue = backward[toLeft]-left;
				int rightValue = forward[toRight]-right;
				//연산한 값이 같으면 조건을 충족하므로 결과 값을 바꿔주고 포인터도 이동 
				if(leftValue == rightValue){
					answer = leftValue;
					toRight++;
					toLeft--;
				}
				//오른쪽 값이 더 크다면 왼쪽 포인트를 이동해야한다
				else if(leftValue < rightValue)
					toLeft--;
				//왼쪽값이 더 크다면 오른쪽 포인트 이동
				else
					toRight++;
			}
		}
		
		return answer;
	}
}
