package com.veken.rxjavaretrofitdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author Veken
 */
public abstract class PreferenceUtil {

	private SharedPreferences sp;

	protected abstract Context getContext();

	public PreferenceUtil(String name) {
		sp = getContext().getSharedPreferences(name, 0);
	}

	public Editor edit() {
		return sp.edit();
	}

	/**
	 * put boolean value
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public void putBool(String key, boolean value) {
		Editor ed = sp.edit();
		ed.putBoolean(key, value);
		ed.commit();
	}

	/**
	 * get boolean value
	 * 
	 * @Description:
	 * @param key
	 * @param defValue
	 * @return
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public boolean getBool(String key, boolean defValue) {
		return sp.getBoolean(key, defValue);
	}

	public boolean getBool(String key) {
		return sp.getBoolean(key, false);
	}

	/**
	 * put int value
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public void putInt(String key, int value) {
		Editor ed = sp.edit();
		ed.putInt(key, value);
		ed.commit();
	}

	/**
	 * get int value
	 * 
	 * @Description:
	 * @param key
	 * @param defValue
	 * @return
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public int getInt(String key, int defValue) {
		return sp.getInt(key, defValue);
	}

	public int getInt(String key) {
		return sp.getInt(key, 0);
	}

	/**
	 * put long value
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public void putLong(String key, long value) {
		Editor ed = sp.edit();
		ed.putLong(key, value);
		ed.commit();
	}

	/**
	 * get long value
	 * 
	 * @Description:
	 * @param key
	 * @param defValue
	 * @return
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public long getLong(String key, long defValue) {
		return sp.getLong(key, defValue);
	}

	public long getLong(String key) {
		return sp.getLong(key, 0l);
	}

	/**
	 * put string value
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public void putString(String key, String value) {
		Editor ed = sp.edit();
		ed.putString(key, value);
		ed.commit();
	}

	/**
	 * get string value
	 * 
	 * @Description:
	 * @param key
	 * @param defValue
	 * @return
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public String getString(String key, String defValue) {
		return sp.getString(key, defValue);
	}

	public String getString(String key) {
		return sp.getString(key, "");
	}

	/**
	 * put float value
	 * 
	 * @Description:
	 * @param key
	 * @param value
	 * @see:
	 * @since:
	 * @author: huangyx2
	 * @date:2013-7-24
	 */
	public void putFloat(String key, float value) {
		Editor ed = sp.edit();
		ed.putFloat(key, value);
		ed.commit();
	}

	/**
	 * get float value
	 * 
	 * @Description:
	 * @param key
	 * @param defValue
	 * @see:
	 * @since:
	 * @author: zhangqian
	 * @date:2013-7-24
	 */
	public float getFloat(String key, float defValue) {
		return sp.getFloat(key, defValue);
	}

	public float getFloat(String key) {
		return sp.getFloat(key, 0f);
	}

	/**
	 * 删除相应的值
	 * 
	 * @param key
	 *            键名
	 */
	public void removeData(String key) {
		Editor editor = sp.edit();
		editor.remove(key);
		editor.commit();
	}
}
