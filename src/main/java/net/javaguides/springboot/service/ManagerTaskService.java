package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.ManagerTask;

public class ManagerTaskService {

	/**
	 * 比對功能
	 * 
	 * @param parentTasks
	 * @param id
	 * @return Task
	 */
	public static ManagerTask findTask(List<ManagerTask> parentTasks, String id) {
		for (ManagerTask parentTask : parentTasks) {
			if (parentTask.getId().equals(id)) {
				return parentTask;
			} else {
				if (parentTask.getChilds() != null) {
					ManagerTask task = findTask(parentTask.getChilds(), id);
					if (task != null)
						return task;
				}
			}
		}
		return null;
	}
	
}
