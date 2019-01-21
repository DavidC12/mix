package com.dc.mixdb.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Model for trackVersion
 * 
 * A track version is a track that exists irrespective of how it's packaged 
 * (ie. on an album, as a single, as part of a compilation, etc)
 * 
 * @author d_clo
 *
 */
public class TrackVersion {
	private Integer id;
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
	private Integer rating;
	private Date ratingDate;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().
				append("ID - ").append(this.getId()).append(";").
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
				append("Rating - ").append(this.getRating()).append(";").
				append("Rating Date - ").append(this.getRatingDate()).append(";").
				append("Comment - ").append(this.getComment()).append(";");
		return sb.toString();
	}
	
	//All of the getters and setters......
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
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getRatingDate() {
		return ratingDate;
	}
	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
