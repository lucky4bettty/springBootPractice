package net.javaguides.springboot.model;

import java.sql.Timestamp;

public class ManagerRole {

	private String id;
	private String name;
	private String status;
	private String creator;
	private Timestamp create_time;
	private String modifier;
	private Timestamp modify_time;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return the create_time
	 */
	public Timestamp getCreate_time() {
		return create_time;
	}
	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier;
	}
	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	/**
	 * @return the modify_time
	 */
	public Timestamp getModify_time() {
		return modify_time;
	}
	/**
	 * @param modify_time the modify_time to set
	 */
	public void setModify_time(Timestamp modify_time) {
		this.modify_time = modify_time;
	}
}
