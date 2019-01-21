package com.dc.mixdb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

		String query = "SELECT idtrack_version, create_timestamp, update_timestamp, create_user, update_user, artist_name, song_name, remix_name, beat_mixable, bpm_start, bpm_end, key_start, key_end, rating, rating_date, comment FROM mixdb.track_version; ";
		List<TrackVersion> trackVersions = jdbcTemplate.query(query, new TrackVersionRowMapper());
		return trackVersions;
	}

	/**
	 * Get a single track
	 */
	@Override
	public TrackVersion getTrackVersion(Integer id) {

		String query = "SELECT idtrack_version, create_timestamp, update_timestamp, create_user, update_user, artist_name, song_name, remix_name, beat_mixable, bpm_start, bpm_end, key_start, key_end, rating, rating_date, comment FROM mixdb.track_version where idtrack_version = ?";
		TrackVersion trackVersion = jdbcTemplate.queryForObject(query, new TrackVersionRowMapper(), id);
		return trackVersion;
	}

	/**
	 * Create a new track version
	 */
	@Override
	public TrackVersion createTrackVersion(TrackVersion track) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				StringBuilder sql = new StringBuilder().append("insert into mixdb.track_version ").append("(")
						.append("create_timestamp,").append("update_timestamp,").append("create_user,")
						.append("update_user,").append("artist_name,").append("song_name,").append("remix_name,")
						.append("beat_mixable,").append("bpm_start,").append("bpm_end,").append("key_start,")
						.append("key_end,").append("comment,").append("rating,").append("rating_date").append(")")
						.append(" values ").append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				PreparedStatement ps = con.prepareStatement(sql.toString(), new String[] { "idtrack_version" });

				ps.setTimestamp(1, track.getCreateTimestamp());
				ps.setTimestamp(2, track.getUpdateTimestamp());
				ps.setString(3, track.getCreateUser());
				ps.setString(4, track.getUpdateUser());
				ps.setString(5, track.getArtistName());
				ps.setString(6, track.getSongName());
				ps.setString(7, track.getRemixName());
				ps.setInt(8, track.getBeatMixable());
				ps.setInt(9, track.getBpmStart());
				ps.setInt(10, track.getBpmEnd());
				ps.setString(11, track.getKeyStart());
				ps.setString(12, track.getKeyEnd());
				ps.setString(13, track.getComment());
				ps.setInt(14, track.getRating());
				ps.setDate(15, track.getRatingDate());

				return ps;

			}
		}, keyHolder);

		Number id = keyHolder.getKey();

		return (getTrackVersion(id.intValue()));

	}

	@Override
	public TrackVersion updateTrackVersion(TrackVersion track) {
		System.err.println("Performing update for track " + track);
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer  sql = new StringBuffer();
				sql.append("UPDATE mixdb.track_version ");
				sql.append("SET ");
				sql.append("create_timestamp = ?,");
				sql.append("update_timestamp = ?, ");
				sql.append("create_user = ?,");
				sql.append("update_user = ?,");
				sql.append("artist_name = ?,");
				sql.append("song_name = ?,");
				sql.append("remix_name = ?,");
				sql.append("beat_mixable = ?,");
				sql.append("bpm_start = ?,");
				sql.append("bpm_end = ?, ");
				sql.append("key_start = ?,");
				sql.append("key_end = ?,");
				sql.append("rating = ?,");
				sql.append("rating_date = ?,");
				sql.append("comment = ? ");
				sql.append("WHERE idtrack_version = ?");
				
				PreparedStatement ps = con.prepareStatement(sql.toString());
				
				ps.setTimestamp(1, track.getCreateTimestamp());
				ps.setTimestamp(2, track.getUpdateTimestamp());
				ps.setString(3, track.getCreateUser());
				ps.setString(4, track.getUpdateUser());
				ps.setString(5, track.getArtistName());
				ps.setString(6, track.getSongName());
				ps.setString(7, track.getRemixName());
				ps.setInt(8, track.getBeatMixable());
				ps.setInt(9, track.getBpmStart());
				ps.setInt(10, track.getBpmEnd());
				ps.setString(11, track.getKeyStart());
				ps.setString(12, track.getKeyEnd());
				ps.setInt(13, track.getRating());
				
				if (track.getRatingDate() != null) {
					ps.setDate(14, track.getRatingDate());
				} else {
					ps.setNull(14,Types.DATE);
				}
				
				ps.setString(15, track.getComment());
				ps.setInt(16, track.getId());
				
				return ps;
			}
		});
		
		return (track);
	}

	/**
	 * Update all of the id's update dates passed in.
	 */
	@Override
	public List<Object[]> batch(List<Object[]> idList) {
		
		jdbcTemplate.batchUpdate("UPDATE mixdb.track_version set update_timestamp = ? where idtrack_version = ?",idList);
		return null;
	}
}
