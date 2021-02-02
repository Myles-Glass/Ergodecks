package com.glass.ergodecks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbl_activecard")
public class ActiveCard {
	


	@Id
	@Column
	private String active_id;
	
	@Column
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String image_urissmall;
	
	@Column
	private String image_urisnormal;
	
	@Column
	private String mana_cost;
	
	@Column
	private String type_line;
	
	@Column
	private String rarity;
	
	@Column
	private String color_identity0;
	
	@Column
	private String set_name;
	
	@Column
	private String released_at;
	
	@Column
	private String pricesusd;
	
	@Column
	private int pos_x;
	
	@Column
	private int pos_y;
	
	@Column
	private int z_index;
	

	
	@Override
	 public String toString() {
	  return "id=" + id + "\ncard name=" + name + "\nnormal Image=" + image_urisnormal;
	 }

	public String getActive_id() {
		return active_id;
	}


	public void setActive_id(String active_id) {
		this.active_id = active_id;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage_urisnormal() {
		return image_urisnormal;
	}


	public void setImage_urisnormal(String image_urisnormal) {
		this.image_urisnormal = image_urisnormal;
	}


	public String getImage_urissmall() {
		return image_urissmall;
	}


	public void setImage_urissmall(String image_urissmall) {
		this.image_urissmall = image_urissmall;
	}


	public String getMana_cost() {
		return mana_cost;
	}


	public void setMana_cost(String mana_cost) {
		this.mana_cost = mana_cost;
	}


	public String getType_line() {
		return type_line;
	}


	public void setType_line(String type_line) {
		this.type_line = type_line;
	}


	public String getRarity() {
		return rarity;
	}


	public void setRarity(String rarity) {
		this.rarity = rarity;
	}


	public String getColor_identity0() {
		return color_identity0;
	}


	public void setColor_identity0(String color_identity0) {
		this.color_identity0 = color_identity0;
	}


	public String getSet_name() {
		return set_name;
	}


	public void setSet_name(String set_name) {
		this.set_name = set_name;
	}


	public String getReleased_at() {
		return released_at;
	}


	public void setReleased_at(String released_at) {
		this.released_at = released_at;
	}


	public String getPricesusd() {
		return pricesusd;
	}


	public void setPricesusd(String pricesusd) {
		this.pricesusd = pricesusd;
	}
	
	public int getPos_x() {
		return pos_x;
	}


	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}
	
	public int getPos_y() {
		return pos_y;
	}


	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
	
	public int getZ_index() {
		return z_index;
	}


	public void setZ_index(int z_index) {
		this.z_index = z_index;
	}
}
