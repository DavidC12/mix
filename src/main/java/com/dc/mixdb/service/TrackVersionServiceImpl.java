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

}
