package practice.programmers.step4;

public class WordPuzzle {
	
	//주어진 단어조각들을이용해서 주어진 문장을 완성하는 퍼즐 주어진 단어조각은 각각 무한개가 들어있습니다.
	//이 퍼즐들을 이용하여 주어진 문장을 만뜰때 필요한 최솟값의 단어조각수를 구해라
	
	//입력 : 문자열 배열 strs와 만들어야하는 문자 t가 주어진다.
	
	//출력값 : 문자열을 만들때 들어가는 최소값의 단어수를 출력하고 만약 완성을 할 수 없을 경우에는 -1을 리턴해준다.
	
	
	int[] dp ;
	
	public int solution(String[] strs, String t) {
        int answer = 0;
        //dp 초기화
        dp = new int[t.length()];
        
        //앞에서부터 이동하면서 최소값을 구할것이다
        for(int i=1;i<t.length()+1;i++) {
        	//문자열을 리스트비교
        	for(int j = 0; j<strs.length;j++) {
        		//비교할 문자를 가져온다
        		String pu = strs[j];
        		//만약 비교가 불가능한 문자열 길이 넘어간다
        		if(i-pu.length()<0) {
        			continue;
        		}
        		//만약 비교해서 문자의 길이만큼 문자열끝이 같을경우 아니면 넘어가고
        		if(pu.equals(t.substring(i-pu.length(),i))) {
        			//딱 문자열길이가 맞는경우에는 1가지 문자열로 되므로 continue
        			if(i-pu.length()==0) {
        				dp[i-1]=1;
        				continue;
        			}
        			//문자열 비교전에 있는 문자열이 완성이 가능한 문자열일 경우에만 확인
        			if(dp[i - pu.length()-1]>0) {
        				//지금의 문자열이 완성이 안되던 친구
        				if(dp[i-1] == 0) {
        					dp[i-1] = dp[i-pu.length()-1]+1;
        				}
        				//지금 idx에 이미 완성된 문자열이 있었던 경우 그 dp와 현재만들어지는 dp의 최소값을 넣어준다.
        				else {
        					dp[i-1] = Math.min(dp[i-1], dp[i-pu.length()-1]+1);
        				}
        			}
        		}
        		
        		
        	}
        }
        
        answer = dp[dp.length-1];
        if(answer == 0) return -1;
        
        return answer;
    }
	
}
