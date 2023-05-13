import javax.swing.*;
import java.awt.*;

public class Pawn extends Piece {
    private boolean starterSquare;
    private Image image;
    private int x,y,row,col;
    public Pawn(Color c, Square position){
        // sends main info to super class
        super(c, position);
        // gets image depending on color
        if(c == Color.BLACK) {
            image = new ImageIcon("Images/blackpawn.png").getImage();
        }
        else if(c == Color.WHITE) {
            image = new ImageIcon("Images/whitepawn.png").getImage();
        }
        // sets location on board and screen depending on position
        starterSquare = true;
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
            this.col = col;
            this.row = row;
            this.x = row * 90 + 20;
            this.y = col * 90;
            b.getSquare(row, col).setP(this);
            super.setPosition(row, col);
        }
    }

    public boolean isLegalMove(Board b, Square start, int row, int col) {
        boolean helper = false;
        // checks to see if pawn is on first square
        if(starterSquare) {
            // if the pawn is moving two forwards
            if(Math.abs(this.row - row) == 2) {
                if(Math.abs(this.col - col) == 0) {
                        // if the square isn't empty return false else set helper to true
                        if(b.getSquare(row, col).getP() != null) {
                                starterSquare = true;
                                return false;
                        }
                        else {
                            helper = true;
                            starterSquare = false;
                        }
                }
            }
            // if only moving 1 square foward from the starter square and going diagonal it must be talking a piece
            else if(Math.abs(this.row - row) == 1) {
                if (Math.abs(this.col - col) == 1 && b.getSquare(row, col).getP() != null) {
                    if(b.getSquare(row, col).getP().getColor() != super.getColor())
                        helper = true;
                        starterSquare = false;
                }
                // if not going diagonal and only going one forward that square must be empty
                else if(Math.abs(this.col - col) == 0){
                    if(b.getSquare(row, col).getP() != null) {
                        if(b.getSquare(row, col).getP().getColor() != super.getColor()) {
                            starterSquare = true;
                            return false;
                        }
                    }
                    else {
                        helper = true;
                        starterSquare = false;
                    }
                }
            }
        }
        // if not on the starter square, if only going forward make sure there is no piece in the end square
        else if((Math.abs(this.col - col) == 0 && Math.abs(this.row - row) == 1)) {
            if(b.getSquare(row, col).getP() != null) {
                    return false;
            }
            else {
                helper = true;
            }
        }
        // if going diagonal make sure it is taking a piece of the other color
        else if(Math.abs(this.col - col) == 1 && Math.abs(this.row - row) == 1 &&  b.getSquare(row, col).getP() != null)
        {
            if(b.getSquare(row, col).getP().getColor() != super.getColor()) {
                helper = true;
            }
        }

        // if the destination of the piece already contains a piece of the same color the move cant be legal
        if(b.getSquare(row, col).getP() != null) {
            if (b.getSquare(row, col).getP().getColor() == super.getColor()) {
                return false;
            }
        }
        // make sure pawn is moving forward
        if(super.getColor() == Color.BLACK) {
            if(this.row > row) {
                return false;
            }
        }
        else if(this.row < row) {
            return false;
        }

        return(helper);
    }


    public void setCol(int col) {
        this.col = col;
    }
    @Override
    public void draw(Graphics g, GameViewer G) {
            g.drawImage(image, y, x, 90, 90, G);
    }
}
