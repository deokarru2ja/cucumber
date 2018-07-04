package manager;

import dataProvider.ConfFileReader;
import dataProvider.JsonFileReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager= new FileReaderManager();
	private static ConfFileReader confFileReader;
	private static JsonFileReader jsonFileReader;
	
	
	private FileReaderManager(){
		
	}
	
	public static FileReaderManager getInstance(){
		return fileReaderManager;
			
	}
	
	public ConfFileReader getConfFileReader(){
		
		return (confFileReader==null)? new ConfFileReader():confFileReader;
		
	}
	
	public JsonFileReader getJsonFileReader(){
		
		return (jsonFileReader == null)? new JsonFileReader():jsonFileReader;
	}
	
	

}
