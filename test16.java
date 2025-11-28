import java.util.Scanner;
public class test16 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("创建第一个有序数组");
        System.out.println("请输入第一个有序数组的元素个数：");
        int n =scanner.nextInt();
        int[] nums1= new int[n];
        System.out.println("请输入第一个有序数组的元素：");
        for(int i=0;i<n;i++){
            nums1[i]= scanner.nextInt();
        }
        System.out.println("创建第二个有序数组");
        System.out.println("请输入第二个有序数组的元素个数：");
        int m =scanner.nextInt();
        int[] nums2= new int[m];
        System.out.println("请输入第二个有序数组的元素：");
        for(int i=0;i<m;i++){
            nums2[i]= scanner.nextInt();
        }
        System.out.println("合并后的数组为：");
        int[] nums=Merge(nums1,n,nums2,m);
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }
    public static int[] Merge(int[] nums1,int n,int[] nums2,int m){
        int i=0,j=0,t=n+m,k=0;
        int[] nums=new int[t];
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                nums[k++] = nums1[i++];
            }else{
                nums[k++]=nums2[j++];
            }
        }
        if(i >= n){
            while(j < m){
                nums[k++]=nums2[j++];
            }
        }else{
            while(i < n) {
                nums[k++] = nums1[i++];
            }
        }
        return nums;
    }
}
