package com.dc.mixdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.mixdb.model.TrackVersion;
import com.dc.mixdb.repository.TrackVersionRepository;

/**
 * This class serves mainly to interface between the repository and the
 * rest controller.  For the most part it's just a pass through
 * @author d_clo
 */

@Service("trackVersionService")
public class TrackVersionServiceImpl implements TrackVersionService {

	@Autowired
	private TrackVersionRepository trackVersionRepository;
	
	@Override
	public List<TrackVersion> getTrackVersions() {
		return trackVersionRepository.getTrackVersions();
	}

	@Override
	public TrackVersion createTrackVersion(TrackVersion track) {
		return trackVersionRepository.createTrackVersion(track);
	}

	@Override
	public TrackVersion getTrackVersion(Integer id) {
		return trackVersionRepository.getTrackVersion(id);
	}

	@Override
	public TrackVersion updateTrackVersion(TrackVersion track) {
		return trackVersionRepository.updateTrackVersion(track);
	}

	@Override
	public List<Object[]> batch(List<Object[]> idList) {
		return trackVersionRepository.batch(idList);
	}

}
