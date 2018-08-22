package com.ccg.problemaML.models;

public class Ferengi extends Planet {
	protected Ferengi(int vel, int dis, boolean dir) {
		super(vel, dis, dir);
		// TODO Auto-generated constructor stub
	}
	private final static int vel = 1;
    private final static int dis = 500;
    private final static boolean clk = true;
    
    public Ferengi()
    {
    	super(vel, dis, clk);
    }
}
