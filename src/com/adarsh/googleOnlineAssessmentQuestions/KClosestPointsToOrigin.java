package com.adarsh.googleOnlineAssessmentQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author adarshbhattarai on 2019-10-27
 * @project untitled
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};

        int[][] out = findKClosestToOrigin(points,2);
        for(int[] i : out)
            System.out.println(i[0]+" " + i[1]);
    }

    //maintain heap of size K;
    private static int[][] findKClosestToOrigin(int[][] points, int K) {
        int[][] ret= new int[K][2];
        PriorityQueue<Plane> pq = new PriorityQueue<Plane>((a,b)->{ return b.dist<a.dist ? -1 : 1;});
        for(int[] pointP : points){
                pq.add(new Plane(pointP[0],pointP[1]));
                if(pq.size()>K)
                    pq.poll();
        }
        for(int i=0;i<K;i++){
            Plane p = pq.poll();
            ret[i][0] =p.x;
            ret[i][1] =p.y;
        }

        return ret;

    }

    public static class Plane {

        int x;
        int y;
        double dist;
        Plane(int x,int y){
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(x*x + y*y);
        }

    }

    /**
     * LC 3ms
     * class Solution {
     *     public int[][] kClosest(int[][] points, int K) {
     *         int left = 0;
     *         int right = points.length - 1;
     *         int pivot = 0;
     *         while(left < right) {
     *             pivot = partition(points, left, right);
     *             if(pivot == K) {
     *                 break;
     *             }
     *             else if(pivot < K) {
     *                left = pivot;
     *             } else if(pivot > K) {
     *                 right = pivot - 1;
     *             }
     *         }
     *
     *         return Arrays.copyOfRange(points, 0, K);
     *     }
     *
     *     private int partition(int[][] points, int left, int right) {
     *         int mid = (left + right)/2;
     *         int[] pivot  = points[mid];
     *         while(left <= right) {
     *             while(compare(points[left], pivot) < 0) left++;
     *             while(compare(points[right], pivot) > 0) right--;
     *
     *             if(left <= right){
     *                 int[] tmp = points[left];
     *                 points[left]  = points[right];
     *                 points[right] = tmp;
     *
     *                 left++;
     *                 right--;
     *             }
     *         }
     *
     *         return left;
     *     }
     *
     *     public int compare(int[]a, int[]b){
     *         return a[0]*a[0] + a[1]*a[1] -  b[0]*b[0] -b[1]*b[1];
     *     }
     * }
     * */

}
