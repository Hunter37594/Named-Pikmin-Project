package namedPikminProject;

import java.util.ArrayList;

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
	public static void addSquad(Pikmin p) {
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
	public void candypop(PikColor toColor) {
		this.color = toColor;
	}
	
	public static Pikmin get(String name) {
		
		for (Pikmin p : pikmin) {
			if (p.name == name) {
				return p;
			}
		}
		
		return null;
		
	}
	
	@Override
	public String toString() {
		return name + ", " + color.toString() + " " + bloom.toString();
	}
	
}
