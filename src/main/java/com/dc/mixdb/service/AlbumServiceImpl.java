package com.dc.mixdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.dc.mixdb.enumeration.Constants;
import com.dc.mixdb.model.IAlbum;
import com.dc.mixdb.repository.AlbumRepository;

@Service(Constants.ALBUM_SERVICE)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AlbumServiceImpl implements IAlbumService {

	private AlbumRepository albumRepository;
	
	@Autowired
	private void setAlbumRepository(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}
	
	@Override
	public List<IAlbum> findAll() {
		return albumRepository.findAll();
	}
}
