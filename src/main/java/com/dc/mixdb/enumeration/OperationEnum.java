package com.dc.mixdb.enumeration;

/**
 * All controller operations that are useable for REST to be kept here.
 * @author d_clo
 */
public enum OperationEnum {
	GET_TRACK_VERSIONS("trackVersions"),
	CREATE_TRACK("createTrack");

	private String operationName;
	private OperationEnum(String operationName) {
		this.operationName = operationName;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
}
