import java.util.Arrays;

public class ArrayOperations {
    static int[] array = {1,5,8,9,4,6,7};
    public static void sum(){
        int sum=0;
        for(int value : array){
            sum+=value;
        }
        System.out.println("The sum of the array values is "+sum);
    }

    public static void getMax(){
        int max = Integer.MIN_VALUE;
        for (int value : array){
            if(value>max){
                max = value;
            }
        }
        System.out.println("The max value is "+max);
    }

    public static void getMin(){
        int min = Integer.MAX_VALUE;
        for (int value : array){
            if(value<min){
                min = value;
            }
        }
        System.out.println("The min value is "+min);
    }

    public static void reverseArray(){
        int[] reversedArray = new int[array.length];
        for (int i=0;i<array.length;i++){
            reversedArray[i] = array[array.length-1-i];
        }
        System.out.println("The reversed array is "+Arrays.toString(reversedArray));
    }

    public static void main(String[] args){
        System.out.println("The array is "+Arrays.toString(array));
        sum();
        getMax();
        getMin();
        reverseArray();
    }
}
