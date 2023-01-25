import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	static final int GAME_WIDHT = 630;
	static final int GAME_HIEGHT = 630;
	static final int QUANTITY_OF_FIELDS= 9;
	static final int BUTTON_WIDHT = (int)(GAME_WIDHT/QUANTITY_OF_FIELDS);
	static final int BUTTON_HIEGHT = (int)(GAME_HIEGHT/QUANTITY_OF_FIELDS);
	
	JButton[] fields = new JButton[9];
	Font myFont = new Font("Ink Free",Font.BOLD,150);
	String [] sequence = {"X","O"};
	String player = sequence[0];
	
	GamePanel(){
		this.setPreferredSize(new Dimension(GAME_WIDHT,GAME_HIEGHT));
		this.setBackground(Color.white);
		//this.setFocusable(true);
		this.setLayout(new GridLayout(3,3,5,5));
		
		for(int i= 0;i<QUANTITY_OF_FIELDS;i++) {
			fields[i] = new JButton();
			fields[i].addActionListener(this);
			fields[i].setFont(myFont);
			//fields[i].setFocusable(false);
		}
		for (int i = 0; i < fields.length; i++) {
			this.add(fields[i]);
		}
		
	
		
	}
	
	public void xWin() {
		this.removeAll();
		OverPanel panel1 = new OverPanel();
		this.add(panel1);
		panel1.playerX();
	}
	public void oWin() {
		this.removeAll();
		OverPanel panel1 = new OverPanel();
		this.add(panel1);
		panel1.playerO();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0;i<QUANTITY_OF_FIELDS;i++) {
			if(e.getSource()== fields[i]) {
				if (player == "X") {
					if(fields[i].getText()=="") {
					fields[i].setText(player);
					player = sequence[1];
					}
				}
				else {
					if(fields[i].getText()=="") {
						fields[i].setText(player);
						System.out.println();
						player = sequence[0];
						}
				}
			
				
			}
		}
		if(		(fields[0].getText()=="X"&&fields[1].getText()=="X"&& fields[2].getText()=="X") ||
				(fields[3].getText()=="X"&&fields[4].getText()=="X"&& fields[5].getText()=="X")||
				(fields[6].getText()=="X"&&fields[7].getText()=="X"&& fields[8].getText()=="X")|| 
				(fields[0].getText()=="X"&&fields[3].getText()=="X"&& fields[6].getText()=="X")||
				(fields[1].getText()=="X"&&fields[4].getText()=="X"&& fields[7].getText()=="X")||
				(fields[2].getText()=="X"&&fields[5].getText()=="X"&& fields[8].getText()=="X")||
				(fields[0].getText()=="X"&&fields[4].getText()=="X"&& fields[8].getText()=="X")||
				(fields[2].getText()=="X"&&fields[4].getText()=="X"&& fields[6].getText()=="X")) 
			xWin();
		if(		(fields[0].getText()=="O"&&fields[1].getText()=="O"&& fields[2].getText()=="O")||
				(fields[3].getText()=="O"&&fields[4].getText()=="O"&& fields[5].getText()=="O")||
				(fields[6].getText()=="O"&&fields[7].getText()=="O"&& fields[8].getText()=="O")|| 
				(fields[0].getText()=="O"&&fields[3].getText()=="O"&& fields[6].getText()=="O")||
				(fields[1].getText()=="O"&&fields[4].getText()=="O"&& fields[7].getText()=="O")||
				(fields[2].getText()=="O"&&fields[5].getText()=="O"&& fields[8].getText()=="O")||
				(fields[0].getText()=="O"&&fields[4].getText()=="O"&& fields[8].getText()=="O")||
				(fields[2].getText()=="O"&&fields[4].getText()=="O"&& fields[6].getText()=="O")) 
			oWin();
			
		
	}
}

