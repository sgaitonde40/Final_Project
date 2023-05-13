
public class Game {
    private Board board;
    private GameViewer window;

    // creates a new game object and gameviewer object
    public Game() {
        board = new Board();
        window = new GameViewer(this, 770, 740);
        window.repaint();
    }

    // returns the games board
    public Board getBoard() {
        return board;
    }


}