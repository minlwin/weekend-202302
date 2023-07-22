package com.jdc.demo.binding.domain.dto.form;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.Feature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;

	private String feature;
	
	public static FeatureForm from(Feature entity) {
		return new FeatureForm(entity.getName(), entity.getFeature());
	}
	
	public Feature entity() {
		return new Feature(name, feature);
	}

}
