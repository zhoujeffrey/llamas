package com.PennApps.llamas;

public class Obstacle {
	public int type;
	public int loc_x;
	public int loc_y;
	public int len_x;
	public int len_y;
	
    public Obstacle(int obs_type, int start_loc_x, int start_loc_y, int obj_len_x, int obj_len_y) {
    	type = obs_type;
        loc_x = start_loc_x;
        loc_y = start_loc_y;
        len_x = obj_len_x;
        len_y = obj_len_y;
    }
}
