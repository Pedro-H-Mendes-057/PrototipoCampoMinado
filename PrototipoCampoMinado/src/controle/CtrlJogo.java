package controle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import modelo.UnderCampo;
import visual.Campo;

public class CtrlJogo{
	
	Campo campo;
	JButton[][] button;
	int[] bombas;
	int[][] matriz;
	
	public CtrlJogo(Campo campo, UnderCampo underCampo) {
		this.campo = campo;
		this.button = campo.getButton();
		bombas = underCampo.getBombas();
		matriz = underCampo.getMatriz();
		addListeners();
		plantarBombas();
		addNumeros();
		
	}

	public void addListeners() {
		for(int i = 0; i < campo.getOrdem(); i++) {
			for(int j = 0; j < campo.getOrdem(); j++) {
				button[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        /*if (SwingUtilities.isLeftMouseButton(e)) {
                            ((JButton) e.getSource()).setEnabled(false);
                        } else */if (SwingUtilities.isRightMouseButton(e)) {
                        	if(((JButton) e.getSource()).getText() == "Bandeira") {
                        		
                        		((JButton) e.getSource()).setText("");                        		                        		
                        		((JButton) e.getSource()).setEnabled(true);
                        		
                        	} else if(((JButton) e.getSource()).isEnabled()){
                        		
                        		((JButton) e.getSource()).setText("Bandeira");
                        		((JButton) e.getSource()).setEnabled(false);
                        		
                        	}
                        }
                    }
                });
			}
		}
	}
	
	private void plantarBombas() {
		for(int i = 0; i < bombas.length; i++) {
			
			int x = (bombas[i]/campo.getOrdem());
			int y = (bombas[i]%campo.getOrdem());
			button[x][y].removeMouseListener(null);
			button[x][y].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
                        ((JButton) e.getSource()).setText("X");
                    }
				}
			});
		}
		
	}
	
	private void addNumeros() {
		int ordem = campo.getOrdem();
		
		for(int i = 0; i < ordem; i++) {
			for(int j = 0; j < ordem; j++) {
				
				int countBombs = matriz[i][j];
				int x = i;
				int y = j;
				
				button[x][y].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						if(SwingUtilities.isLeftMouseButton(e)) {
							if(countBombs == 0) {
								((JButton) e.getSource()).setText("");
								((JButton) e.getSource()).setEnabled(false);;
								limpaEmVolta(x, y);
							} else if( countBombs == -1) {
								((JButton) e.getSource()).setText("X");
								((JButton) e.getSource()).setEnabled(false);
							} else {
								((JButton) e.getSource()).setText(Integer.toString(matriz[x][y]));								
								((JButton) e.getSource()).setEnabled(false);
							}
						}
					}
					
				});
				//TODO: verifica se ij bate com bomba no vetor
				//e se bater, pula; add um mouseListener no que não bater;
			}
		}
		
	}
	
	private void limpaEmVolta(int i, int j) {
		int ordem = campo.getOrdem();
		// TODO se for apertado um botão sem numero, limpar outros botões sem numero em volta;
		
		// Verifica se a célula está dentro dos limites e se já foi desabilitada
	    if (i < 0 || i >= ordem || j < 0 || j >= ordem || !button[i][j].isEnabled()) {
	        return;  // Ignora células fora do campo ou já clicadas
	    }

	    // Se a célula tem um número de bombas ao redor (de 1 a 8), mostra o número e desabilita o botão
	    if (matriz[i][j] > 0) {
	        button[i][j].setText(Integer.toString(matriz[i][j]));
	        button[i][j].setEnabled(false);
	        return;  // Não limpa mais as células ao redor
	    }

	    // Se a célula é vazia (0), limpa ela e chama a recursão para as células vizinhas
	    if(matriz[i][j] == 0) {
	    	button[i][j].setText("");  // Limpa a célula
	    	button[i][j].setEnabled(false);  // Desabilita a célula clicada
	    }
	    
	 // Chama recursão para as células vizinhas
	    for (int x = -1; x <= 1; x++) {
	        for (int y = -1; y <= 1; y++) {
	            // Não chama a própria célula
	        	
	            if (x == 0 && y == 0) {
	                continue;
	            }
	            
	            int nx = i + x;
	            int ny = j + y;
	            
	            if (nx >= 0 && nx < ordem && ny >= 0 && ny < ordem) {
	            	// Se a célula ao redor for vazia (0), chama a recursão
	                if (matriz[nx][ny] == 0) {
	                    limpaEmVolta(nx, ny);
	                }
	            }
	        }
	    }
	    
	}

}
