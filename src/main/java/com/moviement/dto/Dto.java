package com.moviement.dto;

import java.util.HashMap;
import java.util.Map;

import com.moviement.util.Util;

public class Dto {
	public int id;
	public String regDate;
	private HashMap<Object, Object> extra;

	public Dto() {
		this(0, Util.getNowDateStr());
	}

	public Dto(int id, String regDate) {
		this(id, regDate, new HashMap<>());
	}

	public Dto(int id, String regDate, HashMap<Object, Object> extra) {
		this.id = id;
		this.regDate = regDate;
		this.extra = extra;
	}

	public Dto(Map<String, Object> row) {
		this((int) row.get("id"), (String) row.get("regDate"));

		for (String key : row.keySet()) {
			if (key.startsWith("extra__")) {
				String extraKey = key.replace("extra__", "");
				Object extraValue = row.get(key);
				extra.put(extraKey, extraValue);
			}
		}
	}
}