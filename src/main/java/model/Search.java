package model;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public static List<String> steps = new ArrayList<>();

    //int value = 10;
    //int pos = binarySearch (sortedArray,value,0,sortedArray.length-1);
    public static int binarySearch(int[] sortedArray, int low, int high,int value) {
        //Case base
        if(low > high){
            steps.add("No encontrado");
            return -1;
        }
        int mid=low+(high-low)/2;

        steps.add("Rango["+low+","+high+"] -->mid= "+mid
                + "sortedArray[mid]="+sortedArray[mid]+")");

        if(value==sortedArray[mid]){
            steps.add("Encontrado en indice"+mid);
            return mid;
        }else if(value<sortedArray[mid]){
            return binarySearch(sortedArray,low,value,mid-1);
        }else{
            return binarySearch(sortedArray,mid+1,value,high);
        }
    }
}
