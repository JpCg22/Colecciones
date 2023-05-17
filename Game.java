package tetris_game;

import tetris_game.objects.*;
import tetris_game.swing.*;
import tetris_game.swing.details.ButtonDisplay;
import tetris_game.swing.details.FuturePieceDisplay;
import tetris_game.swing.details.LabelDisplay;
import tetris_game.swing.details.VariablesDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Game {

     public static JFrame f;
     public final static int windowWidth = 840;
     public final static int windowLength = 800;


     public void frameDisplay(){

     }

     public void start(){

          Grid grid = new Grid();

          GameVariables var = new GameVariables();

          int speed = 350;


          

          f = new JFrame("Tetris Game");
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          f.setLayout(new GridLayout(1,2));

          f.setSize(windowWidth, windowLength);
          f.setBounds(100, 0, windowWidth, windowLength);

          f.getContentPane().setBackground(Color.DARK_GRAY);
          


       
          GameDisplay tabDisplay = new GameDisplay(); 
          tabDisplay.setGrid(grid);

          Actions keyActions = new Actions();  
          keyActions.setGrid(grid);

          FuturePieceDisplay futurePieces = new FuturePieceDisplay();
          

          LabelDisplay label = new LabelDisplay();
         


          StartGame game = new StartGame(f, futurePieces, label, tabDisplay, keyActions, grid, speed);

          ButtonDisplay button = new ButtonDisplay(game);

          button.setDisplay(keyActions);

          VariablesDisplay varDisplay = new VariablesDisplay();
          varDisplay.setDisplay(futurePieces, label, button);


          f.add(tabDisplay);

          f.addKeyListener(keyActions);

          f.add(varDisplay);

        
          f.setVisible(true);

          java.util.Timer timer = new java.util.Timer();

          TimerTask task = new GameTimer2(game);
          timer.schedule(task, 1000, 100);
     }

     public static void main (String[] args) {

          Game game = new Game();
          game.start();

     }
}
