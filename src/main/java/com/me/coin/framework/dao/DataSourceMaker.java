package com.me.coin.framework.dao;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.me.coin.framework.util.PropertyUtils;

/**
 * 数据库连接池maker
 * @author dwl
 *
 */
public class DataSourceMaker {
	
	private final String DRIVER = PropertyUtils.getProperty("jdbc.driver");
	private final String JDBC_URL = PropertyUtils.getProperty("jdbc.url");
	private final String NAME = PropertyUtils.getProperty("jdbc.username");
	private final String PASSWORD = PropertyUtils.getProperty("jdbc.password");
	
	private final int INIT_SIZE = Integer.parseInt(PropertyUtils.getProperty("jdbc.initialSize", "10"));
	private final int MAX_IDLE = Integer.parseInt(PropertyUtils.getProperty("jdbc.maxIdle", "10"));
	private final int MAX_ACTIVE = Integer.parseInt(PropertyUtils.getProperty("jdbc.maxActive", "20"));
	private final long MAX_WAIT = Long.parseLong(PropertyUtils.getProperty("jdbc.maxWait", "2000"));
	private final String VALIDATION_QUERY = PropertyUtils.getProperty("jdbc.validationQuery", "select 1");
	
	private DataSource dataSource;
	
	private static DataSourceMaker maker = null;
	
	
	private DataSourceMaker(){
		dataSource = init();
	}
	
	public static DataSourceMaker getInstance(){
		if(null == maker){
			synchronized (DataSourceMaker.class) {
				if(null == maker)
					maker = new DataSourceMaker();
			}
		}
		return maker;
	}
	
	
	private DataSource init(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(JDBC_URL);
		dataSource.setUsername(NAME);
		dataSource.setPassword(PASSWORD);
		//初始化连接
		dataSource.setInitialSize(INIT_SIZE);
		//最小连接数
		dataSource.setMinIdle(MAX_IDLE);
		//最大活跃数
		dataSource.setMaxActive(MAX_ACTIVE);
		//等待超时时间
		dataSource.setMaxWait(MAX_WAIT);
		//测试连接是否可用
		dataSource.setTestOnBorrow(true);
		//恢复连接
		dataSource.setValidationQuery(VALIDATION_QUERY);
		return dataSource;
	}
	
	
	public DataSource getDataSource(){
		return dataSource;
	}

}
