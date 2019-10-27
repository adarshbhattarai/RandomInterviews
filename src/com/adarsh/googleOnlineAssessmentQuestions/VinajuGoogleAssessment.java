package com.adarsh.googleOnlineAssessmentQuestions;

/**
 * @author adarshbhattarai on 2019-10-23
 * @project untitled
 */
public class VinajuGoogleAssessment {

    public static void main(String[] args) {

        VinajuGoogleAssessment assessment = new VinajuGoogleAssessment();

        String abc = "asbcdefg-hi4jka";
        System.out.println(soulution1PractiseTest(abc,3));

        //https://leetcode.com/discuss/interview-question/394347/
        //Watering Flowers
        int[] plants=new int[]{2,4,5,1,2};
        int capacity1 = 5;
        int capacity2=7;
        int minNoOfRefills = assessment.minimumRefillsWateringFlower(plants,capacity1,capacity2);
        System.out.println(minNoOfRefills==3);

        //minimumDomino Rotation
        //https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
        int[] A= {2,1,2,4,2,2};
        int[] B={5,2,6,2,3,2};
        int minimumRotation = assessment.minimumDominoRotation(A,B);
        System.out.println(minimumRotation == 2);


    }

    private int minimumDominoRotation(int[] A, int[] B) {
        int[] countsA=new int[7];
        int[] countsB=new int[7];
        int[] occuredInBoth = new int[7];

        for(int i=0;i<A.length;i++){
            countsA[A[i]]++;
            countsB[B[i]]++;
            if(A[i]==B[i])
                occuredInBoth[A[i]]++;
        }

        for(int i=1;i<7;i++){

            if(countsA[i] + countsB[i] - occuredInBoth[i] == A.length){
                return A.length - Math.max(countsA[i],countsB[i]);
            }
        }

        return -1;
    }

    //https://leetcode.com/discuss/interview-question/394347/
    //Watering Flowers
    private int minimumRefillsWateringFlower(int[] plants, int capacity1, int capacity2) {
        int refills=0;
        int capA=0;
        int capB=0;
        for(int i=0;i<plants.length/2;i++){
            int firstPlant=plants[i];
            int lastPlant = plants[plants.length-i-1];
            if(firstPlant>capA){
                refills++;
                capA=capacity1;
            }
            if(lastPlant>capB){
                refills++;
                capB = capacity2;
            }

            capA-=firstPlant;
            capB-=lastPlant;
        }

        if(plants.length%2==1 && capA+capB<plants[plants.length/2]){
            return refills+1;
        }

        return refills;
    }

    static String soulution1PractiseTest(String str, int k){


        int i=0;
        String givvenString[] = str.split("-");
        String combined = "";
        for(String st : givvenString){
            combined+=st;
        }

        int firstSplit = 0;
        if(combined.length()%k >0 ){
            firstSplit = combined.length()%k;
        }
        String returnedStr = "";

        if(firstSplit>0){
        returnedStr = combined.substring(0,firstSplit)+"-";
        combined = combined.substring(firstSplit);
        }

        while(i<combined.length()){
            returnedStr+= combined.substring(i,i+k)+"-";
            i+=k;
        }

        returnedStr=returnedStr.replaceAll("-$","");
        return returnedStr.toUpperCase();
    }
}
