package com.dc.mixdb.service;

import java.util.List;

import com.dc.mixdb.model.TrackVersion;

public interface TrackVersionService {
	
	List<TrackVersion> getTrackVersions();
	
	TrackVersion createTrackVersion(TrackVersion track);

	TrackVersion getTrackVersion(Integer id);

	TrackVersion updateTrackVersion(TrackVersion track);

	List<Object[]> batch(List<Object[]> idList);

	void deleteTrack(Integer id);

}
