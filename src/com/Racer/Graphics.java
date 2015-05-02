package com.Racer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Graphics 
{
	private SpriteBatch Screen = new SpriteBatch();
	private Player Player = new Player();
	private Texture bg = new Texture("data/bg.png");
	private EnemieManager Enemies = new EnemieManager();
	
	public void draw()
	{
		Screen.begin();
		Screen.draw(bg, 0, 0);
		Enemies.updateDamage(Player.returnBullets());
		Enemies.draw(Screen);
		Player.getInput();
		Player.draw(Screen);
		Screen.end();
	}
}
