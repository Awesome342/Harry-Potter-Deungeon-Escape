package com.Racer;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemieManager 
{
	private int amount = 4;
	private int currentEnemie = 0;
	ArrayList<Enemie> Enemies = new ArrayList<>();
	
	public EnemieManager()
	{
		for (int i = 0; i < amount; i++)
		{
			Enemies.add(new Enemie("data/enemy.png", 64, 448, 64, 448));
		}
		Enemies.get(0).spawn();
	}
	
	public void draw(SpriteBatch Screen, Player Hero)
	{
		for (int i = 0; i < amount; i++)
		{
			Enemies.get(i).draw(Screen, Hero);
		}
	}
	
	public void updateDamage(ArrayList<Bullet> Bullets)
	{
		for (Enemie i : Enemies)
		{
			i.updateDamage(Bullets);
			i.handleShooting();
		}
		
		if (Enemies.get(0).returnIsActive() == false)
		{
			Enemies.get(0).spawn();
		}
	}
	
	public void spawnOne()
	{
		Enemies.get(currentEnemie).spawn();
		currentEnemie++;
	}
}
