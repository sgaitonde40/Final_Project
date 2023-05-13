import javax.swing.*;
import java.awt.*;

public class Rook extends Piece{
    private Image image;
    private int x,y,row,col;
    public Rook(Color c, Square position){
        // sends main info to super class
        super(c, position);
        // gets image depending on color
        if(c == Color.BLACK) {
            image = new ImageIcon("Images/blackrook.png").getImage();
        }
        else if(c == Color.WHITE) {
            image = new ImageIcon("Images/whiterook.png").getImage();
        }
        // sets location on board and screen depending on position
        this.x = position.getRow() * 90 + 20;
        this.y = position.getCol() * 90;
        this.row = position.getRow();
        this.col = position.getCol();
    }
    public void move(int row, int col, Board b) {
        if(isLegalMove(b, super.getPosition(), row, col)) {
            // if the move is legal update the old position to null and update the row col x and y
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
        // if the destination of the piece already contains a piece of the same color the move cant be legal
        boolean helper = true;
        if(b.getSquare(row, col).getP() != null) {
            if (b.getSquare(row, col).getP().getColor() == super.getColor()) {
                helper = false;
            }
        }
        // makes sure piece is only going straight and in one direction
        if(this.row == row) {
            if(this.col < col) {
                for(int i = this.col + 1; i < col; i++) {
                    if(b.getSquare(row, i).getP() != null) {
                            return false;
                    }
                }
            }
            else {
                for(int i = col + 1; i < this.col; i++) {
                    if(b.getSquare(row, i).getP() != null) {
                            return false;
                    }
                }
            }
        }
        else if(this.col == col) {
            if(this.row < row) {
                for(int i = this.row + 1; i < row; i++) {
                    if(b.getSquare(i, col).getP() != null) {
                            return false;
                    }
                }
            }
            else {
                for(int i = row + 1; i < this.row; i++) {
                    if(b.getSquare(i, col).getP() != null) {
                            return false;
                    }
                }
            }
        }
        return((this.row == row || this.col == col) && helper);
    }

    // draws piece
    @Override
    public void draw(Graphics g, GameViewer G) {
        g.drawImage(image, y, x, 90, 90, G);
    }
}
