package com.Racer;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemie extends Entity
{
	private static Random Rand = new Random();
	private boolean IsActive = false;
	private char dir = 'D';
	
	//bullet stuff
	ArrayList<Bullet> bullets = new ArrayList<>();
	private int currentBullet = 0;
	private int bulletLimit = 100;
	private int currentBulletMax = bulletLimit;
	
	public Enemie(String filename, int startX, int endX, int startY, int endY) 
	{
		super(filename, -10000, Rand.nextInt(endX - startX) + startX, Rand.nextInt(endY - startY) + startY, 32, 32, 32);
		for (int i = 0; i < bulletLimit; i++)
		{
			bullets.add(new Bullet());
		}
	}
	
	public void moveIntoBounds(int curX, int curY, int startX, int endX, int startY, int endY)
	{
		if (curX > endX || curX < startX || curY > endY || curY < startY)
		{
			super.setPos(Rand.nextInt(endX) + 1, Rand.nextInt(endY) + 1);
		}
	}
	
	public void moveIntoBounds(int startX, int endX, int startY, int endY)
	{
		super.setPos(Rand.nextInt(endX) + 1, Rand.nextInt(endY) + 1);
	}
	
	public void draw(SpriteBatch Screen, Player Hero)
	{
		for (Bullet i : bullets)
		{
			i.draw(Screen);
			i.update(Hero);
			if (i.IsShooting() == false && currentBullet == bulletLimit)
			{
				currentBullet = 0;
			}
		}
		super.draw(Screen);
	}
	public void spawn()
	{
		super.setPos(Rand.nextInt(448 - 64) + 64, Rand.nextInt(448 - 64) + 64);
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