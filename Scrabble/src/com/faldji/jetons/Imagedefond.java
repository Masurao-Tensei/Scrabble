package com.faldji.jetons;

import javax.swing.ImageIcon;

public class Imagedefond {
	public Imagedefond() {
		
	}

	public ImageIcon imagefond(String s) {
		ImageIcon im = new ImageIcon("");
		switch (s) {
	case "A":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/A.png"))	;
	break;case "B":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/B.png"))	;	
	break;case "C":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/C.png"))	;
	break;case "D":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/D.png"))	;
	//break;case "E":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/E.png"))	;
	break;case "F":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/F.png"))	;	
	break;case "G":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/G.png"))	;
	break;case "H":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/H.png"))	;
	break;case "I":	im = new ImageIcon(getClass().getResource("/com/faldji/jetons/I.png"))	;	
	break;case "J":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/J.png"))	;
	break;case "K":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/K.png"))	;
	break;case "L":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/L.png"))	;
	break;case "M":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/M.png"))	;
	break;case "N":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/N.png"))	;
	break;case "O":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/O.png"))	;
	break;case "P":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/P.png"))	;
	break;case "Q":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/Q.png"))	;
	break;case "R":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/R.png"))	;
	break;case "S":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/S.png"))	;
	break;case "T":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/T.png"))	;
	break;case "U":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/U.png"))	;
	break;case "V":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/V.png"))	;
	break;case "W":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/W.png"))	;
	break;case "X":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/X.png"))	;
	break;case "Y":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/Y.png"))	;
	break;case "Z":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/Z.png"))	;
	break;case "_":im = new ImageIcon(getClass().getResource("/com/faldji/jetons/Joker.png"))	;
	}return im;
}
}
