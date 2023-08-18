import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/* 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
*/

public class Ui extends JFrame {

    private MyPanel mainPanel;

    //start of programe
    public static void main(String[] args) {
        new Ui();

	}

    //start of everything else
    Ui(){
        //make window and drawing code
        mainPanel = new MyPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

        //initialize key input
		addKeyListener(new UserInput());
	}  

    //start of Panel/game loop
    public class MyPanel extends JPanel implements ActionListener {

        Image testSprite;
        int testSpriteX = 10;   
        int testSpriteY = 20;
        int testCountDraw = 0;
        int testCountLoop = 0;
        Timer GameLoop;
        //Image backgroundImage;
    
        //graphics start / game loop start
        MyPanel(){
            
            //start window and graphics
            this.setPreferredSize(new Dimension(GameSettings.WINDOW_WIDTH,GameSettings.WINDOW_HEIGHT));
            this.setBackground(Color.red);
            testSprite = new ImageIcon(GameSettings.TEST_SPRITE_FILE).getImage();
            System.out.println("Graphics Started ");

            //start game loop
            GameLoop = new Timer(GameSettings.UPDATE_GAME_LOOP_MS, this);
            GameLoop.start();
        }

        //draw code
        public void paint(Graphics g) {
            //System.out.println("Graphics drawing " + testCountDraw++);

            super.paint(g); // paint background
            Graphics2D g2D = (Graphics2D) g;
            //g2D.drawImage(backgroundImage, 0, 0, null);

            //draw test sprite
            g2D.drawImage(testSprite, testSpriteX, testSpriteY, null);
        }
    
        //main loop
        @Override public void actionPerformed(ActionEvent e) {
            
            //System.out.println("loop " + testCountLoop++);

            //redraw graphics
            repaint();
        }

    }
    //end of panel

}
