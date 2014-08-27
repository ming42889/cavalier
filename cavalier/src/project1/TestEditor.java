package project1;



import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TestEditor{
	static Scanner sc = new Scanner (System.in);
	private static JPanel panel;
	private static JFrame frame;
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException  
	{
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                init();
            }
        });
		
	}
	private static void init(){}
}
