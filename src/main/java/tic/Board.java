package tic;

public class Board {
    private char board[][];
    private int boradsize=3;
    private char p1Symbol,p2Symbol;
    private int count=0;
    public final static int Player_1_Wins=1;
    public final static int Player_2_Wins=2;
    public final static int Draw=3;
    public final static int Incomplete=4;
    public final static int Invalid=5;

    public Board(char p1Symbol, char p2Symbol) {
        board=new char[boradsize][boradsize];
        for (int i=0;i< board.length;i++){
            for (int j=0;j< board.length;j++){
                board[i][j]=' ';
            }
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
    }

    public int move(char symbol, int x, int y) {
        if(x<0 || x>=boradsize||y<0||y>=boradsize||board[x][y]!=' ') {
            return Invalid;
        }
            board[x][y]=symbol;
            count++;
            //check row
            if(board[x][0] == board[x][1] && board[x][1]==board[x][2]){
                return symbol== p1Symbol ? Player_1_Wins : Player_2_Wins;
            }
            //check colm
            if(board[0][y] == board[1][y] && board[1][y]==board[2][y]){
                return symbol== p1Symbol ? Player_1_Wins : Player_2_Wins;
            }
            //check diag
            if(board[0][0]!=' '&&board[0][0] == board[1][1] && board[1][1]==board[2][2]){
                return symbol== p1Symbol ? Player_1_Wins : Player_2_Wins;
            }
            //check diag
            if(board[0][2]!=' '&&board[0][2] == board[1][1] && board[1][1]==board[2][0]){
                return symbol== p1Symbol ? Player_1_Wins : Player_2_Wins;
            }
            if(count==boradsize*boradsize){
                return Draw;
            }
            return Incomplete;
        }



    public void print() {
        System.out.println("---------------");
        for(int i =0; i < boradsize; i++){
            for(int j =0; j < boradsize; j++){
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}
