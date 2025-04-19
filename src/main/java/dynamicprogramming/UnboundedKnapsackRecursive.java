package dynamicprogramming;

public class UnboundedKnapsackRecursive {
    public static void main(String[] args) {
        int[] weight = {1,2,3,5};
        int[] value = {2,3,4,6};
        int capacity = 7;
        int len = weight.length;
        System.out.println(maxProfit(weight,value,capacity,len));
    }
    public static int maxProfit(int[] weight, int[] value, int capacity, int len){
        if(len==0 || capacity==0) return 0;
        if(weight[len-1]<=capacity){
            //We take the item and keep it for next iteration, or don't take the item and leave it forever
            return Math.max(value[len-1]+maxProfit(weight,value,capacity-weight[len-1],len),
                    maxProfit(weight,value,capacity,len-1));
        }
        else{
            return maxProfit(weight,value,capacity,len-1);
        }
    }
}
