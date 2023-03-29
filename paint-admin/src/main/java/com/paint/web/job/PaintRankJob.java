package com.paint.web.job;

import com.paint.common.core.domain.ApiBaseCondition;
import com.paint.service.service.IPaintService;
import com.paint.service.service.impl.PaintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class PaintRankJob {

    private IPaintService paintService;
    private CacheManager cacheManager;

    @Autowired
    public void setPaintService(IPaintService paintService) {
        this.paintService = paintService;
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void resetRankCache() {
        Cache cache = cacheManager.getCache(PaintServiceImpl.CACHE_NAME);
        if (cache != null) {
            cache.invalidate();
        }
        for (int i = 1; i < 11; i++) {
            paintService.rankWeek(ApiBaseCondition.builder().page(i).pageSize(10).build());
            paintService.rankMonth(ApiBaseCondition.builder().page(i).pageSize(10).build());
        }
    }
}
