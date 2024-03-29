package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void RequestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        response.getWriter().write(messageBody);

    }

    @PostMapping("/request-body-string-v2")
    public void RequestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        responseWriter.write(messageBody);

    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> RequestBodyStringV3(HttpEntity<String> httpEntity) {

        String messageBody = httpEntity.getBody();

        //헤더 정보 조회
        // HttpHeaders headers = httpEntity.getHeaders();
        log.info("messageBody={}", messageBody);

        return new ResponseEntity<String>("ok", HttpStatus.CREATED);

    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String RequestBodyStringV3(@RequestBody String messageBody) {


        //헤더 정보 조회
        // HttpHeaders headers = httpEntity.getHeaders();
        log.info("messageBody={}", messageBody);

        return "ok";

    }

}
