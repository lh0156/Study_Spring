package hello.servlet.web.frontcontroller;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ModelViewPratice {

    String viewName;
    Map<String, Object> modelView = new HashMap<>();

    public ModelViewPratice(String viewName) {
        this.viewName = viewName;
    }


}
