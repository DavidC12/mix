package com.dc.mixdb.model;

import com.dc.mixdb.enumeration.AlbumTypeEnum;

public class AlbumCompilation extends AlbumAbstract implements IAlbum {

	@Override
	public AlbumTypeEnum getAlbumType() {
		return AlbumTypeEnum.COMPILATION;
	}

	@Override
	public String getArtist() {
		return AlbumTypeEnum.COMPILATION.getAlbumType();
	}
}
