package com.dc.mixdb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dc.mixdb.enumeration.Constants;
import com.dc.mixdb.model.AlbumCompilation;
import com.dc.mixdb.model.AlbumMainRelease;
import com.dc.mixdb.model.IAlbum;

@Repository(Constants.ALBUM_REPOSITORY)
public class AlbumRepository implements IAlbumRepository {
	
	
	@Override
	public List<IAlbum> findAll() {
		List<IAlbum> albumsList = new ArrayList<>();
		
		AlbumCompilation ac = new AlbumCompilation();
		ac.setTitle("Some Compilation");
		albumsList.add(ac);
		
		AlbumMainRelease am = new AlbumMainRelease();
		am.setArtist("Def Leppard");
		am.setTitle("Adrenalize");
		albumsList.add(am);
		
		return albumsList;
	}


}
