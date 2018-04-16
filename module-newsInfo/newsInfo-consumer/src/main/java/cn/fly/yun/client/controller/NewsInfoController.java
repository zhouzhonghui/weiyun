package cn.fly.yun.client.controller;

import cn.fly.yun.domain.*;
import cn.fly.yun.service.NewsInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "资讯信息", description = "资讯服务")
@RequestMapping(value = "app/newsInfo", consumes = "application/json", produces = "application/json")
public class NewsInfoController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Reference(version = "1.0.0")
    private NewsInfoService newsInfoService;


    @RequestMapping(value = "/getNewsList", method = RequestMethod.POST, name = "查看资讯列表")
    GetNewsListRes getNewsList(@RequestBody GetNewsListReq req) throws Exception {
        LOGGER.debug("getNewsList----------------------------- " + req.toString());
        GetNewsListRes res = newsInfoService.getNewsList(req);
        return res;
    }

    @RequestMapping(value = "/thumbUp", method = RequestMethod.POST, name = "点赞")
    ThumbUpRes thumbUp(@RequestBody ThumbUpReq req) throws Exception {
        LOGGER.debug("thumbUp----------------------------- " + req.toString());
        ThumbUpRes res = newsInfoService.thumbUp(req);
        return res;
    }

    @RequestMapping(value = "/thumbDown", method = RequestMethod.POST, name = "取消点赞")
    ThumbDownRes thumbDown(@RequestBody ThumbDownReq req) throws Exception {
        LOGGER.debug("thumbDown----------------------------- " + req.toString());
        ThumbDownRes res = newsInfoService.thumbDown(req);
        return res;
    }

    @RequestMapping(value = "/getDetailForNews", method = RequestMethod.POST, name = "得到图文详情")
    GetDetailForNewsRes getDetailForNews(@RequestBody GetDetailForNewsReq req) throws Exception {
        LOGGER.debug("getDetailForNews----------------------------- " + req.toString());
        GetDetailForNewsRes res = newsInfoService.getDetailForNews(req);
        return res;
    }

    @RequestMapping(value = "/quotesTransaction", method = RequestMethod.POST, name = "得到she行情")
    QuotesTransactionRes quotesTransaction(@RequestBody QuotesTransactionReq req) throws Exception {
        LOGGER.debug("quotesTransaction----------------------------- " + req.toString());
        QuotesTransactionRes res = newsInfoService.quotesTransaction(req);
        return res;
    }
}
