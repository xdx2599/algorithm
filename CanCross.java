public class CanCross {
    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        System.err.println(canCross(stones));
    }
    public static boolean canCross(int[] stones) {
        if(stones==null || stones.length==0){
            return true;
        }
        int n = stones.length;
        if(n>1 && stones[1]!=1){
            return false;
        }
        int[] dps = new int[n+1];
        int[] steps = new int[n+1];
        dps[1]=1;
        steps[1]=1;
        int pointer =1;
        for(int i=2;i<n;i++){
            int dp = dps[i-1];
            int step = steps[i-1];
            int left = dp+step-1;
            int right = dp+step+1;
            for(int j=pointer+1;j<n;j++){
                int next = stones[j];
                if(next>right){
                    break;
                }
                if(next>=left && next<=right){
                    dps[i]=next;
                    steps[i]=next-dp;
                    pointer=j;
                }
            }
            if(dps[i]==0){
                return false;
            }
        }
        return true;
    }
}
