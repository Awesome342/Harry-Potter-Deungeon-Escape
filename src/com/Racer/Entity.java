package com.Racer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Entity {
	private Texture Img;
	private TextureRegion Clip;
	private Rect Pos;
	protected int clipx, clipy;
	private Sprite sprite;
	
	public Entity(String filename, int x, int y, int clipx, int clipy, int w, int h)
	{
		Img = new Texture(filename);
		Pos = new Rect(x, y, w, h);
		Clip = new TextureRegion(Img, clipx, clipy, w, h);
		sprite = new Sprite(Img);
	}
	
	public void draw(SpriteBatch batch)
	{
		batch.draw(Clip, (int)Pos.x, (int)Pos.y);
	}
	
	public void setClip(int clipx, int clipy, int w, int h)
	{
		Clip = new TextureRegion(Img, clipx, clipy, w, h);
	}
	
	public void move(char dir, double speed)
	{
		if (dir == 'R')
		{
			Pos.x += speed;
		}
		else if (dir == 'L')
		{
			Pos.x -= speed;
		}
		else if (dir == 'U')
		{
			Pos.y += speed;
		}
		else if (dir == 'D')
		{
			Pos.y -= speed;
		}
	}
	
	public void scale(int neww, int newh)
	{
		
	}
	
	public boolean IsCollision( Rect A, Rect B )
	{
		if ( A.x + A.w > B.x &&
			 A.x < B.x + B.w &&
			 A.y + A.h > B.y &&
			 A.y < B.y + B.h )
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean IsCollision( Rect B )
	{
		if ( Pos.x + Pos.w > B.x &&
				Pos.x < B.x + B.w &&
				Pos.y + Pos.h > B.y &&
				Pos.y < B.y + B.h )
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean IsCollisionTop ( Rect A, Rect B )//Block, Player
	{
		B.h = 32;
		if ( A.x + A.w > B.x &&
			 A.x < B.x + B.w &&
			 A.y + A.h > B.y &&
			 A.y < B.y + B.h )
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void setPos(int x, int y)
	{
		Pos.x = x;
		Pos.y = y;
	}
	
	public void setPos(double x, double y)
	{
		Pos.x = x;
		Pos.y = y;
	}
	
	public void setX(int x)
	{
		Pos.x = x;
	}
	
	public void setY(int y)
	{
		Pos.y = y;
	}
	
	public Rect returnPos()
	{
		return Pos;
	}
}
