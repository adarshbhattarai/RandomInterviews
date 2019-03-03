package com.adarsh;

/**
 * Created by adarshbhattarai on 9/26/18.
 */
public class search {

    public static void main(String[] args){

        int array[] = {5,15,20,25,30,1,2,4};
        int m=1;
        System.out.println(findNumber(array,m));

    }

    private static boolean findNumber(int[] array, int m) {
        return findNumber(array,m,0,array.length-1);
    }

    private static boolean findNumber(int[] array, int m, int left, int right) {
        System.out.println(left + " " + right);
        if (array[left] == m || array[right] == m) return true;
        if (left >= right || right <= 0 || left > array.length) return false;
        if (m > array[left] && m > array[right])
            return findNumber(array, m, left, (left + right + 1) / 2);
        if (m < array[left] && m < array[right])
            return findNumber(array, m, (left + right + 1) / 2, right);
        else {
            if (m < array[(left + right + 1) / 2])
                return findNumber(array, m, left, (right + left+1) / 2);
            else
                return findNumber(array, m, (right + left+1) / 2, right);
        }

    }

}
