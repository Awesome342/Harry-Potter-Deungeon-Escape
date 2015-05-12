package com.Racer;

public class Object {
	private Rect Pos;
	private int Map;
	private boolean IsColliding;
	private boolean XColliding;
	private boolean YColliding;
	private boolean RightColliding;
	private boolean LeftColliding;
	private boolean Destructable;
	private boolean Destroyed;
	private boolean EnemyLineColl;
	
	public Object(int x, int y, int w, int h, int map, boolean Destructable)
	{
		this.Pos = new Rect(x, y, w, h);
		this.Map = map;
		IsColliding = false;
		XColliding = false;
		YColliding = false;
		RightColliding = false;
		LeftColliding = false;
		this.Destructable = Destructable;
		Destroyed = false;
	}
	
	public Object(int x, int y, int w, int h, int map)
	{
		this.Pos = new Rect(x, y, w, h);
		this.Map = map;
		IsColliding = false;
		XColliding = false;
		YColliding = false;
		RightColliding = false;
		LeftColliding = false;
		this.Destructable = false;
		Destroyed = false;
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
	public boolean XCollision( Rect A, Rect B )
	{
		if (( A.x + A.w > B.x &&
			 A.x < B.x + B.w ))
			{
				return true;
			}
			else 
			{
				return false;
			}
	}
	
	public boolean YCollision( Rect A, Rect B )
	{
		if ( A.y + A.h > B.y &&
			 A.y < B.y + B.h )
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void destroy()
	{
		if (Destructable == true)
		{
			Destroyed = true;
		}
	}
	
	public void checkDir(Player Hero, Rect Player, int Dir)
	{	
		if (Hero.returnDir() == 'R')
		{
			Player.x -= 4;
		}
		else if (Hero.returnDir() == 'L')
		{
			Player.x += 4;
		}
		else if (Hero.returnDir() == 'D')
		{
			Player.y += 4;
		}
		else if (Hero.returnDir() == 'U')
		{
			Player.y -= 4;
		}
		
	}
/*
	public void checkBullets(SentryManager Sentry)
	{
		if (IsCollision(Sentry.returnSentry(1).returnBulletPos(), Pos))
		{
			Sentry.returnSentry(1).resetBullet();
		}
	}
	
	public void checkDestroyed(Player Hero)
	{
		if (IsCollision(Hero.returnPos(), Pos) && Hero.returnIsAttacking())
		{
			destroy();
		}
		if (IsCollision(Hero.returnKnife().returnPos(), Pos))
		{
			destroy();
		}
	}
*/
	public void checkColl(Player Hero, int Dir, int currentMap, boolean IsWarp)
	{
		//checkDestroyed(Hero);
		if (IsCollision(Hero.returnPos(), Pos) && currentMap == Map && Destroyed == false)
		{
			checkDir(Hero, Hero.returnPos(), Dir);	
		}
		
		//checkBullets(Sentry);
	}
	
	public void checkColl(Player Hero, int Dir, int currentMap)
	{
		//checkDestroyed(Hero);
		if (IsCollision(Hero.returnPos(), Pos) && currentMap == Map && Destroyed == false)
		{
			checkDir(Hero, Hero.returnPos(), Dir);	
		}
		
		//checkBullets(Sentry);
	}
	
	public void setDestroyed(boolean newBool)
	{
		Destroyed = newBool;
	}
	
	public boolean returnIsColliding()
	{
		return IsColliding;
	}
	
	public boolean returnXColliding()
	{
		return XColliding;
	}
	
	public boolean returnYColliding()
	{
		return YColliding;
	}
	
	public boolean returnRightColliding()
	{
		return RightColliding;
	}
	
	public boolean returnLeftColliding()
	{
		return LeftColliding;
	}
	
	public Rect returnPos()
	{
		return Pos;
	}
	
	public boolean returnIsDestroyed()
	{
		return Destroyed;
	}
}
