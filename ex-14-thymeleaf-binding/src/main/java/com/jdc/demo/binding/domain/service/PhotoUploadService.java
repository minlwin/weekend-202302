package com.jdc.demo.binding.domain.service;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.demo.binding.domain.ShopBusinessException;

import jakarta.annotation.PostConstruct;

@Service
public class PhotoUploadService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Value("${app.photo.folder}")
	private String photoFilePath;
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyMMdd.HHmmss");

	@PostConstruct
	private void postConstruct() {
		
		try {
			var baseDirectory = Path.of(photoFilePath);
			
			if(!Files.exists(baseDirectory, LinkOption.NOFOLLOW_LINKS)) {
				Files.createDirectories(baseDirectory);
			}
			
			for(var type : Type.values()) {
				var pathForType = baseDirectory.resolve(Path.of(type.path()));
				if(!Files.exists(pathForType, LinkOption.NOFOLLOW_LINKS)) {
					Files.createDirectories(pathForType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> upload(Type type, MultipartFile ... files) {
		
		try {
			List<String> photos = new ArrayList<String>();
			for(var i = 0; i < files.length; i ++) {
				var file = files[i];
				var fileName = getFileName(i, file.getOriginalFilename());
				var photoPath = getPhotoPath(type, fileName);
				
				Files.copy(file.getInputStream(), photoPath, StandardCopyOption.REPLACE_EXISTING);
				photos.add(fileName);
			}
			
			return photos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ShopBusinessException(e.getMessage());
		}
	}
	
	private Path getPhotoPath(Type type, String fileName) {
		return Path.of(photoFilePath, type.path(), fileName);
	}
	
	private String getFileName(int index, String fileName) {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		var time = LocalDateTime.now().format(DF);
		var extension = getFileExtension(fileName);
		return "%s_%s_%d.%s".formatted(username, time, index + 1, extension);
	}

	private String getFileExtension(String fileName) {
		var array = fileName.split("\\.");
		if(array.length > 0) {
			return array[array.length - 1];
		}
		return null;
	}

	public enum Type {
		Profile, Product;
		
		public String path() {
			return this.name().toLowerCase();
		}
	}
	
}
