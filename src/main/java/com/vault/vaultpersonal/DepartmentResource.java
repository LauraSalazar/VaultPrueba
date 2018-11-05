package com.vault.vaultpersonal;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.vault.services.DepartmentService;

@RestController
public class DepartmentResource {
	DepartmentService departmentService;

	public DepartmentResource() {
		super();
		departmentService = new DepartmentService();
	}

	@RequestMapping(value = "/insertarDepartamento/{departmentName}/{locationId}", produces = "application/json")
	public String insertar(Map<String, Object> model, @PathVariable("departmentName") String departmentName,
			@PathVariable("locationId") Integer locationId) {

		return generateJson(departmentService.insert(departmentName,locationId));
	}
	
	public String generateJson(Object aSerializableObject) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("resultingObjects", aSerializableObject);
		return new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
			@Override
			public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			    return ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime();
			}
			}).excludeFieldsWithoutExposeAnnotation().create().toJson(aMap);
	}

}
