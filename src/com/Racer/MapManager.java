package com.Racer;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapManager {
	private ArrayList<Map> Maps = new ArrayList<>();
	private ArrayList<Object> Map1 = new ArrayList<>();
	private int currentMap = 0;
	
	public MapManager()
	{
		Maps.add(new Map("data/testmap.png", "data/LoveSong.mp3"));
		Maps.add(new Map("data/DesertMap/2.png", null));
		Maps.add(new Map("data/DesertMap/3.png", null));
		Maps.add(new Map("data/DesertMap/4.png", null));
		Maps.add(new Map("data/DesertMap/18.png", null));
		
		Map1.add(new Object(16, 48, 48, 480, 0, false));//LEFT WALL
		Map1.add(new Object(0, 0, 512, 64, 0, false));//BOTTOM WALL
		Map1.add(new Object(0, 512 - 64, 224, 128, 0, false));//TOP LEFT WALL
		Map1.add(new Object(288, 512 - 64, 512, 512, 0, false));//TOP RIGHT WALL
		Map1.add(new Object(448, 512 - 224, 512, 512, 0, false));//RIGHT TOP WALL
		Map1.add(new Object(448, 288-512 - 64, 512, 512, 0, false));//RIGHT BOTTOM WALL
	}
	
	public void draw(SpriteBatch batch)
	{
		Maps.get(currentMap).draw(batch);
	}
	
	public void update(Player Hero)
	{
		if (currentMap == 0)
		{
			for (Object i : Map1)
			{
				i.checkColl(Hero, Hero.returnDir(), currentMap);
			}
			
			//Map Switching
			if (Hero.returnPos().y > 512)
			{
				currentMap = 1;
				Hero.setPos(Hero.returnPos().x, 0);
			}
		}
		else if (currentMap == 1)
		{
			//Map Switching
			if (Hero.returnPos().y > 512)
			{
				currentMap = 2;
				Hero.setPos(Hero.returnPos().x, 0);
			}
			else if (Hero.returnPos().y < 0)
			{
				currentMap = 0;
				Hero.setPos(Hero.returnPos().x, 512);
			}
		}
		else if (currentMap == 2)
		{
			if (Hero.returnPos().x > 512)
			{
				currentMap = 3;
				Hero.setPos(0, Hero.returnPos().y);
			}
			else if (Hero.returnPos().y < 0)
			{
				currentMap = 1;
				Hero.setPos(Hero.returnPos().x, 512);
			}
		}
		else if (currentMap == 3)
		{
			if (Hero.returnPos().y < 0)
			{
				//currentMap = 4;
				Hero.setPos(Hero.returnPos().x, 512);
			}
			else if (Hero.returnPos().x < 0)
			{
				currentMap = 2;
				Hero.setPos(512, Hero.returnPos().y);
			}
		}
		else if (currentMap == 4)
		{
			
		}
	}
}
