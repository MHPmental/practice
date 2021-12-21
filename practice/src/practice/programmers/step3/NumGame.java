package practice.programmers.step3;

import java.util.Arrays;

public class NumGame {
	//문제 N개의 배열 2개가 주어지고 1번은 순서가 정해져있는 상태에서 숫자 비교게임을 해서 2번이 최대한 이길수 있는 승점을 구하면된다.
	//이기는방법은 무조건 숫자가 커야한다.
	//입력 : integer 배열 2개
	
	//출력 : 승점
	
	//해결방법 : 최대한 승점을 많이 얻기위해서는 최소한의 숫자 비교로 이겨야 한다 예를 들면 2를 3으로 이길수있는데 4시강의 숫자로 이기면 손해
	
	public int solution(int[] A, int[] B) {
        int answer = 0;
        
        //작은수부터 천천히 비교를 하기위해 sorting을 해준다.
        Arrays.sort(A);
        Arrays.sort(B);

        //A팀의 팀원을 나타낼 idx
        int pointA = 0;
        //B팀의 팀원을 나타낼 idx
        int pointB = 0;
        int result = 0;
        //끝부분 설정을 해둔다
        int end = A.length;
        //A나 B둘중 하나라도 끝에 도달한다면 끝
        while(pointA < end && pointB < end){
            //B가 이겨서 승점을 가져오는 경우
        	if(A[pointA]<B[pointB]) {
        		//이기면 두 포인트 모두 증가하고 승점 추가
        		pointA++;
        		pointB++;
        		result++;
        	}
        	//B가 이길수 없는 경우
        	else {
        		//이경우에는 B만 증가시키면 된다.
        		pointB++;
        	}
        }

        return result;

    }
	
}
