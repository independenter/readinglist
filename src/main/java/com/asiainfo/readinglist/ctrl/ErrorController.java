package com.asiainfo.readinglist.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorController {

    /**
     *   timestamp ：错误发生的时间。
     *   status ：HTTP状态码。
     *   error ：错误原因。
     *   exception ：异常的类名。
     *   message ：异常消息（如果这个错误是由异常引起的）。
     *   errors ： BindingResult 异常里的各种错误（如果这个错误是由异常引起的）。
     *   trace ：异常跟踪信息（如果这个错误是由异常引起的）。
     *   path ：错误发生时请求的URL路径。
     * @param throwable
     * @param model
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model, HttpServletRequest request) {
        //传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程
        request.setAttribute("javax.servlet.error.status_code",500);//这里只接受500状态错误
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("trace",throwable.getStackTrace());
        request.setAttribute("extra", map);//放在request中的数据，在前端页面中都可以取出来
        return "forward:/error";//并不直接返回视图名称或json数据，请求转发到"/error"，让Springboo按流程处理处理，从而达到自适应浏览器请求和客户端请求；
    }

//    @ExceptionHandler()
//    @ResponseBody
//    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
//        HttpStatus status = getStatus(request);
//        return new ResponseEntity<>(ex.getMessage(), status);
//    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}