package practice.programmers.step5;

import java.util.*;

public class RectangleArea {
	//직사각형의 넓이 구하기
	//주어진 직사각형들의 넓이를 겹치는것을 제외하고 넓이를 구하면된다.
	
	//입력 : 직사각형의 왼쪽아래 오른쪽위의 좌표모음 배열
	
	//출력 : 직사각형의 넓이
	
	int S, cnt[];
	long seg[];
    List<Integer> y;
    		//(왼쪽아래 y좌표+1,오른쪽위y좌표,점이 왼쪽인지 오른쪽인지, 1,0,전체크기)?
	    void update(int l, int r, int k, int idx, int nl, int nr) {
	    	//범위 밖을 나가면 ㅈㅈ
	        if(l>nr || r<nl) return;
	        //
	        if(l<=nl && nr<=r) cnt[idx] += k;
	        else {
	        	//중간값
	            int mid = (nl+nr)/2;
	            update(l, r, k, idx*2, nl, mid);
	            update(l, r, k, idx*2+1, mid+1, nr);
	        }
	        if(cnt[idx] > 0) seg[idx] = y.get(nr)-y.get(nl-1);
	        else if(idx<S) seg[idx] = seg[idx*2] + seg[idx*2+1];
	        else seg[idx] = 0;
	    }
	    
	    
	    public long solution(int[][] rectangles) {
	    	//결과값을 넣어줄 변수
	        long answer = 0;
	        
	        List<int[]> list = new ArrayList<>();
	        Set<Integer> set = new TreeSet<Integer>();
	        Map<Integer, Integer> map = new HashMap<>(); 
	        
	        //x y좌표값을 준비한 set과 list에 넣어준다
	        for(int[] rec : rectangles) {
	        	//y좌표를 넣어줌
	            set.add(rec[1]);
	            set.add(rec[3]);
	            //int배열을 선언해서 왼쪽아래 y좌표 2개와 x좌표1개를 넣고 이게 왼쪽 아랜지 오른쪽위인지 구분
	            list.add(new int[] {rec[0], rec[1], rec[3], 1});
	            list.add(new int[] {rec[2], rec[1], rec[3], -1});
	        }
	        //x값을 기준으로 정렬을 한다.
	        Collections.sort(list, (a,b) -> a[0]-b[0]);
	        //리스트 선언
	        y = new ArrayList<>();
	        int idx = 0;
	        //y좌표를 set과 map에 넣어줌
	        for(int s : set) {
	            map.put(s, idx++);
	            y.add(s);
	        }
	        //1부터 점의 갯수만큼 2를 곱해가면서?
	        //S는 idx보다 작거나 같은 2제곱수
	        for(S=1; S<=idx; S*=2);
	        //그보다 2의제곱수? 전체 크기를 위한 수
	        seg = new long[S*2];
	        cnt = new int[S*2];
	        
	        //현재 진행중인 x좌표
	        int x = 0;
	        //리스트에서 하나씩 빼온다.
	        for(int cur[] : list) {
	            answer += seg[1]*(cur[0]-x);
	            //(왼쪽아래 y좌표+1,오른쪽위y좌표,점이 왼쪽인지 오른쪽인지, 1,0,전체크기)?
	            update(map.get(cur[1])+1, map.get(cur[2]), cur[3], 1, 0, S-1);
	            x = cur[0];
	        }
	        return answer;
	    }
	
	
}
/*

def solution4(rects):
    x_events = set()
    for l,t,r,b in rects:
        x_events.add(l)
        x_events.add(r)
    x_events = sorted(x_events)

    total_area = 0
    subarea_left = 0
    for subarea_right in x_events:
        inter_checker = lambda rect: rect[0]<=subarea_left and subarea_right<=rect[2]
        y_events = []
        for l,t,r,b in filter(inter_checker, rects):
            y_events.extend([(t, 1), (b, -1)])
        y_events.sort()

        start_y, overlap_cnt = 0, 0
        for p, e in y_events:
            if overlap_cnt == 0:
                start_y = p

            overlap_cnt += e

            if overlap_cnt == 0:
                total_area += (subarea_right – subarea_left) * (p – start_y)

        subarea_left = subarea_right

    return total_area

*/