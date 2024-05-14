package com.kosta.sample.json;

import java.util.ArrayList;

public class JTestVO {
	private String name;
	private String id;
	private DisplayName displayName;
	private ArrayList<String> types;
	private String primaryType;
	
	public JTestVO() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DisplayName getDisplayName() {
		return displayName;
	}
	
	public ArrayList<String> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	public void setDisplayName(DisplayName displayName) {
		this.displayName = displayName;
	}
	
	public String getPrimaryType() {
		return primaryType;
	}
	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
	}
}
