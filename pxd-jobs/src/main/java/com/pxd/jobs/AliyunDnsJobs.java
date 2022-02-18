package com.pxd.jobs;

import com.aliyun.alidns20150109.models.DescribeDomainRecordsResponseBody;
import com.pxd.utils.AliYunDnsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class AliyunDnsJobs {

    private volatile static String formerIp = null;
    private final static Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
    private final static String domainName = "pixiaodan.cn";
    private final static List<String> rrList = new ArrayList<String>() {{
        add("nginx");
    }};

    @Scheduled(cron = "0 0/10 * * * ?")
    public void execute() {
        String ip = AliyunDnsJobs.replaceAllBlank(AliYunDnsUtils.getIp());
        log.info("查询到当前ip:{}", ip);
        if (ip == null ) {
            return;
        }
        List<DescribeDomainRecordsResponseBody.DescribeDomainRecordsResponseBodyDomainRecordsRecord> describeDomainRecordsResponseBodyDomainRecordsRecords = AliYunDnsUtils.domainRecords(domainName);
        describeDomainRecordsResponseBodyDomainRecordsRecords.forEach(entity -> {
            if (rrList.contains(entity.getRR()) && !Objects.equals(ip, entity.getValue())) {
                AliYunDnsUtils.updateDomainIp(entity, ip);
            }
        });
        formerIp = ip;
    }

    /**
     * 去除所有空格
     */
    private static String replaceAllBlank(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }

}
