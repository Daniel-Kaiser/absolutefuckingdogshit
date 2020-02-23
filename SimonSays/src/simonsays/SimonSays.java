package simonsays;
import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SimonSays {
int highscore = 0;
int currentScore = 0;
String sequence = "";
    static GraphicsConfiguration gc;
	SimonSays(){
                
		JFrame f=new JFrame("Button Example");
		JButton startButton=new JButton("Play");
                JButton redButton=new JButton();
                JButton yellowButton=new JButton();
                JButton greenButton=new JButton();
                JButton blueButton=new JButton();
		startButton.setBounds(225,300,200,50);
                redButton.setBounds(50, 50, 250, 250);
                redButton.setBackground(Color.red);
                yellowButton.setBounds(350, 50, 250, 250);
                yellowButton.setBackground(Color.yellow);
                greenButton.setBounds(50, 350, 250, 250);
                greenButton.setBackground(Color.green);
                blueButton.setBounds(350, 350, 250, 250);
                blueButton.setBackground(Color.blue);
                redButton.setVisible(false);
                yellowButton.setVisible(false);
                greenButton.setVisible(false);
                blueButton.setVisible(false);
                
                
		f.add(startButton);
                f.add(redButton);
                f.add(yellowButton);
                f.add(greenButton);
                f.add(blueButton);
		f.setBounds(0, 0, 700, 700);
                f.setTitle("Simon Says");
                Container c = f.getContentPane();
                c.setBackground(Color.black);
                f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                                
                startButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent arg0){
                        startButton.setVisible(false);
                        redButton.setVisible(true);
                        yellowButton.setVisible(true);
                        greenButton.setVisible(true);
                        blueButton.setVisible(true);
                        playTheGame();
                        
                        redButton.setBackground(new java.awt.Color(255,128,128));
                        System.out.println("Timer start");
                        Timer timer = new Timer(1000000, this);
                        timer.setRepeats(false);
                        timer.start();
                        System.out.println("Timer end");
                        redButton.setBackground(Color.red);
                    }
                });
                
                redButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent arg0){
                        increaseScore(1);
                        System.out.println(currentScore);
                    }
                });
                
                yellowButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent arg0){
                        increaseScore(2);
                        System.out.println(currentScore);
                    }
                });
                
                greenButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent arg0){
                        increaseScore(3);
                        System.out.println(currentScore);
                    }
                });
                
                blueButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent arg0){
                        increaseScore(4);
                        System.out.println(currentScore);
                    }
                });
                
		}     
		public static void main(String[] args) {    
                    SimonSays simonSays = new SimonSays();
                    Score score = new Score();
		}
                int increaseScore (int i){
                    currentScore+= i;
                    return currentScore;
                }
                void playTheGame (){
                    sequence+= (int)(Math.random()*4 + 1);
                    System.out.println(sequence);
                    
                }
}