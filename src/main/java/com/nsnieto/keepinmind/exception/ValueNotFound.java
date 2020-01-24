package com.nsnieto.keepinmind.exception;

import org.apache.commons.lang3.StringUtils;

public class ValueNotFound extends Exception {

	private static final long serialVersionUID = 7465105092697165050L;

	public ValueNotFound(String value ) {

		super(StringUtils.center(value+" not found", 4));
	}
}
