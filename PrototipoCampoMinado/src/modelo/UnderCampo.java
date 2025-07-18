package modelo;

import java.util.Random;

public class UnderCampo {
	
	private int[] bombas;
	private int[][] matriz;
	private Random rand = new Random();
	private int ordem;
	
	public UnderCampo(int ordem) {
		
		this.ordem = ordem;
		this.matriz = new int[ordem][ordem];
		bombas = new int[ordem];
		int[] jaForam = new int[ordem];
		int numBombas = 0;
		int sorteado;
		
		while(numBombas < bombas.length) {
			sorteado = rand.nextInt(ordem * ordem);
			boolean repetiu = false;
			
			for(int i = 0; i < numBombas; i++) {
				if(sorteado == jaForam[i]) {
					repetiu = true;
					break;
				}
			}
			
			if(!repetiu) {
				bombas[numBombas] = sorteado;
				jaForam[numBombas] = sorteado;
				numBombas++;
			}
			
		}
		
		for(int i = 0; i < bombas.length; i++) {
			System.out.println(bombas[i]);
		}
		
		formaMatriz();
		//mostraMatriz();
		
	}
	
	private void formaMatriz() {
		//matriz = new int[ordem][ordem];
		/*
		for(int i = 0; i < ordem; i++) {
			for(int j = 0; j < ordem; j++) {
				
				if( ((i * ordem) + j) == bombas[j]) {
					matriz[i][j] = -1;
				} else {
					matriz[i][j] = 0;
				}
			}
		}*/
		for (int i = 0; i < ordem; i++) {
	        for (int j = 0; j < ordem; j++) {
	            matriz[i][j] = 0;
	        }
	    }
		
		for (int i = 0; i < bombas.length; i++) {
	        int x = bombas[i] / ordem;  // linha
	        int y = bombas[i] % ordem;  // coluna
	        matriz[x][y] = -1; // Marca como bomba
	    }
		
		for(int i = 0; i < ordem; i++) {
			for(int j = 0; j < ordem; j++) {
				if(matriz[i][j] != -1) {
					matriz[i][j] = contarBombas(i, j);
				}
			}
		}
		
	}

	private int contarBombas(int i, int j) {
		int countBombs = 0;
		
		for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                // Ignora a própria célula
                if (x == 0 && y == 0) {
                    continue;
                } else {
                	int nx = i + x;
                	int ny = j + y;
                	
                	// Verifica se as coordenadas estão dentro dos limites da matriz
                	if (nx >= 0 && nx < ordem && ny >= 0 && ny < ordem) {
                		if (matriz[nx][ny] == -1) {
                			countBombs++;
                		}
                	}
                }
                
            }
        }
        
        return countBombs;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public int[] getBombas() {
		return bombas;
	}
	
	public void mostraMatriz() {
		for(int i = 0; i < ordem; i++) {
			for(int j = 0; j < ordem; j++) {
				System.out.print(matriz[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	//dividido por ordem = linha (gridy) && resto por ordem = coluna (gridx)

}
