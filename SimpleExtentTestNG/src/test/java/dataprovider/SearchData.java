package dataprovider;

import org.testng.annotations.DataProvider;

public class SearchData {

	
	@DataProvider(name="searchData")
	public Object[] searchData()
	{
		return new Object[] {
				"Selenium",
				"Selenium Docker",
				"Zalenium",
				"Jenkins",
				"Git",
				"Testng",
				"Maven"
		};
	}
}
