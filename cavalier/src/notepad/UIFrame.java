package notepad;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	//file for storing frame property information
	private final String opFile = "options.prop";
	private static final int PANEL_WIDTH = 500;
    private static final int PANEL_HEIGHT = 500;

	public UIFrame(String fileName){
		super(fileName);
		init();
	}

	private void storeOptions() throws Exception {		
		File file = new File(opFile);
		Properties p = new Properties();
		// restore the frame from 'full screen' first!
		setExtendedState(Frame.NORMAL);
		Rectangle r = getBounds();
		int x = (int)r.getX();
		int y = (int)r.getY();
		int w = (int)r.getWidth();
		int h = (int)r.getHeight();
		
		System.out.println(w+", "+h);

		p.setProperty("x", "" + x);
		p.setProperty("y", "" + y);
		p.setProperty("w", "" + w);
		p.setProperty("h", "" + h);

		BufferedWriter br = new BufferedWriter(new FileWriter(file));
		p.store(br, "Properties of the user frame");

	}

	/** Restore location & size of UI */
	private void restoreOptions() throws IOException {
		File file = new File(opFile);
		Properties p = new Properties();
		BufferedReader br = new BufferedReader(new FileReader(file));
		p.load(br);

		int x = Integer.parseInt(p.getProperty("x"));
		int y = Integer.parseInt(p.getProperty("y"));
		int w = Integer.parseInt(p.getProperty("w"));
		int h = Integer.parseInt(p.getProperty("h"));

		Rectangle r = new Rectangle(x,y,w,h);
		System.out.println(w+", "+h);
		setBounds(r);
	}
	
	private void init(){
		//add text panel
		TextArea ta = new TextArea("",PANEL_WIDTH, PANEL_HEIGHT, TextArea.SCROLLBARS_VERTICAL_ONLY);
		getContentPane().add(ta);
		pack();
		
		//store Location information when exit
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					storeOptions();
				} catch(Exception e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
	
		File optionsFile = new File(opFile);
		if (optionsFile.exists()) {
			try {
				restoreOptions();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		} else {
			setLocationByPlatform(true);
		}
	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
