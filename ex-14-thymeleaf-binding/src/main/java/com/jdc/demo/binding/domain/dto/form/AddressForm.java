package com.jdc.demo.binding.domain.dto.form;

import java.io.Serializable;

import com.jdc.demo.binding.domain.entity.Address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	@NotBlank(message = "Please enter receiver name.")
	private String name;
	
	@NotBlank(message = "Please building address.")
	private String building;
	@NotBlank(message = "Please street address.")
	private String street;
	@NotBlank(message = "Please township.")
	private String township;
	@NotBlank(message = "Please state.")
	private String state;
	
	public Address entity() {
		var entity = new Address();
		entity.setBuilding(building);
		entity.setName(name);
		entity.setStreet(street);
		entity.setTownship(township);
		entity.setState(state);
		return entity;
	}
	
	public static AddressForm from(Address entity) {
		var form = new AddressForm();
		form.id = entity.getId();
		form.name = entity.getName();
		form.building = entity.getBuilding();
		form.street = entity.getStreet();
		form.township = entity.getTownship();
		form.state = entity.getState();
		return form;
	}

}
