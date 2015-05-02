package com.Racer;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Entity {

	ArrayList<Bullet> bullets = new ArrayList<>();
	private int currentBullet = 0;
	private int bulletLimit = 100;
	private int currentBulletMax = bulletLimit;
	private char dir;
	
	public Player()
	{
		super("data/coa2.png", 0, 0, 0, 0, 32, 48);
		for (int i = 0; i < bulletLimit; i++)
		{
			bullets.add(new Bullet());
		}
	}
	
	public void getInput()
	{
		if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
		{
			super.move('R', 3);
			dir = 'R';
		}
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
		{
			super.move('L', 3);
			dir = 'L';
		}
		if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
		{
			super.move('D', 3);
			dir = 'D';
		}
		if (Gdx.input.isKeyPressed(Keys.DPAD_UP))
		{
			super.move('U', 3);
			dir = 'U';
		}
		
		if (Gdx.input.isKeyPressed(Keys.SPACE))
		{
			shoot();
		}
		
		animate();
	}
	
	public void animate()
	{
		if (dir == 'R')
		{
			clipy = 48 * 3;
		}
		else if (dir == 'L')
		{
			clipy = 48 * 2;
		}
		else if (dir == 'U')
		{
			clipy = 48;
		}
		else if (dir == 'D')
		{
			clipy = 0;
		}
		
		super.setClip(clipx, clipy, 32, 48);
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
	
	public void shoot()
	{
		if (currentBullet != bulletLimit)
		{
			currentBullet ++;
			bullets.get(currentBullet - 1).shoot(super.returnPos().x, super.returnPos().y, dir);
		}
	}
	
	public ArrayList<Bullet> returnBullets()
	{
		return bullets;
	}
	
}
