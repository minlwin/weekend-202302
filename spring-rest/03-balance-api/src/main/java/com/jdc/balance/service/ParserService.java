package com.jdc.balance.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.balance.utils.exceptions.BalanceBusinessException;

@Service
public class ParserService {
	
	public List<String> parse(MultipartFile file) {
		var list = new ArrayList<String>();
		
		try(var reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while(null != (line = reader.readLine()))
				list.add(line);
			
		} catch (Exception e) {
			throw new BalanceBusinessException("File Upload Error");
		}
		
		return list;
	}

}
