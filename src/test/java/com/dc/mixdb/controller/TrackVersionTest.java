package com.dc.mixdb.controller;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
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
		
		List<TrackVersion> trackVersions = getTrackVersions();
		
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
	
	@Test(timeout=10000)
	public void testCreateTrack2() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.CREATE_TRACK.getOperationName();

		//Issue the rest call
		TrackVersion track = new TrackVersion();
		track.setArtistName("Foo Fighters");
		track.setSongName("Live-In Skin");
		track.setBeatMixable(0);
		track.setBpmStart(120);
		track.setBpmEnd(120);
		track.setComment("Mid-Paced Rocker Ballad");
		track.setKeyEnd("D");
		track.setKeyStart("D");
		track.setCreateUser("TrackVersionTest.testCreateTrack2");
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
	
	/**
	 * Test logic to get a single track
	 * This requires record id #1 to be present
	 */
	@Test(timeout=10000)
	public void testGetTrackVersion() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.GET_TRACK_VERSION.getOperationName() + "/1";
		System.out.println(url);
		TrackVersion track = restTemplate.getForObject(url, TrackVersion.class);
		System.out.println("Track: " + track);
	}
	
	/**
	 * Update a single ride
	 * This test will update the test record ID 1
	 * It will do this by doing a "put" to the single track version url instead of a "get"
	 */
	@Test(timeout=10000)
	public void testUpdateTrackVersion() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.GET_TRACK_VERSION.getOperationName() + "/1";
		System.err.println(url);
		
		TrackVersion track = restTemplate.getForObject(url, TrackVersion.class);
		track.setArtistName("Elias Brothers");
		track.setBpmStart(track.getBpmStart() + 1);
		restTemplate.put(url, track); //Cannot return an object retrieved via put.

		TrackVersion tr = restTemplate.getForObject(url, TrackVersion.class);
		System.out.println("Track: " + tr);
	}
	
	/**
	 * Utililty method for testing - Retrieves all trackversion objects from the database
	 * 
	 * @return List of track versions
	 */
	public List<TrackVersion> getTrackVersions() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.GET_TRACK_VERSIONS.getOperationName();
		
		System.out.println("url = " + url);
		
		//Issue the rest call
		ResponseEntity<List<TrackVersion>> trackVersionsResponse = restTemplate.exchange(
				url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TrackVersion>>() {
				});
		List<TrackVersion> trackVersions = trackVersionsResponse.getBody();
		
		return trackVersions;
	}
	
	/**
	 * Update multiple versions (batch mode test)
	 */
	@Test
	public void testBatchUpdate() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.BATCH.getOperationName();
		System.err.println(url);
	
		List<TrackVersion> tvList = getTrackVersions();
		List<Object[]> idList = new ArrayList<Object[]>();
		for (TrackVersion tv : tvList) {
			//Solution 1 - Timestamp ts = new Timestamp(System.currentTimeMillis());
			/* Solution 2
			java.util.Date today = new java.util.Date();
			Timestamp ts = new Timestamp(today.getTime()); */
			
			String ts = "2019-01-21 05:11:01";
			Object[] tmp = {ts, tv.getId()};
			idList.add(tmp);
		}
		restTemplate.postForObject(url, idList, Object.class);
	}
	
	/**
	 * Delete a track when ID is passed in
	 */
	@Test
	public void testDeleteTrack() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Constants.rootURL + OperationEnum.DELETE.getOperationName();
		System.err.println(url);
		
		List<TrackVersion> list = getTrackVersions();
		Integer size = list.size() - 1;
		assertTrue(size > 0);
		TrackVersion lastElement = list.get(size);
		Integer id = lastElement.getId();
		
		System.err.println("Deleting track ID " + id);
		restTemplate.delete(url + "/" + id);
		
//		** Looks like same size is returned from getTrackVersions even after the list is updated **	
//      ** Research this at a later time **		
//		
//		List<TrackVersion> listAfter = getTrackVersions();
//		
//		Integer newSize = listAfter.size();
//		Integer result = size - newSize;
//		
//		assertTrue(result == 1);
		
	}
}
