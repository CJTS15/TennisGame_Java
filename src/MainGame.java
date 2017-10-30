

/*Class Name: MainGame
 * 
 * This is where all the interaction takes place. The MainGame consists of the frame of our 
 * game. We did some little research on how this Java Syntaxes works as one.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.RenderingHints;


public class MainGame extends JPanel {
  
 /*calling the class Ball and TennisBar
  */
 Ball ball = new Ball(this);
 TennisBar tennisbar = new TennisBar(this);
 int speed = 3;
 int speed1 = 4;

 private int getScore() {
  return speed - 3;
 }
 
  private int getScore1() {
  return speed1 - 4;
 }
  
  /*we did some research on how this things work, importing from the library the keyEvent
   * and the keyListener, this is where the interaction of the racket in the class TennisBar follows.
   */
 public MainGame() {
  addKeyListener(new KeyListener() {
   @Override
   public void keyTyped(KeyEvent e) {
    
   }
   @Override
   public void keyReleased(KeyEvent e){
    tennisbar.keyReleased(e);
    }
   @Override
   public void keyPressed(KeyEvent e) {
    tennisbar.keyPressed(e);
    }
   });
  setFocusable(true);//allows to receive focus
  }
    
 private void move(){
  ball.move();
  tennisbar.move();
  }
    
    /*this is where we draw the court and all of the graphics found in the game.
     * (non-Javadoc)
     * @see javax.swing.JComponent#paint(java.awt.Graphics)
     */
 @Override
 public void paint(Graphics graph){
  super.paint(graph);
  Graphics2D graph2d = (Graphics2D) graph;
  graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  ball.paint(graph2d);
  tennisbar.paint(graph2d);
  
  
  /*
   * Mga Pa char2 rni dri dpita
   * 
   */
  graph2d.drawLine(450, 26, 450, 900);//court
  graph2d.drawLine(0, 25, 900, 25);
 // graph2d.drawLine(75, 00, 75, 25);
  graph2d.drawString( "Game",15,20);
  graph2d.drawRect(0,0,75,25);
  graph2d.drawString("Help",100,20 );
  graph2d.drawRect(75,0,75,25);
  
 graph2d.drawString("<<<<<< Sample rni sya sa menu bar ",175 , 20);// samok2
//  graph2d.drawString("0", 425, 50);// layout sa scoreboard
//  graph2d.drawString("0",475 , 50);// layout sa scoreboard
  graph2d.drawString("<<<<<< OK na ang Scoring ntu ",510 , 50);// samok2
//  graph2d.drawString("tas naa ptay problema sa tabulation hahah >>>>>",610 , 210);// samok2
  graph2d.drawOval(330, 180, 250,250);
  
  
  /*
   * Scoring sa game
   */
  
  graph2d.setColor(Color.GRAY);
  graph2d.setFont(new Font("Verdana", Font.BOLD, 30));
  graph2d.drawString(String.valueOf(getScore()), 410, 50);
  graph2d.drawString(String.valueOf(getScore1()), 475, 50);
  
  
  }
 
 /*the main of our game  
  */
 public static void main(String [] args) throws InterruptedException {
  JFrame gameFrame = new JFrame("Galaxy Tennis 2D");
  MainGame game = new MainGame();
  gameFrame.add(game);
  gameFrame.setSize(900, 600);
  gameFrame.setVisible(true);
  gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
  while(true){
   game.move();//calling the function move for the ball.
   game.repaint();//the function repaint enables the ball to move, every update in x and
                        // y position, it repaints itself to make it smooth in moving.
      /*
       * "Thread.sleep(10)" it tells the processor that the thread which is 
       *  being run must sleep for 10 milliseconds, which allows the processor to execute
       *  other threads and in particular the AWT-EventQueue thread which calls the paint method.
       *  Source:http://www.edu4java.com/
       */
   Thread.sleep(10); 
    }
  }

 }
