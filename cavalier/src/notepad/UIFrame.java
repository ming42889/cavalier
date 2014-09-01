package notepad;

import java.io.File;

import javax.swing.JFrame;


public class UIFrame{
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	private static void createAndShowGUI(){
		final JFrame frame = new NotePad();
		//frame.setLayout(new FlowLayout());
		frame.setVisible(true);
    }
	
	private static void open(String s){
		File f = new File(s);
	}
	
}