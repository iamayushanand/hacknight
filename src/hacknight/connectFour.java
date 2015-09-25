package hacknight;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ayush Anand on 23/09/2015.
 */

/**
 *
 * java team code for hack night
 *
 * Algorithm for checking
 *
 * vertical check:
 * given x,y coordinate on matrix
 * iterate over values of y.
 *
 * horizontal check:
 * given x,y coordinate on matrix
 * iterate over possble values of x.
 *
 * diagonal check:
 * given x,y
 *
 * break down iteration into four parts:
 * \
 *  \
 *   \     #part one
 *    \
 *     \
 *
 *      /
 *     /  #part two
 *   /
 * /
 *
 * \
 *  \
 *   \   #part three
 *    \
 *
 *    #identical to part two
 *
 * iterate through each of the diagonals.
 *
 *
 *
 */
public class connectFour {
    public static int row=6;
    public static int column=6;
    public static int[][] matrix = new int[6][6];
    public static boolean move(int y, int player){
        int x = 5;
        for(int i=0;i<6;i++){
            if(matrix[i][y] !=0){
                x=i-1;
                break;
            }
        }
        matrix[x][y]=player;
        //System.out.println(check(player,x,y));
        if(check(player,x,y)==1){
            System.out.println("player number "+player+" won");
            return true;
        }
        return false;
    }
    public static int hori_check(int player,int x,int y){
        int count=0;
        for ( y = 0; y < 6; y++) {

            if(matrix[x][y]==player){
                ++count;
                if(count==4){return 1;}
            }else{
                count=0;
            }
        }
        return 0;
    }

    public static int vert_check(int player,int x,int y){
        int count=0;
        for ( x = 0; x < 6; x++) {

            if(matrix[x][y]==player){
                ++count;
                if(count==4){return 1;}
            }else{
                count=0;
            }
        }
        return 0;
    }

    public static int diag_check(int player,int x,int y){
        int count=1;
        int row = x;
        int column =y;
 //       System.out.println(row+" "+column);

        for ( row = x,column=y; !(column==0 || row==0)  ; column--,row--) {
 //           if(!(column!=0 || row!=0)){
 //           System.out.println("first: "+row+" "+column+" "+count);
            if(matrix[row][column]==player){
                ++count;
                if(count==4){return 1;}
            }else{
                count=0;
            }
   //         }else{break;}
        }
        for ( row = x,column=y; !(column==5 || row==5)  ; column++,row++) {
 //          if(!(column!=5 || row!=5)){
 //              System.out.println("second: "+row+" "+column+" "+count);
            if(matrix[row][column]==player){
                ++count;
                if(count==4){return 1;}
            }else{
                count=0;
            }
  //         }else{break;}
        }

        if(count==4){return 1;}

        count=0;
        row = x;
        column =y;
//        System.out.println(row+" "+column);
        for ( row = x,column=y; !(column==0 || row==5)  ; column--,row++) {
 //           if(!(column!=0 || row!=5)){
 //               System.out.println("third: "+row+" "+column+" "+count);
                if(matrix[row][column]==player){
                    ++count;
                    if(count==4){return 1;}
                }else{
                    count=0;
                }
   //         }else{break;}
        }
        for ( row = x,column=y; !(column==5 || row==0)  ; column++,row--) {
  //          if(!(column!=5 || row!=0)){
 //               System.out.println("fourth: "+row+" "+column+" "+count);
                if(matrix[row][column]==player){
                    ++count;
                    if(count==4){return 1;}
                }else{
                    count=0;
                }
    //        }else{break;}
        }

        if(count==4){return 1;}

        return 0;
    }









    public static int check(int player,int x,int y){
//if horiz check
        if(hori_check(player,x, y)==1){
            return 1;
        }
//if vert check
        if(vert_check(player,x, y)==1){
            return 1;
        }
        if(diag_check(player,x, y)==1){
            return 1;
        }
        return 0;
    }
//if diag check





    public static void main(String args[]){
        ///test case #1
//        move(0,1);
//        move(1,1);
//        move(2,1);
//        move(3,1);
//        move(4,2);

       ///test case #2
 //       move(0,1);
 //       move(0,1);
 //       move(0,1);
 //       move(0,1);
 //       move(0,1);
 //       move(1,1);
 //       move(1,1);
 //       move(1,1);
 //       move(1,1);
 //       move(2,1);
 //       move(2,1);
 //       move(2,1);
 //       move(3,1);
 //       move(3,1);
 //       move(4,1);


        //move(3,1);
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<50;i++){
            if(i%2==0){
                System.out.println("player number 1 please enter column num 0-5:");

                 if(move(sc.nextInt(),1)){break;}}
             else{
                 System.out.println("player numer 2 please enter column num 0-5:");
                 if(move(sc.nextInt(),2)){break;}
             }
            for(int h=0;h<6;h++){
                System.out.println(Arrays.toString(matrix[h]));
            }
         }

    }
}
