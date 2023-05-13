import javax.swing.*;
import java.awt.*;

public class Queen extends Piece{
    private Image image;
    private int x,y,row,col;

    public Queen(Color c, Square position){
        // sends main info to super class
        super(c, position);
        // gets image depending on color
        if(c == Color.BLACK) {
            image = new ImageIcon("Images/blackqueen.png").getImage();
        }
        else if(c == Color.WHITE) {
            image = new ImageIcon("Images/whitequeen.png").getImage();
        }
        // sets location on board and screen depending on position
        this.y = position.getCol() * 90;
        this.x = position.getRow() * 90 + 20;
        this.col = position.getCol();
        this.row = position.getRow();

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
        // if the destination of the piece already contains a piece of the same color the move cant be legal
        boolean helper = false;
        if (b.getSquare(row, col).getP() != null) {
            if (b.getSquare(row, col).getP().getColor() == super.getColor()) {
                return false;
            }
        }
        // if going in only one direction its valid
        if(Math.abs(row - this.row) == Math.abs(col - this.col) || (this.row == row || this.col == col)) {
            helper = true;
        }
        // if moving diagonally its valid
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
        if(row > this.row && col > this.col) {
            int i = this.row;
            int j = this.col;
            while(i != row - 1 && j != col - 1) {
                i++;
                j++;
                if(b.getSquare(i, j).getP() != null) {
                    return false;
                }
            }
        }
        else if(row < this.row && col > this.col) {
            int i = this.row;
            int j = this.col;
            while(i != row + 1 && j != col - 1) {
                i--;
                j++;
                if(b.getSquare(i, j).getP() != null) {
                    return false;
                }
            }
        }
        else if(row > this.row && col < this.col) {
            int i = this.row;
            int j = this.col;
            while(i != row - 1 && j != col + 1) {
                i++;
                j--;
                if(b.getSquare(i, j).getP() != null) {
                    return false;
                }
            }
        }
        else if(row < this.row && col < this.col) {
            int i = this.row;
            int j = this.col;
            while(i != row + 1 && j != col + 1) {
                i--;
                j--;
                if(b.getSquare(i, j).getP() != null) {
                    return false;
                }
            }
        }
        return helper;
    }


    public void setRow(int row) {
        this.row = row;
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

