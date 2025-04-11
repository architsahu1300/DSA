package dynamicprogramming;

public class ZeroOneKnapsackRecursive {
    public static void main(String[] args) {
        int[] weight = {1,3,4,5};
        int[] value = {1,4,5,7};
        int capacity = 7;
        int len = value.length;
        System.out.println(maxProfit(weight,value,capacity,len));
    }

    public static int maxProfit(int[] weight, int[] value, int capacity, int len){
        if(len==0 || capacity ==0)
            return 0; //No profit in these 2 cases
        if(weight[len-1]<=capacity){
            //Max of
            //Choose to keep item so capacity is now reduced
            //Choose to not keep item so capacity is the same now
            return Math.max(value[len-1]+maxProfit(weight,value,capacity-weight[len-1],len-1),maxProfit(weight,value,capacity,len-1));
        }
        else{
            return maxProfit(weight,value,capacity,len-1);
        }
    }
}
