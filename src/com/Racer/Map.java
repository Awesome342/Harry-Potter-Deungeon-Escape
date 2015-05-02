package com.Racer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map extends Entity {
	
	public Map(String filename, String soundfilename) 
	{
		super(filename, 0, 0, 0, 0, 512, 512);
	}
}
