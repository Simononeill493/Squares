package bin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//The main JFrame for gameplay - essentially just a container for the DrawApp class.
//Gets its size from the utility class U, and sets up a few listeners - one to refresh the
//Screen if moved, and one to detect mouse clicks.
public class MainWindow extends JFrame
{
	public static DrawApp da;

	MainWindow(String name)
	{
		super(name);
	}
	
	void initialize()
	{
		da = new DrawApp();
		
		//I'm not sure this does anything lol so let's check that later
		//Because the init inside DrawApp takes graphics2D and this is blank
		//also i can't get this to print anything out
		da.init();
		
		addWindowListener(new WindowAdapter() 
        {
            public void windowDeiconified(WindowEvent e)
            {
            	DrawApp.refreshScreenFlag = true;
            }
        }
        );
		
		da.addMouseListener(new MouseAdapter() 
        {
            public void mouseReleased(MouseEvent e)
            {
            	da.mouseInput(e.getX(),e.getY());
            }
        }
        );

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyInput());
        getContentPane().add("Center",da);
		
        pack();
		setSize((int)U.drawWidth+(int)U.menuWidth+6,(int)U.drawHeight+63);
		setVisible(true);
		setResizable(false);
		
	}
}