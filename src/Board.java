import java.awt.*;
import java.util.ArrayList;

public class Board{
    public static final int BOARD_SIZE = 8;
    public Piece[][] pieces;

    public Board() {
        pieces = new Piece[BOARD_SIZE][BOARD_SIZE];
        initializePieces();
    }

    public Piece getPieceAt(int x, int y) {
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            return null;
        }
        return pieces[x][y];
    }

    public ArrayList<Piece> getPieces() {
        ArrayList<Piece> pieceList = new ArrayList<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Piece piece = pieces[row][col];
                if (piece != null) {
                    pieceList.add(piece);
                }
            }
        }
        return pieceList;
    }

    public Square findKing(Color color) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Square square = new Square(row, col);
                Piece piece = getPieceAt(row, col);
                if (piece instanceof King && piece.getColor() == color) {
                    return square;
                }
            }
        }
        return null;
    }


    private void initializePieces() {
        // Set up pawns
        for (int col = 0; col < BOARD_SIZE; col++) {
            pieces[col][1] = new Pawn(Color.WHITE, new Square(1, col));
            pieces[col][6] = new Pawn(Color.BLACK, new Square(6, col));
        }

        // Set up rooks
        pieces[0][0] = new Rook(Color.WHITE, new Square(0, 0));
        pieces[7][0] = new Rook(Color.WHITE, new Square(0, 7));
        pieces[0][7] = new Rook(Color.BLACK, new Square(7, 0));
        pieces[7][7] = new Rook(Color.BLACK, new Square(7, 7));

        // Set up knights
        pieces[1][0] = new Knight(Color.WHITE, new Square(0, 1));
        pieces[6][0] = new Knight(Color.WHITE, new Square(0, 6));
        pieces[1][7] = new Knight(Color.BLACK, new Square(7, 1));
        pieces[6][7] = new Knight(Color.BLACK, new Square(7, 6));

        // Set up bishops
        pieces[2][0] = new Bishop(Color.WHITE, new Square(0, 2));
        pieces[5][0] = new Bishop(Color.WHITE, new Square(0, 5));
        pieces[2][7] = new Bishop(Color.BLACK, new Square(7, 2));
        pieces[5][7] = new Bishop(Color.BLACK, new Square(7, 5));

        // Set up queens
        pieces[3][0] = new Queen(Color.WHITE, new Square(0, 3));
        pieces[3][7] = new Queen(Color.BLACK, new Square(7, 3));

        // Set up kings
        pieces[4][0] = new King(Color.WHITE, new Square(0, 4));
        pieces[4][7] = new King(Color.BLACK, new Square(7, 4));
    }
}
