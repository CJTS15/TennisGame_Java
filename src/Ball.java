
/*
 * Class Name: Ball
 * 
 * This is where the moving of the ball, the interaction of the ball and the racket,
 * the collision. 
 */
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
//import java.awt.RenderingHints;



public class Ball extends JPanel {
   int SpeedL;
   int SpeedR;
     int PrivateY = 300;
     //private static final int PrivateAx = 2;
     //private static final int PrivateAy = 2;
    
    
  public static final int DIAM = 25;//setting the diameter to constant
  int x =  450;
  int y = 300;
  int ax = 2;
  int ay = 2;
  private MainGame game;
  //private TennisBar tennisbar;
  
  public Ball(MainGame game){
   this.game = game;
    //this.tennisbar = bar;
  }
  
  /*this is where the ball moves and updates
   * 
   */
  void move() {
  boolean changeDirection = true; 
  boolean changeDirection1 = true; 
  
  x = x + 1;
  y = y + 1;
  
  if (collision()){                        // << bouncing effect sa ball( >> LEFT SIDE << )
  SpeedL =  (1 + game.speed);
    ax = SpeedL++;
   x = game.tennisbar.getTopX() - DIAM;
   
   
  } else 
    changeDirection = false;
  
  
   if (collision1()){                        // << bouncing effect sa ball( >> RIGHT SIDE << )
  SpeedR = 1 * (1 - game.speed1);
    ax = SpeedR--;
   x = game.tennisbar.getTopX1() - DIAM;
  
  } else 
    changeDirection1 = false;
    

  
  if (x + ax < 0){
	  ax = game.speed / 3;                                       // <<<<<<<<<<<<  left side boundary sa x
	  game.speed1++;
  }
  else if (x + ax > game.getWidth() - DIAM){
	  ax = -(game.speed / 3);                                     // <<<<<<<<<<   right side  boundary sa x
	  game.speed++;
  }
  else if (y + ay < 30){
  ay = game.speed  ;    
  }// <<<<<<<<<<<<  upper side boundary sa y
  else if (y + ay > game.getHeight() - DIAM){
  ay = -game.speed ;                         // <<<<<<<<<<<   lower side boundary sa y
  }
 
  
   
  x = x + ax;
  y = y + ay;
 }

  
  private boolean collision() {
   return game.tennisbar.getBounds().intersects(getBounds());
   }
  private boolean collision1(){
   return game.tennisbar.getBounds1().intersects(getBounds1());
   }
  public void paint(Graphics2D tennisBall){
    //super.paint(tennisBall);
    //Graphics2D tennisBall2D = (Graphics2D) tennisBall;
    //tennisBall2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    tennisBall.fillOval(x, y, DIAM, DIAM);
   // tennisBall.fillOval(x-1, y-2, DIAM, DIAM);
   
  //  tennisBall.fillOval(x+2, y+3, DIAM, DIAM);
    }
  public Rectangle getBounds() {
   return new Rectangle(x, y, DIAM, DIAM );
  //return new Rectangle(840,y , 25,90 );
   }
  public Rectangle getBounds1(){
   return new Rectangle(x, y, DIAM, DIAM );
   }
  }