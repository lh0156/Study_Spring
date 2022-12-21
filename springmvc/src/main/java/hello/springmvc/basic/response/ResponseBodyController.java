package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
//@Controller
//@ResponseBody
@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

//    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("seopseop");
        helloData.setAge(26);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public List<HelloData> responseBodyJsonV2() {
        List<HelloData> helloDataList = new ArrayList<>();

        HelloData helloData = new HelloData();
        helloData.setUsername("seopseop");
        helloData.setAge(26);

        HelloData helloData1 = new HelloData();
        helloData1.setUsername("eomeom");
        helloData1.setAge(26);

        HelloData helloData2 = new HelloData();
        helloData1.setUsername("eomeom");
        helloData1.setAge(26);

        helloDataList.add(helloData);
        helloDataList.add(helloData1);
        helloDataList.add(helloData2);

        return helloDataList;
    }

}
