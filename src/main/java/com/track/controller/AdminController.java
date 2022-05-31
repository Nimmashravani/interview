package com.track.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.track.entity.Admin;
import com.track.service.AdminService;

@RestController
@CrossOrigin(origins = "localhost",maxAge=3600)

public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping (value="/addto")
	public Admin addCandidate(@RequestBody @Valid Admin admin) {
		return adminService.addCandidate(admin);
	}
    

	@PostMapping(value="/schedule")
	public Admin scheduleCandidateInterview(@RequestBody @Valid Admin admin ) {
	return adminService.scheduleCandidateInterview(admin);
	}

	@GetMapping(value="/share")
	public Admin shareTheCandidateWithInterviewPanel(@RequestBody @Valid Admin admin ) {
	return adminService.shareTheCandidateWithInterviewPanel(admin);
	}

}