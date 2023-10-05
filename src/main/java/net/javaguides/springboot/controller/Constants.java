package net.javaguides.springboot.controller;

public class Constants {
	
	public static String LOGIN_PAGE = "/admin/login";
	public static String ADMIN_INDEX_URI = "/admin/index";
	public static String ADMIN_SN = "1";

	// 啟用狀態 1:啟用 0:停用
	public static String STATUS_ENABLE = "1";
	public static String STATUS_DISABLE = "0";
	
	// 開啟方式 1:原視窗開啟  0:另開新視窗
	public static String OPENING_METHOD_ENABLE = "1";
	public static String OPENING_METHOD_DISABLE = "0";

	// 功能代碼
	public static String INDEX_TASK_KEY = "00001";// 後臺首頁
	public static String ROLE_TASK_KEY = "00101";// 角色管理
	public static String MANAGER_TASK_KEY = "00102";// 帳號管理
	public static String NEWS_TASK_KEY = "00201";// 最新消息	
	public static String HG_WEBSITE_HEADER = "00301";// Header管理
	public static String HG_WEBSITE_FOOTER = "00302";// Footer管理
	public static String HG_MENU_MAIN_LIST = "00401";// 主選單
	public static String HG_MENU_SUB_LIST = "00402";// 次選單

}
