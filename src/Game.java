import java.awt.*;

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
        window = new GameViewer(this, 800, 600);
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