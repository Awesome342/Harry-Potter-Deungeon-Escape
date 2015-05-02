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
			Enemies.add(new Enemie("data/Coa2.png"));
		}
		Enemies.get(0).spawn();
	}
	
	public void draw(SpriteBatch Screen)
	{
		for (int i = 0; i < amount; i++)
		{
			Enemies.get(i).draw(Screen);
		}
	}
	
	public void updateDamage(ArrayList<Bullet> Bullets)
	{
		for (Enemie i : Enemies)
		{
			i.updateDamage(Bullets);
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
