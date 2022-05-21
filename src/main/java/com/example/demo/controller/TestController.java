package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.People;
import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/test", method = RequestMethod.POST)
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @PostMapping("addPeople")
    @ResponseBody
    public void addPeople(@RequestBody JSONObject object) {
        logger.info(JSON.toJSONString(object));
        testService.addPeople(JSON.parseObject(JSON.toJSONString(object), People.class));
    }

    @PostMapping("/getAllPeople")
    @ResponseBody
    public String getAllPeople() {
        logger.info("getAllPeople");
        return JSON.toJSONString(testService.getAllPeople());
    }
}
