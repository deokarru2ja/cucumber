package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



import enums.DriverType;

public class ConfFileReader {
	
	private Properties properties;
	private final String propertyFilePath="configs//Configuration.properties";
	
	public ConfFileReader(){
		
		BufferedReader reader;
		
		try {
			reader=new BufferedReader(new FileReader(propertyFilePath));
			properties=new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
				
			System.out.println("issue in reading property file");
		}
	}
	
	public String getDriverPath(DriverType browser){
		
		String path="";
		
		switch(browser){
		case CHROME : 
			path =  properties.getProperty("chromeDriverPath");
			break;
		case FIREFOX :
			path =  properties.getProperty("firefoxDriverPath");
			break ;
			
		}
		
		return path;
		
		
	}
	
	public long getImplicitlyWait(){
		return Long.parseLong(properties.getProperty("implicitlyWait"));
	}
	
	public String getUrl(){
		return properties.getProperty("url");
	}
	
	public DriverType getBrowser() {
		String browserName=properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name invalid : " + browserName);
	}
	
	public String getTestDataResourcePath(){
		
		String testDataResourcePath= properties.getProperty("testDataResourcePath");
		
		if(testDataResourcePath!=null)return testDataResourcePath;
		
		else throw new RuntimeException("Data file path not specified");
		
	}
	
	public String getReportConfigPath(){
		
		String reportConfigPath=properties.getProperty("reportConfigPath");
		
		if(reportConfigPath!=null) return reportConfigPath;
		else throw new RuntimeException("Report config path not specified");
	}

}
