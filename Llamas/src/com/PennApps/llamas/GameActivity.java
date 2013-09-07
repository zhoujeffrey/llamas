package com.PennApps.llamas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameActivity {
	private List<Obstacle> obstacle_list = new ArrayList<Obstacle>();
	
	private void calculate_collision(float llama_x, float llama_y) {
		// Cycle through data object
		
		int i = 0;
		Obstacle test_this_obs;
		
		while (i < obstacle_list.size()) {
			test_this_obs = obstacle_list.get(i);
			
			if (llama_x >= test_this_obs.loc_x && llama_x <= test_this_obs.loc_x + test_this_obs.len_x) {
				// If x is no not there, don't look at y
				if (llama_y >= test_this_obs.loc_y && llama_y <= test_this_obs.loc_y + test_this_obs.len_y) {
					// Check to see that y is okay
					handle_collision(test_this_obs);
				}
			}
			i++;
		}
	}
	
	private boolean handle_collision(Obstacle collided_obstacle){
		if (collided_obstacle.type == 0){
			// Death
			return false;
		}
		else if (collided_obstacle.type == 1) {
			// Some sort of Jump Action
			return true;
		}
		else {
			// Something else
			return true;
		}
	}
}
