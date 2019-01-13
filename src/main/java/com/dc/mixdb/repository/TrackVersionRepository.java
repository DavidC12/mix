package com.dc.mixdb.repository;

import java.util.List;

import com.dc.mixdb.model.TrackVersion;

public interface TrackVersionRepository {
	
	List<TrackVersion> getTrackVersions();
	
	TrackVersion createTrackVersion(TrackVersion track);
	
	TrackVersion getTrackVersion(Integer id);
}
