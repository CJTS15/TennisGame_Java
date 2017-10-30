
/*Class Name: TennisBar
 * 
 * This is where we put our codes for the racket and its interaction throughout 
 * the game. Most of the codes are based from the net, and some are based on our learnings
 * but we did not copy all of the codes in the net.
 * We did some research and we come up with this output.
 */
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Rectangle;

public class TennisBar extends JPanel{
  /*we set the variables x, x1, width and height to be constant or in java
   *final to be safe from conflicts. that's how we understand the use of private in our game.
   *width and height are the parameters for the racket.
   **/ 
 private static final int x = 0;
 private static final int x1 = 860;
 private static final int WIDTH = 25;
 private static final int HEIGHT = 90;
 int ypos = 250; //ypos is the position of the players racket.
    int ypos1 = 250;//ypos1 is also the position of the players racket.
    int aypos = 0; //aypos is where the position of the racket be updated when moving starting at 0.
    int aypos1 = 0;//aypos1 is also where the position of the racket be updated when moving starting at 0.
    private MainGame game;
  
  /*calling the MainGame game class here, to help us make the code more easier, calling class
   * methods which can also be used in the main. 
   * */
    public TennisBar(MainGame game){
     this.game = game;
  }
  /*public TennisBar(float xpos, float ypos, float aypos, float width, float height){
    xpos = 15;
    ypos = 0;
    aypos = 0;
    width = 25;
    height = 90;
  }*/
  
  /*moving the tennisbar, here is the code.
   * it is where the racket is updated in moving
   */
    public void move(){
     if ( ypos + aypos > 25 && ypos + aypos < game.getHeight()-90)
      ypos = ypos + aypos;
     if ( ypos1 + aypos1 > 25 && ypos1 + aypos1 < game.getHeight()-90)
      ypos1 = ypos1 + aypos1;
     }
  /*it is where we draw the racket, we use the java library Graphics2D
   * to enable us to draw the racket and also with the ball.
   */
    public void paint(Graphics2D tennisBar){
     Graphics2D tennisBar2d = (Graphics2D) tennisBar;
    //tennisBar2d.setColor(Color.BLACK);
     tennisBar2d.fillRoundRect(x, ypos, WIDTH, HEIGHT, 20, 20);
     tennisBar2d.fillRoundRect(x1, ypos1, WIDTH, HEIGHT, 20, 20);
    }
  /*it is where the keyEvent library in java is used. when the key is released the position
   *of the racket turns to 0, then will be updated when the key is pressed. 
   */
    public void keyReleased(KeyEvent e){
     aypos = 0;
     aypos1 = 0;
     }
  
  /*interaction of our racket, where we used the keyPressed, which is similar to Processing.
   */
    public void keyPressed(KeyEvent e){ //VK means Virtual Key
     if(e.getKeyCode() == KeyEvent.VK_W  )//keys for player 2
      aypos = -10;
     if(e.getKeyCode() == KeyEvent.VK_S)//keys for player 2
      aypos = 10;
     if(e.getKeyCode() == KeyEvent.VK_UP)//keys for player1
      aypos1 = -10;
     if(e.getKeyCode() == KeyEvent.VK_DOWN)//keys for player1
      aypos1 = 10;
     }
  
  /*we just learned this line codes from the net, this is for the interaction between the racket
   * and the ball.
   * (non-Javadoc)
   * @see java.awt.Component#getBounds()
   */
    public Rectangle getBounds() {
     return new Rectangle(x, ypos, WIDTH, HEIGHT);
     }
    public Rectangle getBounds1() {
     return new Rectangle(x1, ypos1, WIDTH, HEIGHT);
     }
    public int getTopX() {
     return  50 ;
     }
    public int getTopX1(){
     return x1;
     }
    }
//---------------END-----------------//