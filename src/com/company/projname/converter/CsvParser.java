package com.company.projname.converter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.company.projname.model.Page;
import com.company.projname.util.Constants;

public class CsvParser implements Parsable{

	private List<Page> pageList;

	public CsvParser() {
		this.pageList = new ArrayList<Page>();
	}

	@Override
	public List<Page> parse(InputStream inputStream){
		int nRow = 0;
		String line = "";
		BufferedReader br = null;
		String splitBy = ",";
		try {
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			br = new BufferedReader(streamReader);
			br.readLine();
			while ((line = br.readLine()) != null) {
				nRow++;
				String[] pages = line.split(splitBy);
				Page pageObject = new Page();
				pageObject.setRow(new Integer(nRow).toString());
				pageObject.setDomain(cutQuotes(pages[0]));
				pageObject.setDate(formatDate(cutQuotes(pages[1])));
				pageObject.setPlUrls((int) Float.parseFloat(cutQuotes(pages[2])));
				pageObject.setViews(Integer.parseInt(cutQuotes(pages[3])));
				pageObject.setClicks(Integer.parseInt(cutQuotes(pages[4])));
				pageObject.setCtr(Float.parseFloat(cutQuotes(pages[5])));
				pageObject.setRevenue(Float.parseFloat(cutQuotes(pages[6])));
				pageObject.setEpc(Float.parseFloat(cutQuotes(pages[7])));
				pageObject.setRpm(Float.parseFloat(cutQuotes(pages[8])));
				pageObject.setPercentFinalised(Float.parseFloat(cutQuotes(pages[9])));
				pageObject.setPercentEstimate(Float.parseFloat(cutQuotes(pages[10])));
				pageObject.setPercentForecast(Float.parseFloat(cutQuotes(pages[11])));
				pageObject.setStatus(cutQuotes(pages[12]));
				pageList.add(pageObject);
			}
		//TODO: proper exception handling needed
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return pageList;
	}

	private Date formatDate(String date_s) throws ParseException {
		SimpleDateFormat parsedDate = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.US);
		return parsedDate.parse(date_s);
	}

	public String cutQuotes(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '"') {
				sb.deleteCharAt(i);
				i--;
			}
		}
		return sb.toString();
	}

}
