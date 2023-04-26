import java.awt.*;
import java.util.ArrayList;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private GameViewer window;

    public Game() {
        board = new Board();
        whitePlayer = new Player(Color.WHITE);
        blackPlayer = new Player(Color.BLACK);
        currentPlayer = whitePlayer;
        window = new GameViewer(this, 720, 740);
        window.repaint();
        setPlayerPieces();
    }

    public ArrayList<Square> getValidMoves() {
        ArrayList<Square> s = new ArrayList<>();
        return s;
    }

    public void setPlayerPieces() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 2; j++) {
                whitePlayer.addPiece(getBoard().getPieceAt(j, i));
            }
        }
        for(int i = 0; i < 8; i++) {
            for(int j = 6; j < 8; j++) {
                blackPlayer.addPiece(getBoard().getPieceAt(j, i));
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public boolean isCheck(Color color) {
        Square kingSquare = board.findKing(color);
        if (kingSquare == null) {
            return false;
        }

        for (Piece piece : board.getPieces()) {
            if (piece.getColor() == color) {
                if (piece.isLegalMove(kingSquare)) {
                    return true;
                }
            }
        }

        return false;
    }

}