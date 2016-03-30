package ua.edu.nlu.oldlib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by pc8 on 18.03.16.
 */
@Service
public class BookCacheService {

    @Value("${directory}")
    private String DIRECTORY;
    @Autowired
    private FileService fileService;
    private static final int CLEAR_PERIOD_HOURS = 4;
    private static final int CHECK_CACHE_PERIOD = 3600000;
    private final Map<String, Integer> pageCache = new ConcurrentHashMap<>();
    private final Map<String, Long> timeCache = new ConcurrentHashMap<>();

    public void addCurrentPage(String bookId, Integer currentPage) {
        pageCache.put(bookId, currentPage);
    }

    public Integer getCurrentPage(String bookId) {
        return pageCache.get(bookId);
    }

    public boolean containCurrentPage(String bookId) {
        return pageCache.containsKey(bookId);
    }

    public void addTime(String bookId, Long time) {
        timeCache.put(bookId, time);
    }

    public long getTime(String bookId) {
        return timeCache.get(bookId);
    }

    public void deleteTime(String bookId) {
        timeCache.remove(bookId);
    }

    @Scheduled(fixedDelay = CHECK_CACHE_PERIOD)
    public void cleanCacheTime() {
        System.out.println("Schedul");
        for (Map.Entry<String, Long> entry : timeCache.entrySet()) {
            if ((System.currentTimeMillis() - entry.getValue()) > TimeUnit.HOURS.toMillis(CLEAR_PERIOD_HOURS)) {
                fileService.deleteFile(DIRECTORY + entry.getKey());
                timeCache.remove(entry.getKey());
                System.out.println("Delete");
            }
        }

    }

}
