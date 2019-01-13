package com.dc.mixdb.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dc.mixdb.enumeration.Constants;
import com.dc.mixdb.enumeration.OperationEnum;
import com.dc.mixdb.model.TrackVersion;

public class TrackVersionTest {

	/**
	 * Test logic to retrieve a list of tracks
	 */
	@Test(timeout=10000)
	public void testGetTracks() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.GET_TRACK_VERSIONS.getOperationName();
		
		System.out.println("url = " + url);
		
		//Issue the rest call
		ResponseEntity<List<TrackVersion>> trackVersionsResponse = restTemplate.exchange(
				url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TrackVersion>>() {
				});
		List<TrackVersion> trackVersions = trackVersionsResponse.getBody();
		
		for (TrackVersion trackVersion : trackVersions) {
			System.out.println("Version: " + trackVersion.toString());
		}
	}
	
	/**
	 * Test logic to create a track - All fields provided
	 */
	@Test(timeout=10000)
	public void testCreateTrack() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.CREATE_TRACK.getOperationName();

		//Issue the rest call
		TrackVersion track = new TrackVersion();
		track.setArtistName("The Bee Gees");
		track.setSongName("More Than a Woman");
		track.setBeatMixable(0);
		track.setBpmStart(108);
		track.setBpmEnd(108);
		track.setComment("The John Travolta Dance Contest");
		track.setKeyEnd("G");
		track.setKeyStart("E");
		track.setCreateUser("TrackVersionTest.testCreateTrack");
		Timestamp currentTimestamp = new Timestamp(new java.util.Date().getTime());
		track.setCreateTimestamp(currentTimestamp);
		track.setUpdateUser(track.getCreateUser());
		track.setUpdateTimestamp(track.getCreateTimestamp());
		track.setRating(4);
		java.util.Date dateJ = new java.util.Date();
		Date date = new Date(dateJ.getTime());
		track.setRatingDate(date);
		track.setRemixName("ALBUM");
		track = restTemplate.postForObject(url, track, TrackVersion.class);
	}
}
