package data;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
// ADD IN BASE TEST - SO ANY HOW WE ARE EXTENDING BASE CLASS TO ALL TEST CLASSES SO IT WILL BE ADDED WITHOUT CREATING OBJECT
	public List<HashMap<String, String>> getJsonDataToMap() throws Exception, JsonProcessingException {
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//data//loginInvalidTestData.json"), StandardCharsets.UTF_8);
		//String to hashMap - jackson data bind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){	
		});
		return data;
	}
}
