import java.awt.*;
import java.util.ArrayList;

public class Board{
    public static final int BOARD_SIZE = 8;

    public Square[][] square;
    private Piece checker;


    public Board() {
        // creates a 2d array of pieces and sets all the pieces in their starting location
        square = new Square[BOARD_SIZE][BOARD_SIZE];
        initializePieces();
    }

    // returns the square at index[row][col] as long as it is valid
    public Square getSquare(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return null;
        }
        return square[row][col];
    }

    // returns the piece at index[row][col] as long as it is valid
    public Piece getPieceAt(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return null;
        }
        return square[row][col].getP();
    }

    // if a pawn of either reaches the other side of the board it auto promotes to a queen
    public void isPromotion() {
        Piece p;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                p = square[i][j].getP();
                if(p instanceof Pawn) {
                    if(p.getColor() == Color.BLACK) {
                        if(i == 7) {
                            square[i][j].setP(new Queen(Color.BLACK, square[i][j]));
                        }
                    }
                    else if(p.getColor() == Color.WHITE) {
                        if(i == 0) {
                            square[i][j].setP(new Queen(Color.WHITE, square[i][j]));
                        }
                    }
                }
            }
        }
    }

    // takes in a piece and checks if it is attacking the king
    public boolean isCheck(Piece p) {
        Color c = p.getColor();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(square[i][j].getP() instanceof King && square[i][j].getP().getColor() != c) {
                    if(p.isLegalMove(this, p.getPosition(), i, j)) {
                        checker = p;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // sets up all the pieces
    private void initializePieces() {
        // creates all the squares and puts them in the 2d array
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                square[row][col] = new Square(row, col);
            }
        }

        // Set up pawns
        for (int col = 0; col < BOARD_SIZE; col++) {
           square[1][col].setP(new Pawn(Color.BLACK, square[1][col]));
           square[6][col].setP(new Pawn(Color.WHITE, square[6][col]));
        }

        // Set up rooks
        square[7][0].setP(new Rook(Color.WHITE, square[7][0]));
        square[7][7].setP(new Rook(Color.WHITE, square[7][7]));
        square[0][7].setP(new Rook(Color.BLACK, square[0][7]));
        square[0][0].setP(new Rook(Color.BLACK, square[0][0]));

        // Set up knights
        square[7][1].setP(new Knight(Color.WHITE, square[7][1]));
        square[7][6].setP(new Knight(Color.WHITE, square[7][6]));
        square[0][1].setP(new Knight(Color.BLACK, square[0][1]));
        square[0][6].setP(new Knight(Color.BLACK, square[0][6]));

        // Set up bishops
        square[7][2].setP(new Bishop(Color.WHITE, square[7][2]));
        square[7][5].setP(new Bishop(Color.WHITE, square[7][5]));
        square[0][2].setP(new Bishop(Color.BLACK, square[0][2]));
        square[0][5].setP(new Bishop(Color.BLACK, square[0][5]));

        // Set up queens
        square[7][4].setP(new Queen(Color.WHITE, square[7][4]));
        square[0][4].setP(new Queen(Color.BLACK, square[0][4]));

        // Set up kings
        square[7][3].setP(new King(Color.WHITE, square[7][3]));
        square[0][3].setP(new King(Color.BLACK, square[0][3]));
    }

}
