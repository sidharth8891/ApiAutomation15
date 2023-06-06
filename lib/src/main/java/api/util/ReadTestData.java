package api.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
//import com.jayway.jsonpath.JsonPath;
//import com.task.automation.util.JsonUtil;


public class ReadTestData {

    //private final static String filePath = "TestData//testdata.json";

    public static JSONObject getJsonData() throws IOException, ParseException {

        //pass the path of the testdata.json file
        File filename = new File("Resources/TestData/testdatas.json");
        //convert json file into string
        String json = FileUtils.readFileToString(filename, "UTF-8");
        //parse the string into object
        Object obj = new JSONParser().parse(json);
        //give jsonobject  that I can return it to the function everytime it get called
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }


    public static String getTestData(String keyname) throws IOException, ParseException {
        String testdata;
        //	return  testdata = JsonUtil.getData().get(input).toString();
        return testdata = (String) getJsonData().get(keyname);
    }


//	public static String getdatafromjson(String path) throws IOException {
//		
////		File f = new File("Resources//TestData//testdata.json");
////		String json = FileUtils.readFileToString(f, "UTF-8");
////		String result;
////		return result = JsonPath.read(json, path);
//		
//	}
}
