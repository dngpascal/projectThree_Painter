package projectThree_Painter;

// import
import javax.swing.* ; 
import java.awt.* ; 
import java.awt.event.* ; 
import java.util.* ; 
//


// class Fenetre
public class Fenetre extends JFrame
{
	// variables d'instance pour l'animation  
	private Thread tPaint ; 
	
	// variables d'instance pour les listener
	private formeListener formeListen = new formeListener() ; 
	private couleurListener couleurListen = new couleurListener() ; 
	private tailleListener tailleListen = new tailleListener() ; 
	
	// variables de mise en forme
	private JPanel container = new JPanel() ;
	private Panel pan = new Panel() ; 
	    
	// variables d'instance pour le JMenu
	private JMenuBar menuBar = new JMenuBar() ;
	
	private JMenu menuBar_Fichier = new JMenu("Fichier") ;
	private JMenuItem menuBar_Fichier_Effacer = new JMenuItem("Effacer") ; 
	private JMenuItem menuBar_Fichier_Quitter = new JMenuItem("Quitter") ;
	
	private JMenu menuBar_Edition = new JMenu("Edition") ;
	private JMenu menuBar_Edition_Forme = new JMenu("Forme du pinceau") ;
	private JMenuItem menuBar_Edition_Forme_Rond = new JMenuItem("Rond") ;
	private JMenuItem menuBar_Edition_Forme_Rectangle = new JMenuItem("Rectangle") ;
	 
	private JMenu menuBar_Edition_Couleur = new JMenu("Couleur du pinceau") ; 
	private JMenuItem menuBar_Edition_Couleur_Noir = new JMenuItem("Noir") ;
	private JMenuItem menuBar_Edition_Couleur_Bleu = new JMenuItem("Bleu") ; 
	private JMenuItem menuBar_Edition_Couleur_Vert = new JMenuItem("Vert") ; 
	private JMenuItem menuBar_Edition_Couleur_Rouge = new JMenuItem("Rouge") ; 
	  
	private JMenu menuBar_Edition_Taille = new JMenu("Taille du pinceau") ; 
	private JMenuItem menuBar_Edition_Taille_15 = new JMenuItem("15") ; 
	private JMenuItem menuBar_Edition_Taille_20 = new JMenuItem("20") ; 
	private JMenuItem menuBar_Edition_Taille_25 = new JMenuItem("25") ; 
	private JMenuItem menuBar_Edition_Taille_40 = new JMenuItem("40") ;
		
	// variables d'instance pour le JToolBar
	private JToolBar toolbar ;
	private JButton toolbar_rond ;    
	private JButton toolbar_rectangle ;  
	
	private JButton toolbar_noir ;  
	private JButton toolbar_rouge ;  
	private JButton toolbar_vert ;  
	private JButton toolbar_bleu ;  
	
	private ImageIcon toolbar_rond_png = new ImageIcon(getClass().getResource("toolbar_rond.png")) ; 
	private ImageIcon toolbar_rectangle_png = new ImageIcon(getClass().getResource("toolbar_rectangle.png")) ;  
	private ImageIcon toolbar_noir_png = new ImageIcon(getClass().getResource("toolbar_noir.png")) ;  
	private ImageIcon toolbar_vert_png = new ImageIcon(getClass().getResource("toolbar_vert.png")) ; 
	private ImageIcon toolbar_bleu_png = new ImageIcon(getClass().getResource("toolbar_bleu.png")) ; 
	private ImageIcon toolbar_rouge_png = new ImageIcon(getClass().getResource("toolbar_rouge.png")) ;  
	
	 
	// constructeur Fenetre
	public Fenetre () 
	{
		// mise en place du JFrame
		this.setTitle("Painter") ;
		this.setSize(400, 400) ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		this.setLocationRelativeTo(null) ;
		 
		// mise en place du panel  
		container.setLayout(new BorderLayout()) ;
		container.setBackground(Color.white) ; 
		pan.addMouseMotionListener(new dragListener()) ; 
		container.add(pan, BorderLayout.CENTER) ;
		
		// mise en place du JMenu et du JToolBar
		initMenu() ;
		initToolBar() ;
				
		// mise en place du JFrame, suite
		this.setContentPane(container) ;
		this.setVisible(true) ;
	}
	// 
	
	
	// initToolBar
	public void initToolBar()
	{
		toolbar = new JToolBar() ; 
		
		toolbar_rond = new JButton(toolbar_rond_png) ; 
		toolbar_rond.addMouseListener(formeListen) ; 
		toolbar_rond.setBackground(Color.white) ; 
		
		toolbar_rectangle = new JButton(toolbar_rectangle_png) ; 
		toolbar_rectangle.addMouseListener(formeListen) ; 
		toolbar_rectangle.setBackground(Color.white) ; 
		 
		toolbar_noir = new JButton(toolbar_noir_png) ;
		toolbar_noir.addMouseListener(couleurListen) ;
		toolbar_noir.setBackground(Color.white) ;
		 
		toolbar_rouge = new JButton(toolbar_rouge_png) ;
		toolbar_rouge.addMouseListener(couleurListen) ;
		toolbar_rouge.setBackground(Color.white) ;
		 
		toolbar_vert = new JButton(toolbar_vert_png) ;
		toolbar_vert.addMouseListener(couleurListen) ;
		toolbar_vert.setBackground(Color.white) ;
		 
		toolbar_bleu = new JButton(toolbar_bleu_png) ; 
		toolbar_bleu.addMouseListener(couleurListen) ;
		toolbar_bleu.setBackground(Color.white) ;
		
		//
		
		toolbar.add(toolbar_rond) ; 
		toolbar.add(toolbar_rectangle) ; 
		
		toolbar.addSeparator() ;
		 
		toolbar.add(toolbar_noir) ;
		toolbar.add(toolbar_rouge) ;
		toolbar.add(toolbar_vert) ;
		toolbar.add(toolbar_bleu) ;
		
		//
		
		this.container.add(toolbar, BorderLayout.NORTH) ;   
	}
	//
	
	
	// initMenu
	public void initMenu()
	{ 
		// Menu > Fichier  
		menuBar_Fichier_Effacer.addMouseListener(new eraseListener());
		menuBar_Fichier_Effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK)) ;
		menuBar_Fichier.add(menuBar_Fichier_Effacer) ;
		menuBar_Fichier.addSeparator() ;
		
		menuBar_Fichier_Quitter.addMouseListener(new exitListener()) ;
		menuBar_Fichier_Quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK)) ;
		menuBar_Fichier.add(menuBar_Fichier_Quitter) ;
		menuBar.add(menuBar_Fichier) ;
		
		// Menu > Edition > Forme
		menuBar_Edition_Forme_Rond.addMouseListener(formeListen) ;  
		menuBar_Edition_Forme.add(menuBar_Edition_Forme_Rond) ; 
		menuBar_Edition_Forme_Rectangle.addMouseListener(formeListen) ;
		menuBar_Edition_Forme.add(menuBar_Edition_Forme_Rectangle) ;
		menuBar_Edition_Forme.setMnemonic('F') ;
		menuBar_Edition.add(menuBar_Edition_Forme) ;
		menuBar.add(menuBar_Edition) ;
		menuBar_Edition.addSeparator() ;
		
		// Menu > Edition > Couleur
		menuBar_Edition_Couleur_Noir.addMouseListener(couleurListen) ;
		menuBar_Edition_Couleur.add(menuBar_Edition_Couleur_Noir) ; 
		menuBar_Edition_Couleur_Bleu.addMouseListener(couleurListen) ;
		menuBar_Edition_Couleur.add(menuBar_Edition_Couleur_Bleu) ;
		menuBar_Edition_Couleur_Vert.addMouseListener(couleurListen) ;
		menuBar_Edition_Couleur.add(menuBar_Edition_Couleur_Vert) ;
		menuBar_Edition_Couleur_Rouge.addMouseListener(couleurListen) ;
		menuBar_Edition_Couleur.add(menuBar_Edition_Couleur_Rouge) ;
		menuBar_Edition_Couleur.setMnemonic('C') ;
		menuBar_Edition.add(menuBar_Edition_Couleur) ;
		menuBar_Edition.addSeparator();
		
		// Menu > Edition > Taille  
		menuBar_Edition_Taille_15.addMouseListener(tailleListen) ;
		menuBar_Edition_Taille.add(menuBar_Edition_Taille_15) ;
		menuBar_Edition_Taille_20.addMouseListener(tailleListen) ;
		menuBar_Edition_Taille.add(menuBar_Edition_Taille_20) ;
		menuBar_Edition_Taille_25.addMouseListener(tailleListen) ;
		menuBar_Edition_Taille.add(menuBar_Edition_Taille_25) ;
		menuBar_Edition_Taille_40.addMouseListener(tailleListen) ;
		menuBar_Edition_Taille.add(menuBar_Edition_Taille_40) ;
		menuBar_Edition_Taille.setMnemonic('T') ;
		menuBar_Edition.add(menuBar_Edition_Taille) ; 
		 
		// Set up
		this.setJMenuBar(menuBar) ;
	}
	//
	  
	
	// Painting : Méthode et Thread 
	private void painting()
	{   
		pan.repaint();
		
		try
		{
			Thread.sleep(3) ; 
		}
		catch (InterruptedException e)
		{
			e.printStackTrace() ;
		}
	}
	// 
	class paintInAction implements Runnable 
	{
		public void run()
		{
			painting() ;
		} 
	} 
	//
	  
	
	// Mouse Motion Listener 
	class dragListener implements MouseMotionListener 
	{
		public void mouseMoved (MouseEvent e) { }
		 
		public void mouseDragged (MouseEvent e)
		{     
			// création d'une instance de PointTrace qui sera communiquée au Panel
			int pX = e.getX() ; 
			int pY = e.getY() ;    
			
			pan.setListePoint(pX, pY) ;   
			
			tPaint = new Thread(new paintInAction()) ; 
			tPaint.start() ;  
		}
	}
	//  
	// 
	
	// eraseListener
	class eraseListener extends MouseAdapter implements MouseListener
	{
		public void mouseReleased(MouseEvent e)
		{
			pan.clearTrace() ; 
			tPaint = new Thread(new paintInAction()) ; 
			tPaint.start() ;   
		}
	}
	//
	class exitListener extends MouseAdapter implements MouseListener
	{
		public void mouseReleased(MouseEvent e)
		{
			System.exit(0) ; 
		} 
	}
	//
	class formeListener extends MouseAdapter implements MouseListener
	{
		public void mouseReleased(MouseEvent e)
		{
			if (e.getSource() == menuBar_Edition_Forme_Rond || e.getSource() == toolbar_rond) 
			{ 
				pan.setFormePinceau("Rond") ; 
			}
			else if (e.getSource() == menuBar_Edition_Forme_Rectangle || e.getSource() == toolbar_rectangle) 
			{ 
				pan.setFormePinceau("Rectangle") ; 
			} 
		} 
	}
	//
	//
	class couleurListener extends MouseAdapter implements MouseListener
	{
		public void mouseReleased(MouseEvent e)
		{
			if (e.getSource() == menuBar_Edition_Couleur_Noir || e.getSource() == toolbar_noir) 
			{ 
				pan.setCouleurPinceau(Color.black) ; 
			}
			else if (e.getSource() == menuBar_Edition_Couleur_Bleu || e.getSource() == toolbar_bleu)  
			{ 
				pan.setCouleurPinceau(Color.blue) ; 
			}
			else if (e.getSource() == menuBar_Edition_Couleur_Vert || e.getSource() == toolbar_vert)  
			{ 
				pan.setCouleurPinceau(Color.green) ; 
			}
			else if (e.getSource() == menuBar_Edition_Couleur_Rouge || e.getSource() == toolbar_rouge)
			{ 
				pan.setCouleurPinceau(Color.red) ; 
			} 
		}  
	}
	//
	//
	class tailleListener extends MouseAdapter implements MouseListener
	{
		public void mouseReleased(MouseEvent e)
		{
			if (e.getSource() == menuBar_Edition_Taille_15) { pan.setTaillePinceau(15) ; }
			else if (e.getSource() == menuBar_Edition_Taille_20) { pan.setTaillePinceau(20) ; }
			else if (e.getSource() == menuBar_Edition_Taille_25) { pan.setTaillePinceau(25) ; }
			else if (e.getSource() == menuBar_Edition_Taille_40) { pan.setTaillePinceau(40) ; } 
		}   
	}
	//
}
//
