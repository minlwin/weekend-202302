package com.jdc.demo.service;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DaysOfWeekService {

	public List<DayOfWeek> getAll() {
		return List.of(DayOfWeek.values());
	}
}
