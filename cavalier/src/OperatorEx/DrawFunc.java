package OperatorEx;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawFunc extends JFrame{

	public static void main(String[] args){
		DrawFunc df = new DrawFunc();
		FuncPanel fPanel= new FuncPanel(400);
		df.add(fPanel);
		df.setVisible(true);
		System.out.println(fPanel.getPreferredSize());
	}
	
	public DrawFunc(){
		super("Graph Excices");
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);	

	}
		private static class FuncPanel extends JPanel{
			int size;
			double maxX;
			double maxY;
			public FuncPanel(int size){
				this.size = size;
				this.maxX = 3000;
				this.maxY = Math.E;
				setPreferredSize(new Dimension(size, size));
			}
			public void paintComponent(Graphics g){
				drawCordinates(g);
				for (int i=0;i<=3000;i++){
					drawPoint(g, i, Math.E-.001*i);
				}
			
			}
			
			private void drawCordinates(Graphics g){
				g.drawLine(size/8, 0, size/8, size); //y-axis
				g.drawLine(0, size-size/6, size, size-size/6); //x-axis
				g.drawString(0+"", size/10, size-size/10);
				g.drawString("e", size/10, size/25);
				g.drawLine(size/10, size/25, size/6, size/25);
				g.drawString("3000", size-size/8, size-size/10);
				g.drawLine(size-size/20, size-size/6, size-size/20, size-size/10);
			
			}
			
			private void drawPoint(Graphics g, double x, double y){
				int x1 = toScreenCordinateX(x);
				int y1 = toScreenCordinateY(y);
				g.drawLine(x1,y1,x1,y1);
			}
			
			private int toScreenCordinateX(double x){
				return (int) (x*(size-size/8-size/20)/maxX+size/8);
			}
			
			private int toScreenCordinateY(double y){
				return (int) (size-y*(size-size/6-size/25)/maxY-size/6);
			}
		}
		
}
