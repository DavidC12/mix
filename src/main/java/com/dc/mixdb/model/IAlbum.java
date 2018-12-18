package com.dc.mixdb.model;

import com.dc.mixdb.enumeration.AlbumTypeEnum;

public interface IAlbum {
	public String getArtist();
	public void setArtist(String artist);
	public String getTitle();
	public void setTitle(String title);
	public AlbumTypeEnum getAlbumType();
}
