public class test14 {
    public static <T extends Comparable<T>> T findmax(T[] array)throws Exception{
        if(array==null || array.length ==0){
            throw new Exception("数组不能为空");
        };
        T max=array[0];
        for(int i=1;i< array.length;i++){
            if(array[i].compareTo(max)>0){
                max=array[i];
            }
        }
        return max;
    }
    public static void main(String args[]){
        Integer[] array1={1,2,3,4,5};
        String[] array2 = {"apple", "banana", "orange", "grape"};
        Double[] array3 = {3.14, 1.618, 2.718};
        try{
            System.out.println("整数数组最大值："+findmax(array1));
            System.out.println("字符串数组最大值："+findmax(array2));
            System.out.println("双精度数组最大值："+findmax(array3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
