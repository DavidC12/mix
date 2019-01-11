package com.dc.mixdb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dc.mixdb.model.TrackVersion;
import com.dc.mixdb.repository.util.TrackVersionRowMapper;

@Repository("trackVersionRepository")
public class TrackVersionRepositoryImpl implements TrackVersionRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Implement the sql which will generate the fields for the "rowmapper" class to
	 * map to the fields of the TrackVersion object
	 */
	@Override
	public List<TrackVersion> getTrackVersions() {

		String query = "SELECT idtrack_version, create_timestamp, update_timestamp, create_user, update_user, artist_name, song_name, remix_name, beat_mixable, bpm_start, bpm_end, key_start, key_end, comment FROM mixdb.track_version; "; 
		List<TrackVersion> trackVersions = jdbcTemplate.query(query, new TrackVersionRowMapper());
		return trackVersions;
	}

}
