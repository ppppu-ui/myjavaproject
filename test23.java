import java.util.Arrays;
public class test23 {
    public static void main(String[] args){
        int[] arr={1,3,6,2,7,4,9};
        System.out.println("排序前："+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        if(arr==null||arr.length<=1){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            boolean swapped =false;
            for(int t=0;t<arr.length-1-i;t++){
                if(arr[t]>arr[t+1]){
                    int temp=arr[t];
                    arr[t]=arr[t+1];
                    arr[t+1]=temp;
                    swapped = true;
                }
            }
            if(swapped==false){
                break;
            }
        }
    }
}
