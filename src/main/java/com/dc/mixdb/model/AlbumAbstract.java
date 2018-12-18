package com.dc.mixdb.model;

import com.dc.mixdb.enumeration.AlbumTypeEnum;

/**
 * Abstract class containing implementation of types and methods common to all albums
 * @author d_clo
 *
 */
public class AlbumAbstract {
	private String artist, title;
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return new StringBuilder().
				append(getArtist()).append(";").
				append(getTitle()).append(";").toString();
	}
	
	
}