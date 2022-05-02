package com.myPortfolioGramback.controller;

import com.myPortfolioGramback.common.Success;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * The type Main controller.
 */
@RestController
@RequiredArgsConstructor
public class MainController implements ErrorController {

    /**
     * CORS TEST로 인한 주석 추가
     *
     */
    /**
     * axios simple Test
     *
     * @param request the request
     * @return success
     * @author jh.won
     * @since 2022.04
     */
    @PostMapping("/axiosTest")
    public @ResponseBody Success axiosTest(HttpServletRequest request) {

        String testValue = request.getParameter("testValue");
        Success success = new Success(false);

        success.setResult(testValue);
        success.setSuccess(true);
        return success;

    }

//    @GetMapping({"/", "/error"})
//    public String index() {
//        return "index";
//    }

    /**
     * 오류 처리 API
     *
     * @param response the response
     * @param request  the request
     * @return response entity
     * @author jh.won
     * @since 2022.04
     */
    @RequestMapping(value = {"/", "/error"})
    public ResponseEntity<Object> handleNoHandlerFoundException(HttpServletResponse response, HttpServletRequest request) {
        int status = response.getStatus();

        System.out.println(status);  //오류 상태
        System.out.println(request.getRequestURI());  //요청 주소

        //아래 코드는 샘플 응답코드입니다. 오류에 따라 원하는 방식으로 리턴하면 되겠습니다.
        if (Objects.equals(request.getContentType(), MediaType.APPLICATION_JSON_VALUE)) {
            Map<String, Object> body = Map.of("error", "Not Found", "timestamp", System.currentTimeMillis());
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
