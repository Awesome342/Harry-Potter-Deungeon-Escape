package com.Racer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.openal.Mp3.Music;

public class Sound {
	private Music Song = (Music) Gdx.audio.newMusic(Gdx.files.internal("data/LoveSong.mp3"));
	
	public Sound()
	{
		activate();
	}
	
	public void activate()
	{
		Song.setLooping(true);
		Song.setVolume(0.5f);
		Song.play();
	}
	
	public void setSong(String newSong)
	{
		Song = (Music) Gdx.audio.newMusic(Gdx.files.internal(newSong));
		activate();
	}
}
