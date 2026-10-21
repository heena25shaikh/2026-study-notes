package datastructures.leetcodeproblems;

import java.sql.Array;
import java.util.Arrays;

/***
 * Problem Statement
 *
 * Given a sorted array, remove duplicates in-place and fill the remaining positions with 0.
 *
 * Example
 * Java
 * Input:
 * [1,1,2,2,2,3,4,4,5]
 *  
 * Output:
 * [1,2,3,4,5,0,0,0,0]
 */

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        /*int [] duplicateNumberarray = {1,1,2,2,2,3,4,4,5};

        //Brute Force approach
        System.out.println("duplicateNumberarray is " +Arrays.toString(duplicateNumberarray));

        int[] tempArray = new int [duplicateNumberarray.length];

        int j=0;

        //get all unique elements in temp array
        for(int i=0; i<duplicateNumberarray.length; i++) {
            if(i==0 || duplicateNumberarray[i] != duplicateNumberarray[i-1]){
                tempArray[j] = duplicateNumberarray[i];
                j++;
            }
        }

        //append remaining position with zeros
        for(int i=j; i<duplicateNumberarray.length;i++){
            tempArray[i] = 0;
        }

        System.out.println(Arrays.toString(tempArray));*/

        /**
         * temp = [1, 2, 3, 4, 0, 0, 0]
         * j = 4
         *
         *
         * Here, j represents the number of unique elements.
         *
         * The second loop copies the four unique elements into arr. The third loop fills all positions from index 4 onward with zeros.
         *
         * Complexity:
         * - Time: \(O(n)\)
         * - Extra space: \(O(n)\), because we use another array.
         */


        //Optimal solution using sliding window pattern

        int[] duplicateNumArray = {1,1,2,2,2,3,4,4,5};

        int j=1;

        for(int i=1; i<duplicateNumArray.length; i++)
        {
            if(duplicateNumArray[i] != duplicateNumArray[j-1]){
                duplicateNumArray[j]=duplicateNumArray[i];
                j++;
            }

        }

        while(j<duplicateNumArray.length){
            duplicateNumArray[j] =0;
            j++;
        }

        System.out.println("optimal solution " +Arrays.toString(duplicateNumArray));

    }

    /**
     *
     * Because the array is sorted, duplicates are always next to each other.
     * We only need to compare an element with the previous relevant element rather than searching the entire array.
     *
     * Interview tip: First explain the brute force approach, then improve it by eliminating the temporary array.
     * This demonstrates how you optimize extra space from \(O(n)\) to \(O(1)\).
     *
     */

}
