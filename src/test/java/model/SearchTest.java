package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void searchTest() {
        int [] arr = util.Utility.generatedSorted(20,50);
        int value = new Random().nextInt(50);
        int pos = Search.binarySearch(arr,value,0,arr.length-1);
       // assertEquals(value,arr[pos]);
        System.out.println(Arrays.toString(arr));
        System.out.println("Pos: " +pos+ " value: "+value);

        for(String s: Search.steps){
            System.out.println(s);
        }
    }

}