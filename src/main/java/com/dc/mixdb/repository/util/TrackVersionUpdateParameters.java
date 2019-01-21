package com.dc.mixdb.repository.util;

import java.sql.Timestamp;

/**
 * Created to support batch updates of the update timestamp
 * @author d_clo
 */
public class TrackVersionUpdateParameters {
	public TrackVersionUpdateParameters(Integer id, Timestamp updateTimestamp) {
		this.id = id;
		this.updateTimestamp = updateTimestamp;
	}
	private Integer id;
	private Timestamp updateTimestamp;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
}
