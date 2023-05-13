import javax.swing.*;
import java.awt.*;

public class Knight extends Piece{
    private Image image;
    private int x,y,row,col;

    public Knight(Color c, Square position){
        // sends main info to super class
        super(c, position);
        // gets image depending on color
        if(c == Color.BLACK) {
            image = new ImageIcon("Images/blackknight.png").getImage();
        }
        else if(c == Color.WHITE) {
            image = new ImageIcon("Images/whiteknight.png").getImage();
        }
        // sets location on board and screen depending on position
        this.x = position.getRow() * 90 + 20;
        this.y = position.getCol() * 90;
        this.row = position.getRow();
        this.col = position.getCol();
    }

    public void move(int row, int col, Board b) {
        // if the move is legal update the old position to null and update the row col x and y
        if(isLegalMove(b, super.getPosition(), row, col)) {
            super.getPosition().setP(null);
            b.getSquare(this.row, this.col).setP(null);
            this.row = row;
            this.col = col;
            this.x = row * 90 + 20;
            this.y = col * 90;
            b.getSquare(row, col).setP(this);
        }
    }

    public boolean isLegalMove(Board b, Square start, int row, int col) {
        boolean helper = false;
        // if the knight moves in an L shape it is a legal move
        if(((Math.abs(this.row - row) == 1) && Math.abs(this.col - col) == 2)) {
            helper = true;
        }
        else if(Math.abs(this.col - col) == 1 && Math.abs(this.row - row) == 2) {
            helper = true;
        }

        // if the destination of the piece already contains a piece of the same color the move cant be legal
        if(b.getSquare(row, col).getP() != null) {
            if (b.getSquare(row, col).getP().getColor() == super.getColor()) {
                return false;
            }
        }
        return helper;
    }


    public void setCol(int col) {
        this.col = col;
    }
    // draws the piece
    @Override
    public void draw(Graphics g, GameViewer G) {
        g.drawImage(image, y, x, 90, 90, G);
    }

}
