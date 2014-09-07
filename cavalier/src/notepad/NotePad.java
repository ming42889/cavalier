package notepad;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class NotePad extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static String version="1.0";
	//file for storing frame property information
	private final String opFile = "options.prop";
	private static final int PANEL_WIDTH = 500;
	private static final int PANEL_HEIGHT = 500;
	private final TextArea text = new TextArea("",PANEL_WIDTH, PANEL_HEIGHT, TextArea.SCROLLBARS_VERTICAL_ONLY);


	//menu item reference
	private JMenuItem newFile;
	private JMenuItem openFile;
	private JMenuItem saveFile;
	private JMenuItem saveAs;
	private JMenuItem close;
	private JMenuItem cut;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem findNext;
	private JMenuItem about;

	private String fileName;
	private String filePath;

	public NotePad(){
		super();
		this.fileName = "Untitled";
		this.filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getAbsolutePath();
		//System.out.println(filePath);
		this.setTitle(fileName+" - NotePad");
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
		//System.out.println(w+", "+h);
		setBounds(r);
	}

	private void init(){
		//add text panel
		getContentPane().add(this.text);
		addMenu();
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
			setSize(PANEL_WIDTH, PANEL_HEIGHT);
		}

	}

	// add new item to a menu
	private void initMenuItems(){
		//objection creation
		this.newFile = new JMenuItem("New");
		this.openFile = new JMenuItem("Open");
		this.saveFile = new JMenuItem("Save");
		this.saveAs = new JMenuItem("Save As");
		this.close = new JMenuItem("Close");
		this.cut = new JMenuItem("Cut");
		this.copy = new JMenuItem("Copy");
		this.paste = new JMenuItem("Paste");
		this.findNext = new JMenuItem("find next");
		this.about = new JMenuItem("About");

		//ActionListeners
		this.newFile.addActionListener(this);
		this.openFile.addActionListener(this);
		this.saveFile.addActionListener(this);
		this.saveAs.addActionListener(this);
		this.close.addActionListener(this);
		this.cut.addActionListener(this);
		this.copy.addActionListener(this);
		this.paste.addActionListener(this);
		this.findNext.addActionListener(this);
		this.about.addActionListener(this);

		//short cut
		this.findNext.setAccelerator(KeyStroke.getKeyStroke('F',KeyEvent.CTRL_DOWN_MASK));


	}

	private void addMenu(){
		initMenuItems();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//file menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(this.newFile);
		fileMenu.add(this.openFile);
		fileMenu.add(this.saveFile);
		fileMenu.add(this.saveAs);
		fileMenu.add(this.close);
		menuBar.add(fileMenu);

		//edit menu
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(this.cut);
		editMenu.add(this.copy);
		editMenu.add(this.paste);
		menuBar.add(editMenu);

		//search menu
		JMenu searchMenu = new JMenu("Search");
		searchMenu.add(this.findNext);
		menuBar.add(searchMenu);

		//help menu
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(this.about);
		menuBar.add(helpMenu);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.close) this.dispose();
		if (e.getSource()==this.openFile) openFile();
		if (e.getSource()==this.newFile) newFile();
		if (e.getSource()==this.saveFile) saveFile();
		if (e.getSource()==this.saveAs) saveAs();
		if (e.getSource()==this.cut) cut();
		if (e.getSource()==this.copy) copy();
		if (e.getSource()==this.paste) paste();
		if (e.getSource()==this.findNext) findNext();
		if (e.getSource()==this.about) about();

	}

	//file operations
	//close file that's currently being access, return true if succeed,false if canceled
	private boolean closeCurrentFile(){
		if (!this.text.getText().isEmpty()) {
			int op = JOptionPane.showConfirmDialog(
					this,
					"Do you want to save changes to "+fileName,
					"NotePad",
					JOptionPane.YES_NO_CANCEL_OPTION);
			//System.out.println(op);
			switch(op){
			case 0:	saveFile(); 
			case 1:	return true;
			case 2: return false;
			}		
		}
		return true;
	}

	private void newFile(){
		if (closeCurrentFile()) this.text.setText("");
		fileName = "Untitled";
		this.setTitle(fileName+" - NotePad");

	}

	private void openFile(){
		if (closeCurrentFile()) {
			JFileChooser open = new JFileChooser(this.filePath);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
			open.setFileFilter(filter);
			int op = open.showOpenDialog(this);
			if (op == JFileChooser.APPROVE_OPTION){
				this.text.setText("");
				this.fileName = open.getSelectedFile().getName();
				this.filePath = open.getSelectedFile().getParent();
				try {	
					BufferedReader br = new BufferedReader(new FileReader(open.getSelectedFile()));
					String line;
					while((line = br.readLine()) != null)
						this.text.append(line+"\n");
					br.close();
					this.setTitle(open.getSelectedFile().getName()+" - NotePad");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void saveFile(){
		File f = new File(this.filePath+"\\"+this.fileName);
		//System.out.println(this.filePath+"\\"+this.fileName+" "+f.exists());
		if (f.exists()){
			//System.out.println(this.text.getText());
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(this.text.getText());
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else saveAs();
	}

	private void saveAs(){
		JFileChooser save = new JFileChooser(this.filePath);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
		save.setFileFilter(filter);
		int op = save.showSaveDialog(this);
		if (op == JFileChooser.APPROVE_OPTION){
			File f;
			if (filter.accept(save.getSelectedFile())) f = save.getSelectedFile();
			else f = new File(save.getSelectedFile().getAbsolutePath()+".txt");
			this.fileName = f.getName();
			this.filePath = f.getParent();
			System.out.println(this.filePath);
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(this.text.getText());
				bw.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		this.setTitle(this.fileName+" - NotePad");

	}

	//edit operations
	private void cut(){
		copy();
		//System.out.println(text.getSelectionStart()+", "+text.getSelectionEnd());
		text.replaceRange("", text.getSelectionStart(), text.getSelectionEnd());

	}
	private void copy(){
		Clipboard c = text.getToolkit().getSystemClipboard();
		StringSelection testData = new StringSelection(text.getSelectedText());
		c.setContents(testData, testData);
	}
	private void paste(){
		Clipboard c = text.getToolkit().getSystemClipboard();
		try {
			text.insert((String) c.getContents(this).getTransferData( DataFlavor.stringFlavor ),
					text.getCaretPosition());
		} catch (UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
	}

	private void findNext(){
		String s = JOptionPane.showInputDialog(
				this,
				"enter the word or words you want to find",
				"Find",
				JOptionPane.PLAIN_MESSAGE);
		if (s!=null){
			//System.out.println(s+" , "+text.getCaretPosition());
			int i = text.getText().substring(text.getCaretPosition()).indexOf(s);
			if (i>=0){
				i+=text.getCaretPosition();
				text.select(i, i+s.length());
				//System.out.println(i);
			} else {
				JOptionPane.showMessageDialog(this,
						"No match found");
			}
		}
	}



	private void about(){
		String aboutContent = "NotePad\n"
				+"Version "+version+"\n"
				+"Copyright \u00A9 Mingjian Zheng";
		JOptionPane.showMessageDialog(this,
				aboutContent );
	}

}
