package com.example.web.resources;

import java.io.Serializable;
import java.util.List;

import com.example.core.model.User;

public class ResultSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<User> elements;
	private Long total;

	private ResultSet(final List<User> set, final Long total) {
		super();
		this.elements = set;
		this.total = total;
	}

	public static ResultSet createResultSet(final List<User> set,
			final Long total) {
		ResultSet resultSet = new ResultSet(set, total);
		return resultSet;
	}

	public List<User> getElements() {
		return elements;
	}

	public Long getTotal() {
		return total;
	}
}
