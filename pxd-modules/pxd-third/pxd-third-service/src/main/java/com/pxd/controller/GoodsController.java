package com.pxd.controller;

import com.pxd.common.result.result.Result;
import com.pxd.dto.goods.*;
import com.pxd.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Api(tags = "商品模块（搜索，转链，详情）")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @ApiOperation(value = "热门搜索关键词")
    @GetMapping("/hot/words")
    public Result<List<String>> hotWords() {
        return Result.ok(goodsService.getHotWords());
    }

    @ApiOperation(value = "联想词")
    @GetMapping("/associational/word")
    public Result<List<String>> associationalWord(String text) {
        return Result.ok(goodsService.associationalWord(text));
    }

    @ApiOperation(value = "搜索")
    @PostMapping("/search")
    public Result<SearchResp> search(@Validated @RequestBody SearchReq searchReq) {
        return Result.ok(goodsService.search(searchReq));
    }

    @ApiOperation(value = "商品详情")
    @GetMapping("/details/{platform}/{goodsId}")
    public Result<DetailsResp> details(@ApiParam(value = "商品Id") @NotBlank(message = "商品id不能为空") @PathVariable String goodsId,
                                       @ApiParam(value = "平台 tb,jd,pdd") @NotBlank(message = "平台不能为空") @PathVariable String platform) {
        return Result.ok(goodsService.details(platform, goodsId));
    }

    @ApiOperation(value = "转链")
    @PostMapping("/turn/link")
    public Result<TurnLinkResp> turnLink(@RequestBody TurnLinkReq turnLinkReq) {
        return Result.ok(goodsService.turnLink(turnLinkReq));
    }

}
