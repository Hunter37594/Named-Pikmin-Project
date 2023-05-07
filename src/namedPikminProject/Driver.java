package namedPikminProject;

import java.io.FileNotFoundException;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;

import namedPikminProject.Pikmin.Bloom;
import namedPikminProject.Pikmin.PikColor;

import java.io.File;
import java.awt.*;
import java.awt.event.*;

/*
 * Goals:
 * - 
 */

public class Driver {
	
	// Declare class data
	public static Image raccoon;
	private static JFrame frame;
	private static JPanel panel;
	private static Pikmin currPik;
	private static PikColor currColor;
	
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	
    	Pikmin.readFile("pikmanager.csv");
    	
    	// Set up frame, include your name in the title
    	frame = new JFrame("Pikmanager");
    	frame.setSize(1920, 1080);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	frame.setLayout(new GridBagLayout());
        
    	
        // Drop-down to select pikmin
        JComboBox<String> pikCombo = new JComboBox<String>();
        JLabel pikLabel = new JLabel();
        pikCombo.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		currPik = Pikmin.get((String) pikCombo.getSelectedItem());
        		pikLabel.setText(currPik.getColor().toString() + " " + currPik.getBloom().toString());
        	}
        });
        for (Pikmin p : Pikmin.getPikminList()) {
        	pikCombo.addItem(p.getName());
        }
        
        // Drop-down to select destination color
        // TODO: Display img instead of text label
        JComboBox<String> candyCombo = new JComboBox<String>();
        candyCombo.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		currColor = PikColor.valueOf((String) candyCombo.getSelectedItem());
        	}
        });
        candyCombo.addItem("RED");
        candyCombo.addItem("YELLOW");
        candyCombo.addItem("BLUE");
        
        // Promotes selected pikmin by one tier
        JButton promote = new JButton(new AbstractAction("Promote") {
            @Override
            public void actionPerformed( ActionEvent e ) {
            	Pikmin p = Pikmin.get((String) pikCombo.getSelectedItem());
            	p.promote();
            	System.out.println(p);
            }
        });
        // Demotes selected pikmin by one tier
        JButton demote = new JButton(new AbstractAction("Demote") {
            @Override
            public void actionPerformed( ActionEvent e ) {
            	Pikmin p = Pikmin.get((String) pikCombo.getSelectedItem());
            	p.demote();
            	System.out.println(p);
            }
        });
        
        JButton candypop = new JButton(new AbstractAction("Candypop") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                currPik.candypop(currColor);
                System.out.println(currPik);
            }
        });
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = c.weighty = 1.0;
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        frame.add(pikCombo, c);
        
        c.gridx = 1;
        c.gridy = 0;
        frame.add(pikLabel, c);
        
        c.gridx = 1;
        c.gridy = 2;
        frame.add(candyCombo, c);
        
        c.gridx = 0;
        c.gridy = 1;
        frame.add(promote, c);
        
        c.gridx = 1;
        c.gridy = 1;
        frame.add(demote, c);
        
        c.gridx = 0;
        c.gridy = 2;
        frame.add(candypop, c);
        
        frame.setIconImage(ImageIO.read(new File("louie.jpg")));
        
        System.out.println(Pikmin.getPikminList());
    }
    
}
