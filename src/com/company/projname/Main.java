package com.company.projname;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.company.projname.model.Page;
import com.company.projname.model.RequestFormat;
import com.company.projname.util.Constants;

public class Main {

	public static void main(String[] args) throws Exception {
		String dateStr = "2015-05-16";
		RequestFormat format = RequestFormat.csv;

		Date date = new SimpleDateFormat(Constants.DATE_FORMAT_URL).parse(dateStr);

		List<Page> pages = new InfoFromUrl().getList(format, date);

		for (Page page : pages) {
			System.out.println(page);
		}
		
		System.out.println("From " + format + " URL file!");
	}
}
