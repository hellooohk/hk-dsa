package Sorting;
import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] leftArr = new int[mid - low + 1];
        int[] rightArr = new int[high - mid];
        for(int i = 0 ; i < leftArr.length ; i++){
            leftArr[i] = arr[i+low];
        }
        for(int j = 0 ; j < rightArr.length ; j++){
            rightArr[j] = arr[j + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while(i < leftArr.length && j < rightArr.length){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while(i < leftArr.length){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < rightArr.length){
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public static void main(String[] args) {
        
        int [] arr = {9,11,14,1,2,3};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}