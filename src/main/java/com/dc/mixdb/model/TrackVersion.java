package com.dc.mixdb.model;

import java.sql.Timestamp;

/**
 * SELECT `track_version`.`idtrack_version`,
    `track_version`.`create_timestamp`,
    `track_version`.`update_timestamp`,
    `track_version`.`create_user`,
    `track_version`.`update_user`,
    `track_version`.`artist_name`,
    `track_version`.`song_name`,
    `track_version`.`remix_name`,
    `track_version`.`beat_mixable`,
    `track_version`.`bpm_start`,
    `track_version`.`bpm_end`,
    `track_version`.`key_start`,
    `track_version`.`key_end`,
    `track_version`.`comment`
FROM `mixdb`.`track_version`;
 * @author d_clo
 *
 */
public class TrackVersion {
	private Timestamp createTimestamp;
	private Timestamp updateTimestamp;
	private String createUser;
	private String updateUser;
	private String artistName;
	private String songName;
	private String remixName;
	private Integer beatMixable;
	private Integer bpmStart;
	private Integer bpmEnd;
	private String keyStart;
	private String keyEnd;
	private String comment;
	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Timestamp getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getRemixName() {
		return remixName;
	}
	public void setRemixName(String remixName) {
		this.remixName = remixName;
	}
	public Integer getBeatMixable() {
		return beatMixable;
	}
	public void setBeatMixable(Integer beatMixable) {
		this.beatMixable = beatMixable;
	}
	public Integer getBpmStart() {
		return bpmStart;
	}
	public void setBpmStart(Integer bpmStart) {
		this.bpmStart = bpmStart;
	}
	public Integer getBpmEnd() {
		return bpmEnd;
	}
	public void setBpmEnd(Integer bpmEnd) {
		this.bpmEnd = bpmEnd;
	}
	public String getKeyStart() {
		return keyStart;
	}
	public void setKeyStart(String keyStart) {
		this.keyStart = keyStart;
	}
	public String getKeyEnd() {
		return keyEnd;
	}
	public void setKeyEnd(String keyEnd) {
		this.keyEnd = keyEnd;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().
				append("Artist - ").append(this.getArtistName()).append(";").
				append("Song - ").append(this.getSongName()).append(";").
				append("Remix - ").append(this.getRemixName()).append(";").
				append("BeatMixable - ").append(this.getBeatMixable()).append(";").
				append("BPM (ST) - ").append(this.getBpmStart()).append(";").
				append("BPM (EN) - ").append(this.getBpmEnd()).append(";").
				append("KEY (ST) - ").append(this.getKeyStart()).append(";").
				append("KEY (EN) - ").append(this.getKeyEnd()).append(";").
				append("Create User - ").append(this.getCreateUser()).append(";").
				append("Create Timestamp - ").append(this.getCreateTimestamp()).append(";").
				append("Update User - ").append(this.getUpdateUser()).append(";").
				append("Update Timestamp - ").append(this.getUpdateTimestamp()).append(";").
				append("Comment - ").append(this.getComment()).append(";");
		return sb.toString();
	}
	
	
}
