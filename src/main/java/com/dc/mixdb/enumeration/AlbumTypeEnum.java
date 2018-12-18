package com.dc.mixdb.enumeration;

public enum AlbumTypeEnum {
	MAIN_RELEASE("Main Release"),
	COMPILATION("Various Artists"),
	SOUNDTRACK("Soundtrack");
	
	private String albumType;
	private AlbumTypeEnum(String type) {
		this.albumType = type;
	}
	public String getAlbumType() {
		return albumType;
	}

}
