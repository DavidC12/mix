package com.dc.mixdb.repository;

import java.util.List;

import com.dc.mixdb.model.IAlbum;

public interface IAlbumRepository {
	public List<IAlbum> findAll();
}
