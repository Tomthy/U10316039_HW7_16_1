//package chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestImageIcon extends JFrame {

	Shuffle poker = new Shuffle();
	
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	
	JLabel pic1;
	JLabel pic2;
	JLabel pic3;
	JLabel pic4;
	
	private JButton jbtRefresh = new JButton("Refresh");
	
  public TestImageIcon() {
	pic1 = new JLabel(poker.poker1);
	pic2 = new JLabel(poker.poker2);
	pic3 = new JLabel(poker.poker3);
	pic4 = new JLabel(poker.poker4);
	
	
    panel.setLayout(new GridLayout(1, 4, 5, 5));
	panel.add(pic1);
	panel.add(pic2);
	panel.add(pic3);
	panel.add(pic4);
	
	panel2.add(jbtRefresh);
	
	this.add(panel, BorderLayout.CENTER);
	this.add(panel2, BorderLayout.SOUTH);
	
	jbtRefresh.addActionListener(new RefreshListener());	
  }
  
  class RefreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			poker.refresh();
			
			pic1.setIcon(poker.poker1);
			pic2.setIcon(poker.poker2);
			pic3.setIcon(poker.poker3);
			pic4.setIcon(poker.poker4);
		}
	}

  /** Main method */
  public static void main(String[] args) {
	TestImageIcon frame = new TestImageIcon();
	frame.setTitle("U10316039");
	frame.pack();
	frame.setLocationRelativeTo(null); // Center the frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}

	class Shuffle extends JButton{
		ImageIcon poker1;
		ImageIcon poker2;
		ImageIcon poker3;
		ImageIcon poker4;
		
		int[] deck = new int[52];
			
		public Shuffle(){
			refresh();
		}
		
		public void refresh(){
		
			// Initialize cards
			for (int i = 0; i < deck.length; i++)
				deck[i] = i+1;
    
			// Shuffle the cards
			for (int i = 0; i < deck.length; i++) {
				// Generate an index randomly
				int index = (int)(Math.random() * deck.length);
				int temp = deck[i];
				deck[i] = deck[index]; 
				deck[index] = temp;
			}

			poker1= new ImageIcon("card/" + deck[1]+".png");
			poker2= new ImageIcon("card/" + deck[2]+".png");
			poker3= new ImageIcon("card/" + deck[3]+".png");
			poker4= new ImageIcon("card/" + deck[4]+".png");

		}
	}
}
