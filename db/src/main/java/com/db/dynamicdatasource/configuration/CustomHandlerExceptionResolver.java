package com.db.dynamicdatasource.configuration;

import com.db.dynamicdatasource.common.ResponseCode;
import com.db.dynamicdatasource.common.ResponseUtil;
import com.db.dynamicdatasource.utils.ServiceException;
import com.db.dynamicdatasource.common.CommonConstant;
import com.db.dynamicdatasource.common.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title :异常处理类
 * @Description :异常处理类
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    private final Logger logger = LoggerFactory.getLogger(CustomHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        CommonResponse commonResponse = new CommonResponse();
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //Service exception,handler exception from service
            if (ex instanceof ServiceException) {
                commonResponse.setCode(ResponseCode.SUCCESS).setMessage(ex.getMessage());
                logger.warn(ex.getMessage());
            } else {
                //DB exception
                if (ex instanceof DataAccessException) {
                    commonResponse.setCode(ResponseCode.INTERNAL_SERVER_ERROR)
                            .setMessage(CommonConstant.DB_ERROR_MESSAGE);
                } else {
                    //Others exception
                    commonResponse.setCode(ResponseCode.INTERNAL_SERVER_ERROR)
                            .setMessage(CommonConstant.SERVER_ERROR_MESSAGE);
                }

                // error message detail
                String message = String.format("interface [%s] has exception,method is %s.%s, exception message is %s",
                        request.getRequestURI(),
                        handlerMethod.getBean().getClass().getName(),
                        handlerMethod.getMethod().getName(),
                        ex.getMessage());

                logger.error(message, ex);
            }
        } else {
            if (ex instanceof NoHandlerFoundException) {
                commonResponse.setCode(ResponseCode.NOT_FOUND).setMessage("interface [" + request.getRequestURI() + "] not exist");
            } else {
                commonResponse.setCode(ResponseCode.INTERNAL_SERVER_ERROR).setMessage(ex.getMessage());
                logger.error(ex.getMessage(), ex);
            }
        }

        ResponseUtil.handlerResponse(response, commonResponse);
        return new ModelAndView();
    }
}
