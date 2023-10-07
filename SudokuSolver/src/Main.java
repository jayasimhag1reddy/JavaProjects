import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] board= enterBoard();
        if(Solve(board)){
            printBoard(board);
        }
        else{
            System.out.println("The question is inValid");
        }
    }
    public static int[][] enterBoard(){
        System.out.println("Enter your board values");
        Scanner sc=new Scanner(System.in);
        int[][] board=new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]= sc.nextInt();
            }
        }
        return board;
    }
    public static boolean isValidRow(int[][] board,int row,int num){
        for(int i=0;i< board[row].length;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidCol(int[][] board,int col,int num){
        for(int i=0;i< board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidBox(int[][] board,int row,int col,int num){
        int br=row-(row%3);
        int bc=col-(col%3);
        for(int i=br;i<br+3;i++){
            for(int j=bc;j<bc+3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValidPlace(int[][] board,int row,int col,int num) {
        return isValidRow(board, row, num) && isValidCol(board, col, num) && isValidBox(board, row, col, num);
    }
    public static boolean Solve(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if(isValidPlace(board,i,j,k)) {
                            board[i][j] = k;
                            if (Solve(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][] board){
        for(int i=0;i< board.length;i++){
            System.out.print("|");
            for(int j=0;j<board[i].length;j++){
                if((j+1)%3==0){
                    System.out.print(board[i][j]+"|");
                }
                else{
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
            System.out.println("-------------------");
        }
    }
}