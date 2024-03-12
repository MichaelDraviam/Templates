package DSA.Java;

import java.util.Arrays;

/*Given N men and N women and the marriage preference order for each man and woman. 
Their marriage will be stable when these men and women marry in such a manner so that everyone gets the most desired partner as per the availability
( partners in a marriage cannot find anyone else better than what they get).  
https://www.geeksforgeeks.org/stable-marriage-problem/
*/

public class StableMatching{
    // Number of Men or Women 
    static int N = 4; 
 
    public static void main(String[] args) 
    { 
        int prefer[][] = new int[][]{{7, 5, 6, 4}, 
                                     {5, 4, 6, 7}, 
                                     {4, 5, 6, 7}, 
                                     {4, 5, 6, 7}, 
                                     {0, 1, 2, 3}, 
                                     {0, 1, 2, 3}, 
                                     {0, 1, 2, 3}, 
                                     {0, 1, 2, 3}}; 
        StableMatching sm = new StableMatching();
        sm.match(prefer);

    }

    /* returns true if current selection of male is of higher preference than next*/
    public boolean happy(int[] preferences,int current,int next){
        for(int i=0;i<N;i++){
            if(preferences[i] == current){return true;}
            if(preferences[i] == next){return false;}
        }
        return true;
    }

    // Prints stable matching for N boys and
    // N girls. Boys are numbered as 0 to 
    // N-1. Girls are numbered as N to 2N-1. 
    public void match(int[][] prefer){ // O(n2)

        //output
        int[] wPref = new int[N];
        //men free
        boolean[] mFree = new boolean[N];
        //initialize all wPref to -1
        Arrays.fill(wPref, -1);

        int freeMen = N;
        while(freeMen > 0){
            int m; 
            //finds first free man
            for (m = 0; m < N; m++){
                if (mFree[m] == false){break;}
            }
            
            //iterate all women that m wants till m is taken
            for (int i = 0; i < N && mFree[m] == false; i++){
                int w = prefer[m][i]; 
                //if that w hasn't chose a man take m  
                if (wPref[w - N] == -1){ 
                    wPref[w - N] = m; 
                    mFree[m] = true; 
                    freeMen--; 
                }
                else{
                    //current fav man
                    int m1 =  wPref[w - N];
                    if(!happy(prefer[w],m1,m)){
                        mFree[m] = false;
                        mFree[m1] = true;
                        wPref[w - N] = m;
                    }

                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.println("Woman :"+(int)(i+N)+" , Man :"+wPref[i]);
        }

    }

}