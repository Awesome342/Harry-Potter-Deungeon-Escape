package com.Racer;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemie extends Entity
{
	private Random Rand = new Random();
	private boolean IsActive = false;
	private String dir = "D";
	
	//bullet stuff
	ArrayList<Bullet> bullets = new ArrayList<>();
	private int currentBullet = 0;
	private int bulletLimit = 100;
	private int currentBulletMax = bulletLimit;
	
	public Enemie(String filename) 
	{
		super(filename, -10000, 0, 0, 32, 32, 32);
	}
	
	public void draw(SpriteBatch Screen)
	{
		for (Bullet i : bullets)
		{
			i.draw(Screen);
			i.update();
			if (i.IsShooting() == false && currentBullet == bulletLimit)
			{
				currentBullet = 0;
			}
		}
		
		super.draw(Screen);
	}
	
	public void spawn()
	{
		super.setPos(Rand.nextInt(480) + 1, Rand.nextInt(480) + 1);
		IsActive = true;
	}
	
	public void kill()
	{
		super.setPos(1000, 10000);
		IsActive = false;
	}
	
	public void updateDamage(ArrayList<Bullet> Bullets)
	{
		for (Bullet i : Bullets)
		{
			if (this.IsCollision(super.returnPos(), i.returnPos()))
			{
				kill();
			}
		}
	}
	
	public void handleShooting()
	{
		if (Rand.nextInt(500) + 1 < 20)
		{
			shoot();
		}
	}
	
	public void shoot()
	{
		if (currentBullet != bulletLimit)
		{
			currentBullet ++;
			bullets.get(currentBullet - 1).shoot(super.returnPos().x, super.returnPos().y, dir);
		}
	}
	
	public boolean returnIsActive()
	{
		return IsActive;
	}
}
