import java.util.ArrayList;
import java.util.Collections;

public class Arraylist {

    // 1 make function for swap element
    public static void swap(ArrayList<Integer> num, int inx1, int inx2){
    int temp = num.get(inx1);
    num.set(inx1, num.get(inx2));
    num.set(inx2, temp);
} 

    // 2 container with maximum water TC = O(n^2)
    public static int maxWater(ArrayList<Integer> height){
        int maxWater = 0;
        for(int i=0; i<=height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int hyt = Math.min(height.get(i), height.get(j));
                int wdth = j-i;
                int currWater = hyt * wdth;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    // 3 container with maximum water TC = O(n)
    // two pointer approach
    public static int maxWaterByTwoPointer(ArrayList<Integer> height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;
        while(lp < rp){
            int hyt = Math.min(height.get(lp), height.get(rp));
            int wdth = rp-lp;
            int currWater = hyt * wdth;
            maxWater = Math.max(maxWater, currWater);
        
            if(height.get(lp) < height.get(rp)){
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    // 4 pair sum-1 Brute force method
    public static boolean printSum(ArrayList<Integer> list, int target) {
        for(int i=0; i<=list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    // 5 pair sum1 two pointer method
    public static boolean printSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size()-1;
        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            if(list.get(lp) + list.get(rp) < target){
                lp++;
            } else{
                rp--;
            }
        }
        return false;
    }

    // 6 pair sum2 for sorted and rotated array (2 pointer) O(n)
    public static boolean printSum2(ArrayList<Integer> listt, int target) {
        int bp = -1;  // break point
        for(int i=0; i<=listt.size(); i++){
            if(listt.get(i) > listt.get(i+1)){
                bp = i;
                break;
            }
        }
        int lp = bp+1;
        int rp = bp;
        int n = listt.size();
        while(lp != rp){
            if(listt.get(lp) + listt.get(rp) == target){
                return true;
            }
            if(listt.get(lp) + listt.get(rp) < target){
                lp = (lp+1) % n;
            } else{
                rp = (n+rp-1) % n;
            }
        }
        return false;
    }

    public static void main(String...arg) {
        /* 
        ArrayList<Integer> num = new ArrayList<>();

        // add element
        num.add(5);
        num.add(10);
        num.add(15);
        num.add(20);
        num.add(25);
        System.out.println(num);
        System.out.println();

        // get element
        System.out.println("element at 2nd index : ");
        int element = num.get(2);
        System.out.println(element);
        System.out.println();

        // remove element
        System.out.println("removed 2nd index element in arraylist ");
        num.remove(2);
        System.out.println(num);
        System.out.println();

        // set element at index 
        System.out.println("print 100 at 2nd index");
        num.set(2,100);
        System.out.println(num);
        System.out.println();

        // contain element
        System.out.println("Is 12 exist in Arraylist?");
        System.out.println(num.contains(12));
        System.out.println();

        // add 15 at index 2
        System.out.println("add 15 at index 2");
        num.add(2,15);
        System.out.println(num);
        System.out.println();

        // get size
        System.out.println("size of arrayList : " + num.size());
        System.out.println();

        // reverse arrayList
        System.out.println("reverse array");
        for(int i=num.size()-1; i>=0; i--){
            System.out.print(num.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        // find maximum
        int max = Integer.MIN_VALUE;
        for(int i=0; i<num.size(); i++){
            max = Math.max(max, num.get(i));
        }
        System.out.print("maximum value : ");
        System.out.println(max);
        System.out.println();

        // 1 swap element
        int inx1 = 1, inx2 = 3;
        System.out.println("before swap");
        System.out.println(num);
        System.out.println("after swap");
        swap(num, inx1, inx2);
        System.out.println(num);
        System.out.println();

        // Ascending
        System.out.println("ascending order");
        Collections.sort(num);
        System.out.println(num);

        // descending 
        System.out.println("descending order");
        Collections.sort(num, Collections.reverseOrder());
        System.out.println(num);
        System.out.println();        
        */

        /* 
        // multi-dimention arraylist
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i=1; i<=4; i++){
            list1.add(i*1); // 1 2 3 4
            list2.add(i*2); // 2 4 6 8 
            list3.add(i*3); // 3 6 9 12
        }
        mainList.add(list1);
        mainList.add(list1);
        mainList.add(list1);
        System.out.println("Multi-direction arrayList");
        System.out.println(mainList);
        */

    /*  // 2 Container - max water
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);  height.add(8);  height.add(6);
        height.add(2);  height.add(5);  height.add(4);
        height.add(8);  height.add(3);  height.add(7);
        System.out.println("maximum water stored in any container : " + maxWater(height));
        // 3 by two pointer approach
        System.out.println("maximum water(by 2 pointer method) : " + maxWaterByTwoPointer(height)); */

     /* // 4 pair sum1 
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2);
        list.add(3); list.add(4);
        list.add(5);
        int target = 5; // if target=25 then ans false any pair don't have 25 as sum
        System.out.println("sum 5 is posible : " + printSum(list, target));
        // 5 two ponter method pair sum
        System.out.println("sum 5 is posible : " + printSum1(list, target));   */

     /* // 5 pair sum 2
        ArrayList<Integer> listt = new ArrayList<>();
        listt.add(11); listt.add(15);
        listt.add(6); listt.add(8);
        listt.add(9); listt.add(10);
        int tar = 16;
        System.out.println("sum 16 is posible : " + printSum2(listt, tar));  */
    }
}
