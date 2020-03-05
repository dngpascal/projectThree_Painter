package projectThree_Painter;

// import
import javax.swing.* ; 
import java.awt.* ; 
import java.util.* ; 
//


// class Panel
public class Panel extends JPanel
{ 
	// variables d'instance 
	private int x = 0 ;
	private int y = 0 ;
	private int taillePinceau = 25 ;
	private String formePinceau = "Rond" ;
	private Color couleurPinceau = Color.green ; 
	private ArrayList<PointTrace> listeIntermediairePoint = new ArrayList<PointTrace> () ; 
	 
	
	// méthode paintGraphic
	public void paintComponent (Graphics g) 
	{
		g.setColor(Color.white) ; 
		g.fillRect(0, 0, this.getWidth(), this.getHeight()) ; 
		draw(g) ; 
	} 
	// 
	
	
	// méthode draw
	public void draw (Graphics g)
	{ 
		for (PointTrace point : listeIntermediairePoint)
		{
			g.setColor(point.couleurPinceau) ;
			
			if (point.formePinceau == "Rond")
			{
				g.fillOval(point.x, point.y, point.taillePinceau, point.taillePinceau) ;
				
			}
			else if (point.formePinceau == "Rectangle")
			{
				g.fillRect(point.x, point.y, point.taillePinceau, point.taillePinceau) ; 
			} 
		}   
	}
	//
	
	
	// communication entre Fenetre et Panel : alimentation de l'array de Point, et suppression de son contenu 
	public void setListePoint(int pX, int pY)
	{   
		x = pX ; 
		y = pY ;
		taillePinceau = getTaillePinceau() ;
		formePinceau = getFormePinceau() ; 
		couleurPinceau = getCouleurPinceau() ; 
		
		PointTrace newPoint = new PointTrace(x, y, taillePinceau, formePinceau, couleurPinceau) ; 
		
		listeIntermediairePoint.add(newPoint) ; 
	}
	//
	public void clearTrace()
	{
		listeIntermediairePoint.clear() ; 
	}
	// 
	  
	
	// accesseurs et mutateurs : taillePinceau 
	public int getTaillePinceau()
	{
		return taillePinceau ; 
	}
	//
	public void setTaillePinceau(int pTaillePinceau)
	{
		this.taillePinceau = pTaillePinceau ;
	}
	//
	
	
	// accesseurs et mutateurs : formePinceau 
	public String getFormePinceau()
	{
		return formePinceau ; 
	}
	//
	public void setFormePinceau(String pFormePinceau)
	{
		this.formePinceau = pFormePinceau ;
	}
	//
	
	
	// accesseurs et mutateurs : couleurPinceau
	public Color getCouleurPinceau()
	{
		return couleurPinceau ; 
	}
	//
	public void setCouleurPinceau(Color pCouleurPinceau)
	{
		this.couleurPinceau = pCouleurPinceau ;
	}
	//
	
}
//
