package kenny.TicTacToe;

import static kenny.TicTacToe.Mark.*;

public class Board {
    private Mark[][] boardSurface = {{E,E,E,}, {E,E,E},{E,E,E}};

    public Board() {}

    public void getBoardSurfaceDisplay() {
        for (int i = 0; i < 3; i++) {
            System.out.print("  |  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(boardSurface[i][j]);
                System.out.print("  |  ");
            }

            System.out.println();
        }
    }

    public Mark[][] getBoardSurface() {
        return boardSurface;
    }
    private boolean checkWinnerAcrossRowZero(){
        boolean isX = boardSurface[0][0]== X && boardSurface[0][1] == X && boardSurface[0][2]==X;
        boolean isO = boardSurface[0][0]== O && boardSurface[0][1] == O && boardSurface[0][2]==O;
        if (isX || isO) return true;
        return false;
    }

    private boolean checkWinnerAcrossRowOne(){
        boolean isX = boardSurface[1][0] == X && boardSurface[1][1] == X && boardSurface[1][2] == X;
        boolean isO = boardSurface[1][0] == O && boardSurface[1][1] == O && boardSurface[1][2] == O;
        if (isX || isO) return true;
        return false;
    }
    private boolean checkWinnerAcrossRowTwo(){
        boolean isX = boardSurface[2][0] == X && boardSurface[2][1] == X && boardSurface[2][2] == X;
        boolean isO = boardSurface[2][0] == O && boardSurface[2][1] == O && boardSurface[2][2] == O;
        if(isX || isO) return true;
        return false;
    }
    private boolean checkWinnerAcrossColumnZero(){
        boolean isX = boardSurface[0][0] == X && boardSurface[1][0] == X && boardSurface[2][0] == X;
        boolean isO = boardSurface[0][0] == O && boardSurface[1][0] == O && boardSurface[2][0] == O;
        if (isX || isO) return true;
        return false;
    }
    private boolean checkWinnerAcrossColumnOne(){
        boolean isX = boardSurface[0][1] == X && boardSurface[1][1] == X && boardSurface[2][1] ==X;
        boolean isO = boardSurface[0][1] == O && boardSurface[1][1] == O && boardSurface[2][1] ==O;
        if (isX || isO) return true;
        return false;
    }
    private boolean checkWinnerAcrossColumnTwo(){
        boolean isX = boardSurface[0][2] == X && boardSurface[1][2] == X && boardSurface[2][2] ==X;
        boolean isO = boardSurface[0][2] == O && boardSurface[1][2] == O && boardSurface[2][2] ==O;
        if (isX || isO) return true;
        return false;
    }
    private boolean checkWinnerAcrossDiagonal1(){
        boolean isX = boardSurface[0][0] == X && boardSurface[1][1] == X && boardSurface[2][2] == X;
        boolean isO = boardSurface[0][0] == O && boardSurface[1][1] == O && boardSurface[2][2] == O;
        if (isX || isO) return true;
        return false;
    }
    private boolean checkWinnerAcrossDiagonal2(){
        boolean isX = boardSurface[0][2] == X && boardSurface[1][1] == X && boardSurface[2][0] == X;
        boolean isO = boardSurface[0][2] == O && boardSurface[1][1] == O && boardSurface[2][0] == O;
        if (isX || isO) return true;
        return false;
    }
    public boolean isWinner(){
        if (checkWinnerAcrossRowZero()) return true;
        if (checkWinnerAcrossRowOne()) return true;
        if (checkWinnerAcrossRowTwo()) return true;
        if (checkWinnerAcrossColumnZero()) return true;
        if (checkWinnerAcrossColumnOne()) return true;
        if (checkWinnerAcrossColumnTwo()) return true;
        if (checkWinnerAcrossDiagonal1()) return true;
        if (checkWinnerAcrossDiagonal2()) return true;
        return false;
    }
    private boolean isEmptyCell(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(boardSurface[i][j] == E){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isATie(){
        if(!isEmptyCell() && !isWinner())return true;
        else {
            return false;
        }
    }

}
