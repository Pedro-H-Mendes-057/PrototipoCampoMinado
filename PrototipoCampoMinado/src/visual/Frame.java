package visual;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	Header header;
	Campo campo;
	
	public Frame(Header header, Campo campo) {
		super();
		
		this.header = header;
		this.campo = campo;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		
		this.setTitle("Campo Minado - Protótipo");
		this.setSize(700, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//header = new Header();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 1;
		constraint.weighty = 0.25;
		this.add(header, constraint);
		
		//campo = new Campo();
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 1;
		constraint.weighty = 1;
		constraint.insets = new Insets(0, 100, 50, 100);
		this.add(campo, constraint);

		this.setVisible(true);
	}
	
}

