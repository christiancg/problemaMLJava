package com.ccg.problemaML.models;

public class Betasoide extends Planet {
    protected Betasoide(int vel, int dis, boolean dir) {
		super(vel, dis, dir);
		// TODO Auto-generated constructor stub
	}

	private final static int vel = 3;
    private final static int dis = 2000;
    private final static boolean clk = true;

    public Betasoide()
    {
    	super(vel, dis, clk);
    }
}
