package gui;

import javax.swing.JPanel;

import intit.Main;

import javax.swing.DefaultListModel;
import utility.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
public class DragPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	int Cheight,Cwidth,tileW,tileH;
	
	
	private JList<String> list;
	private JFileChooser choose;
	public DrawPanel panel;

	//BUTTONS that are the options for the project
	private JButton delete,add,fileAdd,save;
	
	//used to make a list
	private DefaultListModel<String> mod;
	
	
	public DragPanel(int w, int h) {
		//creates the original width and height of the window
		if(w==0) {
			w=600;
			}
		if(h==0) {
			h=350;
		}
		
		
		
		//sets the size
		setSize(w, h);
		setLayout(null);
		//this is used for the list element
		mod=new DefaultListModel<String>();

		
		//intializes all of the elements
		panel = new DrawPanel();
		choose=new JFileChooser();
		delete=new JButton("X");
		add=new JButton("Add");
		fileAdd=new JButton("Import");
		save=new JButton("Save");

		list = new JList<String>(mod);
		
		//adds all of the listenters
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saves();
			}
			}
		);
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GVars.placeState=2;
				Main.type.requestFocus();

				}
		});
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GVars.placeState=1;
				Main.type.requestFocus();
			}
		});
		fileAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addToList();
			Main.type.requestFocus();

			}
		});
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(mod.size()>0) {
				panel.setPen(list.getSelectedIndex());
				GVars.listNum=list.getSelectedIndex();
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mMovePaint(e);
				
			}
		});
		
		//adds the elements to the frame
		add(list);
		add(fileAdd);
		add(delete);
		add(save);
		add(panel);
		add(add);		
	}
	//saves the tile map in a file
	public void saves() {
		//creates the dialog
		choose.setDialogTitle("Save To");
		int choice =choose.showSaveDialog(this);
		
		//once approved write to the file
		if(choice==JFileChooser.APPROVE_OPTION) {
			File sav=choose.getSelectedFile();
			try {
			FileWriter writes=new FileWriter(sav);
			writes.write(panel.getList().toString());
			writes.close();
			}
			catch(IOException e) {}
		}
	}
	//adds a file to the image list.
	public void addToList() {
		//starts the dialog
		File f;
		int choise=choose.showOpenDialog(this);
		
		//if approved, adds it to the list
		if(choise==JFileChooser.APPROVE_OPTION) {
			f=choose.getSelectedFile();
			
			try{
				Image i=ImageIO.read(f);
				ITile  m=new ITile(0,0,50,50,i);
				m.setId(GVars.brush.size());
				GVars.brush.add(m);
				mod.add(mod.size(), "Tile "+mod.size());
			}
			catch(IOException e) {
			
			}
		}
	}
	
	//resizes the elements when the window is resized
	public void resizes(int w, int h) {
		setSize(w,h);
		add.setBounds(this.getSize().width/30*3, 0, this.getSize().width/30*3, this.getSize().height/25*2);
		delete.setBounds(0, 0, this.getSize().width/30*3, this.getSize().height/25*2);
		list.setBounds(0, 2*this.getSize().height/25, this.getSize().width/3,this.getSize().height-(this.getSize().height/25*2));
		panel.setBounds(this.getSize().width/3, this.getSize().height/25*2, (this.getSize().width/3)*2,this.getSize().height-(this.getSize().height/25*2));
		fileAdd.setBounds((this.getSize().width/30*3)*2,0,this.getSize().width/30*5,this.getSize().height/25*2);
		save.setBounds((this.getSize().width/30*3)*2+(this.getSize().width/30*5),0,this.getSize().width/30*5 ,this.getSize().height/25*2);

	}
	public void mMovePaint(MouseEvent e) {
		
	}
}
