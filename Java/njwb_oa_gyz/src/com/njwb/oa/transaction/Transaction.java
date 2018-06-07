package com.njwb.oa.transaction;

/**
 * 事务接口
 * @author Administrator
 *
 */
public interface Transaction {
	/**
	 * 开启事务
	 */
	public abstract void begin();
	
	/**
	 * 提交事务
	 */
	public abstract void commit();
	
	/**
	 * 回滚事务
	 */
	public abstract void rollback();
}
