package com.dc.mixdb.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dc.mixdb.model.TrackVersion;

public class TrackVersionTest {
	
//	@Test(timeout=3000)
//	public void testCreateTrack() {
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		//Set up model
//		
//		//Call service to insert model
//		
//	}
	
	@Test(timeout=3000)
	public void testGetTracks() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//Issue the rest call
		ResponseEntity<List<TrackVersion>> trackVersionsResponse = restTemplate.exchange(
				"http://localhost:8080/mixdb/trackVersions", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TrackVersion>>() {
				});
		List<TrackVersion> trackVersions = trackVersionsResponse.getBody();
		
		for (TrackVersion trackVersion : trackVersions) {
			System.out.println("Version: " + trackVersion.toString());
		}
	}
	
	
	
	
	
	/*
	 * 	@Test(timeout=3000)
	public void testCreateRide() {
		RestTemplate restTemplate = new RestTemplate();
		Ride ride = new Ride();
		ride.setName("Sagebush Trail");
		ride.setDuration(33);
		
		ride = restTemplate.postForObject("http://localhost:8080/ride_tracker/ride", ride, Ride.class);
	}
	
	@Test(timeout=3000)
	public void testGetRides() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
				"http://localhost:8080/ride_tracker/rides", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ride>>() {
				});
		List<Ride> rides = ridesResponse.getBody();

		for (Ride ride : rides) {
			System.out.println("Ride name: " + ride.getName());
		}
	}
	 */

}
