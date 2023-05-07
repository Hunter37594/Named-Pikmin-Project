package namedPikminProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pikmin {
	
	public enum PikColor {
		RED, YELLOW, BLUE;
	}
	public enum Bloom {
		LEAF, BUD, FLOWER;
	}
	
	private String name;
	private PikColor color;
	private Bloom bloom;
	private static ArrayList<Pikmin> pikmin = new ArrayList<Pikmin>();
	private static ArrayList<Pikmin> squad = new ArrayList<Pikmin>();
	
	public Pikmin(String name, PikColor color, Bloom bloom) {
		
		this.name = name;
		this.color = color;
		this.bloom = bloom;
		
		pikmin.add(this);
		
	}
	
	public static void add(Pikmin p) {
		pikmin.add(p);
	}
	public static void squadd(Pikmin p) {
		squad.add(p);
	}
	public static void kill (Pikmin p) {
		squad.remove(p);
		pikmin.remove(p);
	}
	
	public void promote() {
		
		if (this.bloom == Bloom.LEAF) {
			this.bloom = Bloom.BUD;
		}
		
		else if (this.bloom == Bloom.BUD) {
			this.bloom = Bloom.FLOWER;
		}
		
	}
	public void demote() {
		
		if (this.bloom == Bloom.FLOWER) {
			this.bloom = Bloom.BUD;
		}
		
		else if (this.bloom == Bloom.BUD) {
			this.bloom = Bloom.LEAF;
		}
		
	}
	public void candypop(PikColor toColor) {
		this.color = toColor;
	}
	
	public static Pikmin get(String name) {
		
		for (Pikmin p : pikmin) {
			if (p.name.equals(name)) {
				return p;
			}
		}
		
		return null;
		
	}
	public static ArrayList<Pikmin> getPikminList() {
		return pikmin;
	}
	public String getName() {
		return this.name;
	}
	public PikColor getColor() {
		return this.color;
	}
	public Bloom getBloom() {
		return this.bloom;
	}
	
	public static void readFile(String filename) throws FileNotFoundException, IOException {

		// construct a file object for the file with the given name.
		File file = new File(filename);

		// construct a scanner to read the file.
		Scanner fileScanner = new Scanner(file);

		// create the Array that will store each lines data so we can grab the time, lat, and lon
		String[] fileData = null;

		// grab the next line
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();

			// split each line along the commas
			fileData = line.split(",");
			Pikmin p = new Pikmin(fileData[0], PikColor.valueOf(fileData[1]), Bloom.valueOf(fileData[2]));
		}

		// close scanner
		fileScanner.close();
	}
	
	@Override
	public String toString() {
		return name + ": " + color.toString() + " " + bloom.toString();
	}
	
}
