package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Campo extends JPanel{
	
	private int ordem = 5;
	
	private JButton[][] button = new JButton[ordem][ordem];
	
	public Campo() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.darkGray);
		GridBagConstraints constraints = new GridBagConstraints();
		
		Dimension tamanhoBotao = new Dimension(1, 1);
		
		for(int i = 0; i < ordem; i++) {
			for(int j = 0; j < ordem; j++) {
				button[i][j] = new JButton();
				button[i][j].setMargin(new java.awt.Insets(0, 0, 0, 0));
				button[i][j].setPreferredSize(tamanhoBotao);
				//piso[i].setVisible(false);
				//piso[i][j].setText("" + (ordem * i + j));
			}
		}
		
		for(int i = 0; i < ordem; i++) {
			for(int j = 0; j < ordem; j++) {
				constraints.gridx = j;
				constraints.gridy = i;
				constraints.fill = GridBagConstraints.BOTH;
				constraints.weightx = 1;
				constraints.weighty = 1;
				this.add(button[i][j], constraints);
			}
		}
		
		this.repaint();
		this.revalidate();
		
		this.setVisible(true);
	}
	
	public int getOrdem() {
		return ordem;
	}
	
	public JButton[][] getButton() {
		return button;
	}
}
