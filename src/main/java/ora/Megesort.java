package ora;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Megesort {

    private static void mergesort(int[] array, int left, int right) {
        if(left < right){
            int mid = (left + right) /2;
            mergesort(array, left, mid);
            mergesort(array, mid+1 , right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {

        int i =left;
        int j = mid+1;
        int k =left;
        int[] tempArray = new int[right+1];

        while(i <= mid && j<=right){
            if(array[i] < array[j]){
                tempArray[k] = array[i];
                i++;
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            tempArray[k] = array[i];
            i++;
            k++;
        }

        while(j<=right){
            tempArray[k] = array[j];
            j++;
            k++;
        }

        for (int l = left; l <=right; l++) {
            array[l] = tempArray[l];
        }

    }


    public static void main(String[] args) throws IOException {
//        int[] array = new int[] {5,4,3,2,1};
//        mergesort(array, 0, array.length-1);
//        System.out.println(Arrays.toString(array));

        String fileName= "a.txt";
        File file = new File(System.getProperty("user.dir")+"/src/main/java/oracle/tempdata/"+fileName);
        if(!file.exists()){
            file.createNewFile();
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(150, -1);
        treeMap.put(90, -2);
        treeMap.put(550, -3);

        for(Map.Entry<Integer, Integer> entry:  treeMap.entrySet()){
            System.out.println(entry);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }



}
