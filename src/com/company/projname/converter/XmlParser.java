package com.company.projname.converter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.company.projname.model.Page;
import com.company.projname.util.Constants;

public class XmlParser extends DefaultHandler implements Parsable {

	private List<Page> pageL;
	private String tmpValue;
	private Page pageTmp;
	private SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_XML);

	public XmlParser() {
		pageL = new ArrayList<Page>();
	}

	@Override
	public List<Page> parse(InputStream inputStream) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(inputStream, this);
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error");
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed");
		} catch (IOException e) {
			System.out.println("IO error");
		}
		return pageL;
	}

	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {
		if (elementName.equalsIgnoreCase("page")) {
			pageTmp = new Page();
			pageTmp.setRow(attributes.getValue("row"));
		}
	}

	@Override
	public void endElement(String s, String s1, String element)
			throws SAXException {

		if (element.equals("page")) {
			pageL.add(pageTmp);
		}
		if (element.equalsIgnoreCase("domain")) {
			pageTmp.setDomain(tmpValue);
		}
		if (element.equalsIgnoreCase("date")) {
			try {
				pageTmp.setDate(sdf.parse(tmpValue));
			} catch (ParseException e) {
				System.out.println("date parsing error");
			}
		}
		if (element.equalsIgnoreCase("plUrls")) {
			pageTmp.setPlUrls(Integer.parseInt(tmpValue));
		}
		if (element.equalsIgnoreCase("views")) {
			pageTmp.setViews(Integer.parseInt(tmpValue));
		}
		if (element.equalsIgnoreCase("clicks")) {
			pageTmp.setClicks(Integer.parseInt(tmpValue));
			;
		}
		if (element.equalsIgnoreCase("ctr")) {
			pageTmp.setCtr(Float.parseFloat(tmpValue));
		}
		if (element.equalsIgnoreCase("revenue")) {
			pageTmp.setRevenue(Float.parseFloat(tmpValue));
		}
		if (element.equalsIgnoreCase("epc")) {
			pageTmp.setEpc(Float.parseFloat(tmpValue));
		}
		if (element.equalsIgnoreCase("rpm")) {
			pageTmp.setRpm(Float.parseFloat(tmpValue));
		}
		if (element.equalsIgnoreCase("percentFinalised")) {
			pageTmp.setPercentFinalised(Float.parseFloat(tmpValue));
		}
		if (element.equalsIgnoreCase("percentEstimate")) {
			pageTmp.setPercentEstimate(Float.parseFloat(tmpValue));
		}
		if (element.equalsIgnoreCase("percentForecast")) {
			pageTmp.setPercentForecast(Float.parseFloat(tmpValue));
		}
		if (element.equalsIgnoreCase("Status")) {
			pageTmp.setStatus(tmpValue);
		}
	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		tmpValue = new String(ac, i, j);
	}

}
