package tic;

import java.util.Scanner;

public class TicTacToe {
    private Player player1,player2;
    private Board board;

    public static void main(String[] args) {
        TicTacToe ticTacToe=new TicTacToe();
        ticTacToe.startGame();
    }

    public void startGame(){
        Scanner s=new Scanner(System.in);
        player1=takePlayer(1);
        player2=takePlayer(2);
        while (player1.getSymbol()==player2.getSymbol()){
            System.out.println("Choose other symbol");
            char symbol=s.nextLine().charAt(0);
            player2.setSymbol(symbol);
        }

        board=new Board(player1.getSymbol(),player2.getSymbol());
        boolean player1turn=true;
        int status=board.Incomplete;
        while (status==board.Incomplete || status==board.Invalid){
            if(player1turn){
                System.out.println("Player1st"+player1.getName()+"'s turn");
                System.out.println("Enter x: ");
                int x=s.nextInt();
                System.out.println("Enter y: ");
                int y=s.nextInt();
                status=board.move(player1.getSymbol(),x,y);
                if(status!=board.Invalid) {
                    player1turn = false;
                    board.print();
                }
                else {
                    System.out.println("Invalid move try again");
                }
            }
            else {
                System.out.println("Player2nd"+player2.getName()+"'s turn");
                System.out.println("Enter x: ");
                int x=s.nextInt();
                System.out.println("Enter y: ");
                int y=s.nextInt();
                status=board.move(player2.getSymbol(),x,y);
                if(status!=board.Invalid){
                    player1turn=true;
                    board.print();
                }
                else {
                    System.out.println("Invalid move try again");
                }
            }
        }
            if(status == Board.Player_1_Wins){
                System.out.println("Player 1 - " + player1.getName() +" wins !!");
            }else if(status == Board.Player_2_Wins){
                System.out.println("Player 2 - " + player2.getName() +" wins !!");
            }else{
                System.out.println("Draw !!");
            }


    }
        public Player takePlayer(int num){
        Scanner s=new Scanner(System.in);
            System.out.println("Enter "+num+" player Name");
            String name=s.nextLine();
            System.out.println("Enter symbol");
            char symbol=s.nextLine().charAt(0);
            Player player=new Player(name,symbol);
            return player;
        }
}
