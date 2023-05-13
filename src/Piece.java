import java.awt.*;

public class Piece {
    private Color color;
    private Square position;
    private int row,col;

    public Piece(Color c, Square position) {
        // sets up key info
        color = c;
        this.position = position;
        this.col = position.getCol();
        this.row = position.getRow();
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(int x, int y) {
        this.position = new Square(x, y);
    }


    public Square getPosition() {
        return position;
    }

    // here for ovveriding purposes
    public boolean isLegalMove(Board b, Square start, int row, int col) {
        return true;
    }

    // here for ovveriding purposes
    public void move(int row, int col, Board b) {
        if(isLegalMove(b, position, row, col)) {
            position.setP(null);
            b.getSquare(this.row, this.col).setP(null);
            this.row = row;
            this.col = col;
            b.getSquare(row, col).setP(this);
        }
    }


    public void setCol(int col) {
        this.col = col;
    }
    // here for ovveriding purposes
    public void draw(Graphics g, GameViewer G) {

    }

}
