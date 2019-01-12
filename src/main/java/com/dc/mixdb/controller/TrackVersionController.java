package com.dc.mixdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dc.mixdb.model.TrackVersion;
import com.dc.mixdb.service.TrackVersionService;

/**
 * This class contains all of our rest mappings
 * Controller
 * + Service
 * ++ Repository
 * @author d_clo
 */
@Controller
public class TrackVersionController {

	@Autowired
	private TrackVersionService trackVersionService;
	
	@RequestMapping(value = "/trackVersions", method = RequestMethod.GET)
	public @ResponseBody List<TrackVersion> getTrackVersions() {
		return trackVersionService.getTrackVersions();
	}

	@RequestMapping(value = "/createTrack", method = RequestMethod.POST)
	public @ResponseBody TrackVersion createTrackVersion(@RequestBody TrackVersion track) {
		return trackVersionService.createTrackVersion(track);
	}
}
