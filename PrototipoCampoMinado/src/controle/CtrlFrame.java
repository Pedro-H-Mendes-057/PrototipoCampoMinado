package controle;

import modelo.UnderCampo;
import visual.Campo;
import visual.Frame;
import visual.Header;

public class CtrlFrame {
	
	Frame frame;
	Header header;
	Campo campo;
	CtrlJogo jogo;
	UnderCampo underCampo;
	
	public CtrlFrame() {
		campo = new Campo();
		underCampo = new UnderCampo(campo.getOrdem());
		header = new Header();
		frame = new Frame(header, campo);
		jogo = new CtrlJogo(campo,underCampo);
	}
	

	public static void main(String args[]) {
		new CtrlFrame();
	}

}
