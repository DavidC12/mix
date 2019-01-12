package com.dc.mixdb.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dc.mixdb.model.TrackVersion;

public class TrackVersionRowMapper implements RowMapper<TrackVersion> {

	@Override
	public TrackVersion mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrackVersion trackVersion = new TrackVersion();
		trackVersion.setCreateTimestamp(rs.getTimestamp("create_timestamp"));
		trackVersion.setUpdateTimestamp(rs.getTimestamp("update_timestamp"));
		trackVersion.setCreateUser(rs.getString("create_user"));
		trackVersion.setUpdateUser(rs.getString("update_user"));
		trackVersion.setArtistName(rs.getString("artist_name"));
		trackVersion.setSongName(rs.getString("song_name"));
		trackVersion.setRemixName(rs.getString("remix_name"));
		trackVersion.setBeatMixable(rs.getInt("beat_mixable"));
		trackVersion.setBpmStart(rs.getInt("bpm_start"));
		trackVersion.setBpmEnd(rs.getInt("bpm_end"));
		trackVersion.setKeyStart(rs.getString("key_start"));
		trackVersion.setKeyEnd(rs.getString("key_end"));
		trackVersion.setComment(rs.getString("comment"));
		trackVersion.setRating(rs.getInt("rating"));
		trackVersion.setRatingDate(rs.getDate("rating_date"));
		return trackVersion;
	}
}
