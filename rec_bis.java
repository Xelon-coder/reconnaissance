import java.io.*; 
import java.awt.*; 
import javax.imageio.ImageIO; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;

public class rec_bis {

	public static void cinq_chiffres(int tab[][], int tabVal[], int max_i){
		int un[][] = creerTab(tab, max_i, tabVal[0], tabVal[1]);
		racTab(un, max_i, tabVal[1]-tabVal[0]);
		int deux[][] = creerTab(tab, max_i, tabVal[2], tabVal[3]);
		racTab(deux, max_i, tabVal[3]-tabVal[2]);
		int trois[][] = creerTab(tab, max_i, tabVal[4], tabVal[5]);
		racTab(trois, max_i, tabVal[5]-tabVal[4]);
		int quatre[][] = creerTab(tab, max_i, tabVal[6], tabVal[7]);
		racTab(quatre, max_i, tabVal[7]-tabVal[6]);
		int cinq[][] = creerTab(tab, max_i, tabVal[8], tabVal[9]);
		racTab(cinq, max_i,tabVal[9]-tabVal[8]);
	}
	public static void six_chiffres(int tab[][],int tabVal[],int max_i){
			int un[][] = creerTab(tab, max_i, tabVal[0], tabVal[1]);
			racTab(un, max_i, tabVal[1]-tabVal[0]);
			int deux[][] = creerTab(tab, max_i, tabVal[2], tabVal[3]);
			racTab(deux, max_i, tabVal[3]-tabVal[2]);
			int trois[][] = creerTab(tab, max_i, tabVal[4], tabVal[5]);
			racTab(trois, max_i, tabVal[5]-tabVal[4]);
			int quatre[][] = creerTab(tab, max_i, tabVal[6], tabVal[7]);
			racTab(quatre, max_i, tabVal[7]-tabVal[6]);
			int cinq[][] = creerTab(tab, max_i, tabVal[8], tabVal[9]);
			racTab(cinq, max_i,tabVal[9]-tabVal[8]);
			int six[][] = creerTab(tab, max_i, tabVal[10], tabVal[11]);
			racTab(six, max_i, tabVal[11]-tabVal[10]);
	}	
	public static int[][] creerTab(int tab[][], int max_i, int min_j, int max_j){
		int tabSortie[][] = new int[max_i][max_j-min_j+1];
		int k = 0;
		for (int i=0; i<max_i; i++) {
			for (int j=min_j; j<max_j; j++) {
				tabSortie[i][k] = tab[i][j];
				k++;
			}
			k=0;
		}
		return tabSortie;
	}
	public static void racTab(int tab[][], int max_i, int max_j) {
		int enleve = 0;
		boolean isGood = true; 
		int max_i_bas = 0;
		int max_i_haut = 0;
		int new_i = 0;
		for (int i=0; i<max_i; i++) {
			for (int j=0; j<max_j; j++) {
				if (tab[i][j] == 1) enleve++;
			}
			if (enleve == max_j) tab[i][0] = 3;
			enleve = 0;
		}
	//	affiche(tab, max_i, max_j);
		for (int i=0; i<max_i; i++) {
			if (tab[i][0] == 1 && isGood) {
				max_i_haut = i;
				isGood = false;
			}
			if (i!=max_i-1 && (tab[i][0] == 0 || tab[i][0] == 1) && tab[i+1][0] == 3) max_i_bas = i;
		}
		System.out.println("max_i_bas " + max_i_bas + " max_i_haut " +max_i_haut);
		if (max_i_bas > max_i_haut) new_i = max_i_bas-max_i_haut;
		if (max_i_bas == 0) new_i = max_i-max_i_haut;
		int tabSortie[][] = new int[new_i][max_j];
		enleve = 0;
		if (max_i_bas > max_i_haut) {
			for (int i=max_i_haut; i<max_i_bas; i++) {
				for (int j=0; j<max_j; j++) {
					tabSortie[enleve][j] = tab[i][j];
					System.out.print(tabSortie[enleve][j]);
				}
				enleve++;
				System.out.println(" ");
			}
		}
		else {
			System.out.println(max_i-max_i_haut);
			for (int i=max_i_haut; i<max_i; i++) {
				for (int j=0; j<max_j; j++) {
					tabSortie[enleve][j] = tab[i][j];
					System.out.print(tabSortie[enleve][j]);
				}
				enleve++;
				System.out.println(" ");
			}
		}
	}
	
	public static void affiche(int tab[][], int max_i, int max_j) {
		for (int i=0; i<max_i; i++) {
			for (int j=0; j<max_j; j++) {
				System.out.print(tab[i][j]);
			}
			System.out.println(" " + i);
		}
	}
	
	public static void main (String[] args) throws IOException{
		
		File file= new File("imagetest.jpg");   
	    BufferedImage image = ImageIO.read(file);
	    
	    boolean isGood = true;
		int p = 0; int min_i = 0;int min_j = 0;int max_i = 0;int max_j = 0;int Long = 640;int Larg = 480;	
		int coos_i[] = new int[Larg];int coos_j[] = new int[Long];
		int redTab[][] = new int [Larg][Long];int blueTab[][] = new int [Larg][Long];int greenTab[][] = new int [Larg][Long];
		int redTab_2[][] = new int [Larg][Long];
		for (int i=0; i<Larg; i++) {
			for (int j=0; j<Long; j++) {
				int color = ((BufferedImage) image).getRGB(j, i);
				int red = (color & 0x00ff0000) >> 16;
				int green = (color & 0x0000ff00) >> 8; // 250 = 0xfa
				int blue = (color & 0x000000ff);
			    redTab [i][j] = red;
			    blueTab [i][j] = blue;
			    greenTab [i][j] = green;
			    coos_i[i] = i;
			    coos_j[j] = j;
			}
		}
		for (int i=0; i<Larg; i++) {
			for (int j=0; j<Long; j++) {
				if (redTab[i][j] < 254 && blueTab[i][j] < 250 && greenTab[i][j] < 250) {
					redTab_2[i][j] = 1;
				}
				else if (redTab[i][j] > 250 && blueTab[i][j] > 250 && greenTab[i][j] > 250) {
					if (isGood) {
						min_i = coos_i[i];
						min_j = coos_j[j-70];
					}
					redTab_2[i][j] = 0;
					isGood = false;
					max_i = i;
					max_j = j+70;
				}
				
			}
		}
		int maxi_j = 0;
		isGood = true;
		int k = 0;
		int l = 0;
		int tabSortie[][] = new int [Larg][Long];
		int var_max_i = 0;
		for (int i=min_i; i<max_i; i++) {
			for (int j=min_j; j<max_j ; j++) {
				tabSortie[l][k] = redTab_2[i][j];
	//			System.out.print(tabSortie[l][k]);
				k++;
			}
			maxi_j = k;
	//  	System.out.println();
			k=0;
			l++;
		}
		for (int i=0; i<l+1; i++) {
			for (int j=0; j<maxi_j+1; j++) {
				if (tabSortie[i][j] == 1) {
					var_max_i++;
		//			System.out.println(var_max_i +" " + maxi_j);
				}
			}
			if (isGood && var_max_i == maxi_j ) {
				max_i = i;
				isGood = false;
			}
			var_max_i = 0;
		}
		int inchange = max_i-1 ;
		min_i = 0;
		int prt = 0;
		int var_max_j = 0;
		for (int j=0; j<maxi_j; j++) {
			for (int i=0; i<max_i; i++) {
				if (tabSortie[i][j] == 1) var_max_j++;
				prt = i;
			}
			if (var_max_j == max_i) tabSortie[prt][j] = 3;
			var_max_j = 0;
		}
		int valMax_j[] = new int[12];
		int test = 0;
		for (int j=0; j<maxi_j + 1; j++) {
			if ((tabSortie[inchange][j] == 3 && tabSortie[inchange][j+1] == 1) || (tabSortie[inchange][j] == 1 && tabSortie[inchange][j+1] == 3)) {
				test++;
				valMax_j[test - 1] = j+1;
			}
		}
		if (test == 10) cinq_chiffres(tabSortie, valMax_j, max_i);
		if (test == 12) six_chiffres(tabSortie, valMax_j, max_i);
	}
}
