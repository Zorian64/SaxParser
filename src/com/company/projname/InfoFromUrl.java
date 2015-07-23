package com.company.projname;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.company.projname.converter.CsvParser;
import com.company.projname.converter.Parsable;
import com.company.projname.converter.XmlParser;
import com.company.projname.model.Page;
import com.company.projname.model.RequestFormat;
import com.company.projname.util.Constants;

public class InfoFromUrl {
		
	public List<Page> getList(RequestFormat format, Date date) throws Exception {
		URLConnection connection = getConnection(format, date);
		Parsable parser = getParser(format);
		return parser.parse(connection.getInputStream());
	}

	private URLConnection getConnection(RequestFormat format, Date date) throws MalformedURLException, IOException {
		String link = createLink(format, date);
		
		URL url = new URL(link);
		URLConnection connection = url.openConnection();
		return connection;
	}

	private String createLink(RequestFormat format, Date date) {
		String newDate = new SimpleDateFormat(Constants.DATE_FORMAT_URL).format(date);
		return Constants.STATIC_LINK_ADRESS + format + "&date=" + newDate;
	}

	private Parsable getParser(RequestFormat format) {
		switch(format){
		case csv:
			return new CsvParser();
		case xml:
			return new XmlParser();
		default:
			return null;
		}
	}

}
