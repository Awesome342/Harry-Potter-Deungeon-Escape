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
	private boolean IsKeyPressed = false;
	private char dir;
	private int mana;
	private int health;
	private boolean IsActive;
	
	public Player()
	{
		
		super("data/coa2.png", 100, 100, 0, 0, 32, 48);
		for (int i = 0; i < bulletLimit; i++)
		{
			bullets.add(new Bullet());
		}
		mana = 100;
		health = 100;
		IsActive = true;
	}
	
	public void getInput()
	{
		if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
		{
			super.move('R', 4);
			dir = 'R';
		}
		else if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
		{
			super.move('L', 4);
			dir = 'L';
		}
		else if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN))
		{
			super.move('D', 4);
			dir = 'D';
		}
		else if (Gdx.input.isKeyPressed(Keys.DPAD_UP))
		{
			super.move('U', 4);
			dir = 'U';
		}
		
		if (Gdx.input.isKeyPressed(Keys.SPACE))
		{
			shoot();
			IsKeyPressed = true;
		}
		else
		{
			IsKeyPressed = false;
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
			if (i.IsShooting() == false && currentBullet == bulletLimit && IsKeyPressed == false)
			{
				currentBullet = 0;
			}
		}
		if (IsActive == true)
			super.draw(Screen);
		
		System.out.println("Health: " + health);
	}
	
	public void shoot()
	{
		if (currentBullet != bulletLimit && IsKeyPressed == false && mana > 0)
		{
			currentBullet ++;
			bullets.get(currentBullet - 1).shoot(super.returnPos().x, super.returnPos().y, dir);
			mana -= 10;
		}
	}
	
	public void updateDamage(ArrayList<Bullet> Bullets)
	{
		for (Bullet i : Bullets)
		{
			if (this.IsCollision(super.returnPos(), i.returnPos()))
			{
				health -= 10;
			}
		}
		
		if (health <= 0)
		{
			kill();
		}
	}
	
	public void takeDamage(int num)
	{
		health -= num;
	}
	
	public void kill()
	{
		super.setPos(1000, 10000);
		IsActive = false;
	}
	
	public ArrayList<Bullet> returnBullets()
	{
		return bullets;
	}
	
	public char returnDir()
	{
		return dir;
	}
	
}
