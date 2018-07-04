package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

import testDataTypes.Customer;
import manager.FileReaderManager;

public class JsonFileReader {

	
	private final String customerFilePath=FileReaderManager.getInstance().getConfFileReader().getTestDataResourcePath();
	private List<Customer> customerList;
	
	public JsonFileReader(){
		
		customerList=getCustomerData();
	}

	private List<Customer> getCustomerData() {
		
		Gson gson=new Gson();
		
		BufferedReader bufferedReader =null;
		Customer [] customers=null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(customerFilePath));
			
			 customers=gson.fromJson(bufferedReader, Customer[].class);
			
			
		
		} catch (FileNotFoundException e) {


			e.printStackTrace();
		}
	
		return Arrays.asList(customers);
	}
	
	
	public final Customer getCustomerByName(String customerName){
		
		Iterator<Customer> iterator=customerList.iterator();
		
		
		for(Customer customer : customerList) {
			if(customer.firstName.equalsIgnoreCase(customerName)) return customer;
		}
		return null;
		
			
		
		//customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}
}		
