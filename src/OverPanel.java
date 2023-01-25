import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OverPanel extends JLabel{

	OverPanel(){
		this.setSize(630, 630);
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
		this.setFont(new Font("Verdana",1,60));
	}
	public void playerX() {
		this.setText("Player X WIN!");
	}
	public void playerO() {
		this.setText("Player O WIN!");
	}
}
