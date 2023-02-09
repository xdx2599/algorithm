import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 135. 分发糖果
 * https://leetcode.cn/problems/candy/
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = new int[]{1,3,2,2,1};
        System.err.println(candy(ratings));

    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        if(n==1){
            return 1;
        }
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0;i<n;i++){
            if(i>0 && ratings[i-1]<ratings[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }


        for(int i=n-1;i>=0;i--){
            if(i<n-1 && ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=1;
            }
        }


        int res =0;
        for(int i=0;i<n;i++){
            res+= Math.max(left[i],right[i]);
        }
        return res;
    }
}
