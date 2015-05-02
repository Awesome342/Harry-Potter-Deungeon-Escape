package com.Racer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet extends Entity {

	private boolean IsShooting = false;
	private boolean IsDead = false;//Used to 
	private char Dir;
	
	public Bullet()
	{
		super("data/block.png", 0, 0, 0, 0, 32, 32);
		Dir = 'U';
	}
	
	public void draw(SpriteBatch Screen)
	{
		if (IsShooting == true)
		{
			super.draw(Screen);
		}
	}
	
	public void shoot(double x, double y, char Dir)
	{
		if (IsShooting == false)
		{
			super.setPos(x, y);
			IsShooting = true;
			IsDead = true;
		}
		this.Dir = Dir;
	}
	
	public void update()//subtracts from the max bullets in player class
	{
		if (IsShooting == true) 
		{
			super.move(Dir, 5);
		}
		
		if (super.returnPos().y > 512 || super.returnPos().y < 0 || super.returnPos().x < 0 || super.returnPos().x > 512)
		{
			IsShooting = false;
		}
	}
	
	public void setIsDead(boolean dead)
	{
		IsDead = dead;
	}
	
	public boolean IsDead()
	{
		return IsDead;
	}
	
	public boolean IsShooting()
	{
		return IsShooting;
	}
}
