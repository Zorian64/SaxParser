package com.company.projname.converter;

import java.io.InputStream;
import java.util.List;

import com.company.projname.model.Page;

public interface Parsable {

	public List<Page> parse(InputStream inputStream);
	
}
