public class Problem1 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;
            int le=0;
            for(int p : arr){
                le++;
                answer += p;
            }
            answer/=le;
            return answer;
        }
    }
}
