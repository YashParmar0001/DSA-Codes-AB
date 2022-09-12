package com.company;

public class GFGStreak {
    public static void main(String[] args) {

    }

    public int MinimumExchange(char[][] matrix)
    {
        // Code here
        int x = 0, y = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if((i%2 == 0 && j%2 == 0) || ((i&1)!=0 && (j&1)!=0)){
                    if(matrix[i][j] == 'A')
                        x++;
                }
                else{
                    if(matrix[i][j] == 'B')
                        x++;
                }
                if((i%2 == 0 && j%2 == 0) || ((i&1)!=0 && (j&1)!=0)){
                    if(matrix[i][j] == 'B')
                        y++;
                }
                else{
                    if(matrix[i][j] == 'A')
                        y++;
                }
            }
        }
        return Math.min(x, y);
    }
}
