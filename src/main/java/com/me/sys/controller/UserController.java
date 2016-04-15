package com.me.sys.controller;

import com.me.common.bo.ResultBo;
import com.me.sys.entity.UserPo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by C167 on 2016/3/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("/index")
    public String index() {
        return "sys/index";
    }

    @ResponseBody
    @RequestMapping(value = "/getPos" )
    public List<UserPo> getPos() {
        logger.info("getPos");
        List<UserPo> userPoList = new ArrayList<>();
        UserPo userPo ;
        userPo  = new UserPo();
        userPoList.add(userPo);
        userPo.setId(1);
        userPo.setShowName("aaa");
        userPo.setDt(new Date());
        userPo  = new UserPo();
        userPoList.add(userPo);
        userPo.setId(2);
        userPo.setShowName("bbb");
        userPo.setDt(new Date());
        userPo  = new UserPo();
        userPoList.add(userPo);
        userPo.setId(3);
        userPo.setShowName("cccd");
        userPo.setDt(new Date());
//        HttpUtil.rspJsonString(response, JsonUtil.getJsonString4List(userPoList));
        return userPoList;
    }
    @ResponseBody
    @RequestMapping(value = "/addPo", method = RequestMethod.POST)
    public  UserPo addPo(@RequestBody UserPo userPo) throws UnsupportedEncodingException {
        userPo.setId(4);
        userPo.setDt(new Date());
        logger.info("addPo");
        return userPo;
    }

    @ResponseBody
    @RequestMapping(value = "/updatePo", method = RequestMethod.POST)
    public  UserPo updatePo(@RequestBody UserPo userPo) throws UnsupportedEncodingException {
        userPo.setDt(new Date());
        logger.info("updatePo id:"+userPo.getId());
        return userPo;
    }
    @ResponseBody
    @RequestMapping(value = "/deletePo/{id}", method = RequestMethod.DELETE)
    public ResultBo deletePo(@PathVariable Integer id)  {
        logger.info("deletePo id:"+id);
        return new ResultBo(ResultBo.BOOLEAN_TRUE,"abc");
    }
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultBo upload(@RequestParam("file")MultipartFile file)  {
        logger.info("upload");
        System.out.println("file:"+file.getName());
        return new ResultBo(ResultBo.BOOLEAN_TRUE,"abc");
    }
}
