package com.dc.mixdb.model;

import com.dc.mixdb.enumeration.AlbumTypeEnum;

/**
 * Most typical album type - single artist or band
 * @author d_clo
 *
 */
public class AlbumMainRelease extends AlbumAbstract implements IAlbum {

	@Override
	public AlbumTypeEnum getAlbumType() {
		return AlbumTypeEnum.MAIN_RELEASE;
	}
}
