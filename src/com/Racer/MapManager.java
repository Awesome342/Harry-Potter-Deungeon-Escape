package com.Racer;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapManager {
	private ArrayList<Map> Maps = new ArrayList<>();
	
	public MapManager()
	{
		Maps.add(new Map("data/bg.png", "data/LoveSong.mp3"));
	}
	
	public void draw(SpriteBatch batch)
	{
		for (Map i : Maps)
		{
			i.draw(batch);
		}
	}
}
