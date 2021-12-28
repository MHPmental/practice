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
	    /*
	    
	    public long solution(int[][] rectangles) {
	    	//결과값을 넣어줄 변수
	        long answer = 0;
	        //리스트
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
	    */
	    
	    public long sol1(int[][] rectangles){
	        int[][] all = new int[100][100];
	        int answer=0;
	        for(int[] rec : rectangles){
	            for(int i = rec[0]; i < rec[2];i++){
	                for(int j = rec[1];j< rec[3];j++){
	                    if(all[i][j]==0){
	                        all[i][j] = 1;
	                    }
	                }
	            }
	        }
	        for(int i = 0; i < 100;i++){
	            for(int j = 0; j <100;j++){
	                if(all[i][j] == 1){
	                    answer+=1;
	                }
	            }
	        }
	        return answer;

	    }
	    
	    
	    
	    
	    //겹침의 상태를 저장해줄것
	    static class Cover {
	    	//시작점
	        private int start;
	        //끝나는부분
	        private int end;
	        //완전히 겹쳐있는거
	        private int thick;
	        //겹쳐있는 왼쪽의 정보
	        private Cover left;
	        //겹쳐있는 오른쪽의 정보;
	        private Cover right;
	        //부분 겹침을 계산해주는 int
	        private int childrenCover;
	    }

	    public long solution(int[][] rectangles) {
	        long answer = 0;

	        //처음에 시작할 직사각형의 정보를 저장
	        Cover root = new Cover();
	        //최대로 나올수있는 수
	        root.start = 1000000000;
	        //최소 수
	        root.end = 0;
	        //직사각형 정보를 저장하기 위해서 배열을 만들고 점이 2개씩 있으니 *2
	        int [][] lines = new int [rectangles.length * 2][];
	        
	        int idx = 0;
	        for (int[] r : rectangles) {
	        	// 1이 나오는 것은 이 직사각형이 등장을 했다는 것을 의미한다
	            lines[idx++] = new int [] {r[0], r[2], r[1], 1};    
	            // -1은 반대로 삭제해야된다는 것을 의미
	            lines[idx++] = new int [] {r[0], r[2], r[3], -1};    
	            //첫값을 지정해주기위해
	            root.start = Math.min(root.start, r[0]);
	            root.end = Math.max(root.end, r[2]);
	        }
	        
	        // y 기준 정렬
	        Arrays.sort(lines, Comparator.comparingInt(a -> a[2]));

	        int i = 0;
	        long lastCover = 0;
	        int lastY = 0;
	        //점이 끝날때 까지 진행
	        while (i < lines.length) {
	        	//저장되어있는 y값을 가져온다
	            int y = lines[i][2];
	            //가져온 y값을 이용해서 
	            while (i < lines.length && y == lines[i][2]) {
	            	//추가해야되는 사각형
	                if (lines[i][3] == 1) {
	                    add(root, lines[i]);
	                } 
	                //제거해야되는 사각형
	                else {
	                    remove(root, lines[i]);
	                }
	                i++;
	            }

	            long cover = computeCover(root);
	            long thickness = y - lastY;
	            answer += lastCover * thickness;

	            lastCover = cover;
	            lastY = y;
	        }

	        return answer;
	    }
	    
	    //직사각형의 추가를 위한 함수
	    private void add(Cover cover, int[] line) {
	    	// 서로 공간이 겹치는 경우
	        if (cover != null && cover.start < line[1] && cover.end > line[0]) {
	        	// 완전히 내부일경우
	            if (cover.start >= line[0] && cover.end <= line[1]) {
	                cover.thick++;
	             // 일부 겹칠 경우 자식에서 확인
	            } else {
	                //왼쪽에서 겹치는 거 더해줌
	                add(left(cover), line);
	                //오른쪽에서 겹치는거 더해줌
	                add(right(cover), line);
	                //합쳐서 부분적으로 겹치는 부분을 저장
	                cover.childrenCover = computeCover(cover.left) + computeCover(cover.right);
	            }
	        }
	    }
	    
	    private Cover left(Cover cover) {
	        if (cover.left == null) {
	            int start = cover.start;
	            int end = (cover.start + cover.end) >> 1;
	            if (start < end) {
	                cover.left = new Cover();
	                cover.left.start = start;
	                cover.left.end = end;
	            }
	        }
	        return cover.left;
	    }

	    private Cover right(Cover cover) {
	        if (cover.right == null) {
	            int start = (cover.start + cover.end) >> 1;
	            int end = cover.end;
	            if (start < end) {
	                cover.right = new Cover();
	                cover.right.start = start;
	                cover.right.end = end;
	            }
	        }
	        return cover.right;
	    }
	    //제거를 위함
	    private boolean remove(Cover cover, int[] line) {
	    	// 서로 공간이 겹치는 경우
	        if (cover != null && cover.start < line[1] && cover.end > line[0]) {
	        	// 완전히 내부일경우
	            if (cover.start >= line[0] && cover.end <= line[1]) {
	                cover.thick--;
	                // 자식이 없을 경우 지울 수 있다.
	                if (cover.thick == 0 && cover.left == null && cover.right == null) {
	                    return true;
	                }
	            } else {
	                // 일부 겹칠 경우 자식에서 확인
	                if (remove(left(cover), line)) {
	                    cover.left = null;
	                }
	                if (remove(right(cover), line)) {
	                    cover.right = null;
	                }
	                cover.childrenCover = computeCover(cover.left) + computeCover(cover.right);
	            }
	        }
	        return false;
	    }

	    //자식을 계산하기 위한것
	    private int computeCover(Cover cover) {
	        if (cover == null) {
	            return 0;
	        } else if (cover.thick > 0) {
	            return cover.end - cover.start;
	        } else {
	            return cover.childrenCover;
	        }
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