package com.me.coin.framework.orm;

import java.util.List;

/**
 * 对象映射信息
 * @author dwl
 *
 */
public class Entity {
	
	private String tableName;
	
	private Object id;
	
	private List<EntityField> entityFields;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public List<EntityField> getEntityFields() {
		return entityFields;
	}

	public void setEntityFields(List<EntityField> entityFields) {
		this.entityFields = entityFields;
	}
	
	
	
	
	
	
	

}
