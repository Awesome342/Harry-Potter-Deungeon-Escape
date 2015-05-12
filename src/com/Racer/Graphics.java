package com.Racer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graphics 
{
	private SpriteBatch Screen = new SpriteBatch();
	private Player Player = new Player();
	private Texture bg = new Texture("data/bg.png");
	private EnemieManager Enemies = new EnemieManager();
	private MapManager Map = new MapManager();
	
	public void draw()
	{
		Screen.begin();
		Map.update(Player);
		Map.draw(Screen);
		Enemies.updateDamage(Player.returnBullets());
		Enemies.draw(Screen, Player);
		Player.getInput();
		Player.draw(Screen);
		Screen.end();
	}
}
