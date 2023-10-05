package net.javaguides.springboot;

import java.util.Arrays;

public class Test {
	private String id;
	private String name;
	private String status;
	private String[] tasksAry;
	private String[] parentItems;
	private String[] ids;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getTasksAry() {
		return tasksAry;
	}
	public void setTasksAry(String[] tasksAry) {
		this.tasksAry = tasksAry;
	}
	public String[] getParentItems() {
		return parentItems;
	}
	public void setParentItems(String[] parentItems) {
		this.parentItems = parentItems;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", status=" + status + ", tasksAry=" + Arrays.toString(tasksAry)
				+ ", parentItems=" + Arrays.toString(parentItems) + ", ids=" + Arrays.toString(ids) + "]";
	}

}
