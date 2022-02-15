package com.pxd.user.api.dubbo;

import com.pxd.common.result.page.PageData;
import com.pxd.common.result.result.Result;
import com.pxd.user.api.dto.*;

import java.util.List;

public interface SysRouteDubbo {

    Result<List<SysRouteDto>> findByUserId(Long userId);

    Result<?> add(SysRouteAddDto sysRouteAddDto);

    Result<?> update(SysRouteUpdateDto sysRouteUpdateDto);

    Result<?> del(Long id);

    Result<PageData<SysRouteDto>> page(SysRoutePageDto sysRoutePageDto);

    Result<?> set(SysRouteUserSetDto sysRouteUserSetDto);
}
