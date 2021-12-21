package practice.programmers.notStep;

import java.util.*;

public class Shipyard {
	
	//문제 : 조선소에서 태풍으로 인한 작업 지연으로 수주한 선박들을 기한내에 완성하지 못할 것이라 예상 배상을 최소로 하는 방법을 찾아라
	//		조선소에서는 1시간동안 남은 일 중 하나를 골라 작업량 1만큼 처리가 가능하다 시간 N과 각일에대한 배열이 있을때 배상을 최소화해야한다.
	//		배상 비용은 남은 작업을 제곱해서 더한것들
	
	//입력 : 남은시간 N 과 남은 작업량이 담긴 배열이 주어진다.
	
	//출력 : 남은 작업이 더해져 나온값
	
	//가장 큰수부터 하나씩 빼주면 될거같음
	
	int solution(int no, int[] works){
	
        //한시간씩 줄여나가야한다
        //항상 최대값에서 1을 빼야 하므로 내림차순 정렬을 하는 priority queue를 선언해준다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //숫자 배열을 pq에 넣어준다
        for(int n : works){
            pq.offer(n);
        }
        
        //시간만큼 돌려준다
        for(int i=0; i<no; i++){
            //queue있을때 계속 돌려준다
            if(!pq.isEmpty()){
                //가장 큰 작업을 호출해 온다.
                int tmp = pq.poll();
                //작업이 0보다 크다면 작업이 남아있는 것으므로 작업을 1빼준뒤에 다시 pq에 넣어준다.
                if(0 < tmp){
                    pq.offer(tmp - 1);
                }
            }            
        }

        int result = 0;
        //이제 남은 작업을 다 가져와서
        while(!pq.isEmpty()){
            //작업량의 제곱을해서 더해줘야함
            result += Math.pow(pq.poll(), 2);
        }

        return result;

	}
	
}
