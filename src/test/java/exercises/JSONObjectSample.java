package exercises;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class JSONObjectSample {
	public static void main(String[] args) {
		createJSON();
		createJSONByMap();
		createJSONByJavaBean();
	}

	// 使用JavaBean构建json
	private static void createJSONByJavaBean() {
		// TODO Auto-generated method stub
		PersonInfo info = new PersonInfo();
		info.setName("Sam");
		info.setSex("Female");
		info.setAge(23);
		info.setHobbies(new String[] { "hiking", "swimming" });

		JSONObject obj = new JSONObject(info);
		System.out.println(obj);
	}

	// 使用HashMap构建json
	private static void createJSONByMap() {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<>();
		data.put("name", "Tom");
		data.put("age", 25);
		JSONObject obj = new JSONObject(data);
		System.out.println(obj.toString());
	}

	private static void createJSON() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		obj.put("name", "John");
		obj.put("sex", "male");
		obj.put("age", 25);
		obj.put("is_student", false);
		// 直接调用toString（）方法将内容打印出来
		System.out.println(obj.toString());
	}
}

