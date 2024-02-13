import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static int[] randomarray(int x) {
        int[] arr = new int[x];
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
    //Merge Sort
    public static void mergeSort(int[] arr, int leftpart, int rightpart){
        if (rightpart - leftpart > 1){
            int middle = (leftpart + rightpart)/2;
            mergeSort(arr, leftpart, middle);
            mergeSort(arr, middle, rightpart);
            merge(arr, leftpart, middle, rightpart);
        }
    }

    public static void merge(int[] arr, int leftpart, int middle, int rightpart){
        int[] leftarr = Arrays.copyOfRange(arr, leftpart, middle);
        int[] rightarr = Arrays.copyOfRange(arr, middle, rightpart);
        int i =0, j = 0;

        for(int k = leftpart; k < rightpart; k++){
            if (i == leftarr.length){
                arr[k] = rightarr[j++];
            } else if (j == rightarr.length){
                arr[k] = leftarr[i++];
            }else if (leftarr[i] <= rightarr[j]){
                arr[k] = leftarr[i++];
            }else{
                arr[k] = rightarr[j++];
            }
        }
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length);
    }

    //Bubble Sort
    public static void swap(int[] arr, int i, int j){
        if (arr == null){
        }
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }

    public static void bubbleSort(int[] array){
        if (array == null || array.length <= 1){
            return;
        }
        for (int i = 0; i< array.length-1; i++){
            for (int j = 0; j < array.length-1-i; j++){
                if (array[j] > array[j+1]){
                    swap(array , j , j+1);

                }
            }
        }
    }
    

    

    public static void main(String[] args) throws Exception {
        int[] myarr = randomarray(10);
        System.out.println("Here is a random array with 10 numbers:");
        System.out.println(Arrays.toString(myarr));
        long merge_start_time = System.currentTimeMillis();
        mergeSort(myarr);
        long merge_end_time = System.currentTimeMillis();
        System.out.println("Here it is sorted with Merge Sort:");
        System.out.println(Arrays.toString(myarr));
        System.out.println("This took " + (merge_end_time - merge_start_time) + " ms");

        int[] anotherarr = randomarray(10);
        System.out.println("Here is another random array with 10 numbers:");
        System.out.println(Arrays.toString(anotherarr));
        System.out.println("Here it is sorted with Bubble Sort:");
        long bubble_start_time = System.currentTimeMillis();
        bubbleSort(anotherarr);
        long bubble_end_time = System.currentTimeMillis();
        System.out.println(Arrays.toString(anotherarr));
        System.out.println("This took " + (bubble_end_time - bubble_start_time) + " ms");
        
    }
}
