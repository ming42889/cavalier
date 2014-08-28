package notepad;

import javax.swing.JFrame;

public class NotePad{
	
	
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
		final JFrame frame = new UIFrame("-NotePad");
		
		
    }
	
}
