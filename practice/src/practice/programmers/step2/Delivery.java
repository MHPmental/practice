package practice.programmers.step2;

import java.util.*;

class Delivery {
	//문제 : N개의 도시와 양방향으로 통행이 가능한 도로가 주어지는데 이때에 1번 도시에서 K시간 내로 배달이 가능한 도시들의 갯수를 구하는 문제.
	
	//입력 : 마을의 갯수 N {시작,끝,거리}의 배열값과 거리 K가 주어진다.
	//출력 : 1번도시에서 배달이 가능한 도시의 갯수를 저장한 integer
	
	//연결을 해줄 edge를 생성
    class Edge implements Comparable<Edge> {
        int to, weight;
        
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        //거리비교
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    //우선순위를 주기위해 pq사용
    PriorityQueue<Edge> pq;
    //마을간의 엣지 정보를 저장할 리스트 선언
    ArrayList<ArrayList<Edge>> list;
    //거리 저장할 배열
    private int[] dist;
    
    public int solution(int N, int[][] road, int K) {
    	//결과 값을 저장할 int변수
        int answer = 0;
        //리스트와 배열 선언
        pq = new PriorityQueue<>();
        list = new ArrayList<>();
        dist = new int[N + 1];
        //배열 안의 값을 최댓값으로 초기화 해줘야한다.
        Arrays.fill(dist, Integer.MAX_VALUE);
        //0번 마을은 존재하지 않으므로 빈값 1번부터 N번 까지 빈값으로 설정
        for(int i = 0 ; i <= N ; ++i) list.add(new ArrayList<>());
        //1번부터 N번 마을까지 주어진 정보를 입력한다.
        for(int i = 0 ; i < road.length ; ++i){
        	//출발마을
            int from = road[i][0];
            //도착마을
            int to = road[i][1];
            //거리
            int weight = road[i][2];
            //양 방향이므로 주어진 정보를 이용하여 시작에서끝 끝에서 시작 edge를 리스트에 추가해준다.
            //from마을의 ArrayList<Edge>값을 가져와서 Edge를 추가한다. 
            list.get(from).add(new Edge(to, weight));
            //from마을의 ArrayList<Edge>값을 가져와서 Edge를 추가한다.
            list.get(to).add(new Edge(from, weight));
        }
        //1번에서 시작을 할 예정이니 거리를 0으로 초기화 해준다.
        dist[1] = 0;
        //위 정보를 priority queue에 넣어준다.
        pq.offer(new Edge(1, 0));
        //다익스트라를 적용하여 최소거리 리스트를 받아올 예정
        dijkstra();
        //저장된 거리값을 이용해 K보다 작거나 같은 값들을 다 더해준다.
        for(int distance : dist){
            if(distance <= K) answer++;
        }
        
        return answer;
    }
    
    private void dijkstra() {
    	//priority queue가 빌때까지 반복
        while(!pq.isEmpty()){
        	//priority에서 edge를 빼온다.
            Edge e = pq.poll();
            // edge(1,0)
            //e에서 갈수있는 모든 마을에 대해서 실행하는데 원래 가지고있던 거리와 새로 구한 거리를 비교하여 최솟값을 저장해준다.
            //1번 마을에서 갈수있는 마을들의 edge정보를 가지고 온다
            for(Edge e2 : list.get(e.to)){
            	//1번 마을에서 갈수있는 엣지들중에 하나를 골랐을때 이 마을이 가지고 있는 거리정보가 현재 마을에서의 거리정보 +edge의 거리정보를 대한것보다 크게되면 거리정보를 갱신하고 pq에 도착한 마을값을 넣어준다.
                if(dist[e2.to] > dist[e.to] + e2.weight){
                    dist[e2.to] = dist[e.to] + e2.weight;
                    pq.offer(e2);
                }
            }
        }
    }
}