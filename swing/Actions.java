package tetris_game.swing;

import tetris_game.objects.GamePieces;
import tetris_game.objects.Grid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Actions implements KeyListener {

    GamePieces piece;
    Grid grid;

    public void setGrid(Grid grid){
        this.grid = grid;
    }

    public void setPiece(GamePieces piece){
        this.piece = piece;
    }

    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && piece != null) {
            
            piece.right(grid);

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && piece != null) {
            System.out.println("key left");
            piece.left(grid);
            
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && piece != null) {
            System.out.println("key down");
            piece.fall();
           
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && piece != null) {
            System.out.println("key up");
            piece.rotate();
            
        }
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public void keyTyped(KeyEvent e) {
    }
}
