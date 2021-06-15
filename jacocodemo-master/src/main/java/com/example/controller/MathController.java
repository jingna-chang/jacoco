package com.example.controller;


import com.example.model.MathOperate;
import com.example.model.Request;
import com.example.model.Response;
import com.example.service.MathService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {
    @RequestMapping(value = "math/operate", method = RequestMethod.POST)
    public Response operate(@RequestBody Request request) throws Exception {
        Response response=new Response();
        if(request.getMathOperate().equals(MathOperate.ADD)){
            response.setData(MathService.add(request.getFirstNum(),request.getSecondNum()));
        }else if(request.getMathOperate().equals(MathOperate.SUBTRACT)) {
            response.setData(MathService.subtract(request.getFirstNum(), request.getSecondNum()));
        }else if(request.getMathOperate().equals(MathOperate.MULTIPLY)){
            response.setData(MathService.multiply(request.getFirstNum(),request.getSecondNum()));
        }
        response.setCode("200");
        return response;
    }
}
