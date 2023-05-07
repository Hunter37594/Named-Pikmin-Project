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

public class Driver implements ActionListener {
	
	// Declare class data
	public static Image raccoon;
	private static JFrame frame;
	private static JPanel panel;
	private static JButton promote;
	private static JComboBox<Integer> time;
	
    public static void main(String[] args) throws FileNotFoundException, IOException {

    	//raccoon = ImageIO.read(new File(("raccoon.png")));
    	
    	Pikmin.add(new Pikmin("Steve", PikColor.RED, Bloom.LEAF));
    	
    	// Set up frame, include your name in the title
    	frame = new JFrame("Pikmanager");
    	frame.setSize(1920, 1080);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	frame.setLayout(new BorderLayout());
        
        // Set up Panel for input selections
        panel = new JPanel();
    	
        // Promote Button
        promote = new JButton("Promote");
        promote.addActionListener(new Driver());
    	
        // ComboBox to pick animation time
        time = new JComboBox<Integer>();
        time.addItem(15);
        time.addItem(30);
        time.addItem(60);
        time.addItem(90);
    	
        // Add all to top panel
        panel.add(promote);
        panel.add(time);
        
        frame.add(panel, BorderLayout.PAGE_START);
        
    }
    
    // Animate the trip based on selections from the GUI components
    public void actionPerformed(ActionEvent event) {
        Pikmin.get("Steve").promote();
        Pikmin.get("Steve").candypop(PikColor.BLUE);
        System.out.println(Pikmin.get("Steve"));
    }
    
}
