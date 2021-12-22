package practice.programmers.step2;

import java.util.*;

public class TwinDel {
	//2개씩 붙어있는 문자를 제거하면서 문자열이 전부 제거가 된다면 1 아니면 0

	//입력 : 문자열 s

	//출력 : 문자열 제거여부 integer

	public int solution(String s) {
		//비교할 문자열을 순서대로 넣고 순서대로 빼야 하므로 stack을 사용할것
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++){
			//stack이 비어있다면 일단 stack을 채워준다.
			if(stack.isEmpty()){
				stack.push(String.valueOf(s.charAt(i)));
			}
			//stack이 존재하는 경우에는 비교를 해야한다.
			else{
				//비교할 값을 stack에서 빼온다
				String comp = stack.peek();
				//현재 위치의 값을 가져온다
				String crr = String.valueOf(s.charAt(i));
				//비교해서 같지 않으면 현재 값을 다음 값과 비교를 위해 stack에 넣어준다 
				if(!comp.equals(crr)){
					stack.push(crr);
				}
				//비교해서 값이 같으면 stack에서 값을 빼준다.
				else{
					stack.pop();
				}
			}
		}
		int answer = 0;
		//stack이 비어있다면 모든 문자열이 비교되어 사라진 것이므로 결과값을 1로 바꾼다
		if(stack.size() == 0){
			answer = 1;
		}
		return answer;
	}
}
