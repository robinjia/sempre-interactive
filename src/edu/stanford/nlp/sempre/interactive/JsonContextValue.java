package edu.stanford.nlp.sempre.interactive;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.stanford.nlp.sempre.ContextValue;
import edu.stanford.nlp.sempre.Json;
import fig.basic.LogInfo;

public class JsonContextValue extends ContextValue {
  Object json;
  public Object getJson() {
    return json;
  }
  
  public JsonContextValue(Object jsonString) {
    super(null, null, new ArrayList<Exchange>(), null);
    LogInfo.logs("JsonContextValue %s", jsonString);
    json = jsonString;
  }

  public static JsonContextValue defaultContext() {
    return new JsonContextValue(Json.readMapHard((String)Templates.singleton().templates.get(0)));
  }

  @Override
  public String toString() {
    return Json.writeValueAsStringHard(json);
  }
}
