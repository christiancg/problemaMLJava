package com.ccg.problemaML.models;

public class Vulcano extends Planet {
    protected Vulcano(int vel, int dis, boolean dir) {
		super(vel, dis, dir);
		// TODO Auto-generated constructor stub
	}
	private final static int vel = 5;
    private final static int dis = 1000;
    private final static boolean clk = false;
    
    public Vulcano() {
    	super(vel, dis, clk);
    }
}
