package com.pxd.module.im.util;

import com.pxd.module.im.entity.ImResp;
import com.pxd.module.im.entity.account.*;
import com.pxd.module.im.enums.ImUriEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 帐号管理
 */
@Slf4j
public class TencentImAccountUtil {

    /**
     * 导入单个帐号
     */
    public static boolean accountImport(AccountImportReq accountImportReq) {
        ImResp send = TencentImUtil.send(ImUriEnum.ACCOUNT_IMPORT, accountImportReq, ImResp.class);
        return ImResp.isOk(send);
    }

    /**
     * 导入多个帐号
     */
    public static boolean multiaccountImport(MultiaccountImportReq multiaccountImportReq) {
        MultiaccountImportResp send = TencentImUtil.send(ImUriEnum.MULTIACCOUNT_IMPORT, multiaccountImportReq, MultiaccountImportResp.class);
        boolean ok = ImResp.isOk(send);
        if (ok && !CollectionUtils.isEmpty(send.getFailAccounts())) {
            log.warn("[腾讯IM]导入多个帐号之失败账号:{}", String.join(",", send.getFailAccounts()));
        }
        return ok;
    }

    /**
     * 删除帐号
     */
    public static boolean accountDelete(AccountDeleteReq accountDeleteReq) {
        AccountDeleteResp send = TencentImUtil.send(ImUriEnum.ACCOUNT_DELETE, accountDeleteReq, AccountDeleteResp.class);
        return ImResp.isOk(send);
    }

    /**
     * 查询帐号
     */
    public static List<AccountCheckResultItem> accountCheck(AccountCheckReq accountCheckReq) {
        AccountCheckResp send = TencentImUtil.send(ImUriEnum.ACCOUNT_CHECK, accountCheckReq, AccountCheckResp.class);
        if (ImResp.isOk(send)) {
            return send.getResultItem();
        }
        throw new RuntimeException("腾讯IM查询帐号异常");
    }

    /**
     * 失效帐号登录状态
     */
    public static boolean kick(KickReq kickReq) {
        ImResp send = TencentImUtil.send(ImUriEnum.KICK, kickReq, ImResp.class);
        return ImResp.isOk(send);
    }

    /**
     * 查询帐号在线状态
     */
    public static List<QueryResult> queryOnlineStatus(AueryOnlineStatusReq aueryOnlineStatusReq) {
        AueryOnlineStatusResp send = TencentImUtil.send(ImUriEnum.QUERY_ONLINE_STATUS, aueryOnlineStatusReq, AueryOnlineStatusResp.class);
        if (ImResp.isOk(send)) {
            return send.getQueryResult();
        }
        throw new RuntimeException("腾讯IM查询帐号在线状态异常");
    }

}
