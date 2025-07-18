package visual;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel{
	
	JLabel texto;
	//JLabel count;
	
	public Header() {
		this.setLayout(new GridBagLayout());
		//this.setBackground(Color.green);
		
		texto = new JLabel("Campo Minado");
		texto.setFont(new Font("Papyrus", Font.BOLD, 50));
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;  // Coluna 0
        constraints.gridy = 0;  // Linha 0
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.anchor = GridBagConstraints.CENTER;  // Alinha o componente no centro do grid
        
        // Adicionando o JLabel ao painel
        this.add(texto, constraints);
        
        /*count = new JLabel("Bombas restantes: " + "x");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.EAST;
        
        this.add(count, constraints);
		*/
        this.setVisible(true);
	}
	
}
