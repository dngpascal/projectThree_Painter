package projectThree_Painter;

// import
import java.awt.* ; 
import javax.swing.* ; 
import java.util.* ; 
//


// class PointTrace : collection de Point pour le tracé du painter
public class PointTrace extends Point 
{
	// variables d'instance 
	int x ; 
	int y ; 
	int taillePinceau ; 
	String formePinceau ; 
	Color couleurPinceau ; 
	
	
	// constructeur surchargé
	public PointTrace (int pX, int pY, int pTaillePinceau,
			String pFormePinceau, Color pCouleurPinceau)
	{
		this.x = pX ;  
		this.y = pY ;
		this.taillePinceau = pTaillePinceau ; 
		this.formePinceau = pFormePinceau ; 
		this.couleurPinceau = pCouleurPinceau ;  
	} 
}
//
