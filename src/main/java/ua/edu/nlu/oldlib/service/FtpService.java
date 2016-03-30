package ua.edu.nlu.oldlib.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.ftp.session.FtpSession;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pc8 on 10.03.16.
 */
@Service
public class FtpService {

    @Value("${directory}")
    private  String DIRECTORY;
    @Value("${default.page.range}")
    private Integer DEFAULT_PAGE_RANGE;
    @Autowired
    private SessionPoolTest sessionPool;
    @Autowired
    private BookCacheService bookCacheService;

    private static final String TEN = "10";
    private static final String TWENTY = "20";
    private static final String THIRTY = "30";
    private static final int DEFAULT_CUR_PAGE = 1;


    public void download(String bookId){

        bookCacheService.addTime(bookId, System.currentTimeMillis());

        int currentPage = DEFAULT_CUR_PAGE;
        int pageRange = DEFAULT_PAGE_RANGE;

        File bookDir = new File(DIRECTORY + bookId);

        if (!bookDir.exists()) {
            bookDir.mkdir();
        }

        FtpSession ftpSession = sessionPool.getSession();

        int countPage = getCountPage(bookId, ftpSession);

        if (bookCacheService.containCurrentPage(bookId)){
             currentPage = bookCacheService.getCurrentPage(bookId);
             pageRange = checkPageRange(currentPage, countPage );
        }

        for (int i = currentPage; i < pageRange; i++) {
            try {
               ftpSession.read(getRemoteDir(ftpSession,bookId) + "/" + bookId + "/" + i + ".jpg", new FileOutputStream(DIRECTORY + bookId + "/" + i + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
          }
         bookCacheService.addCurrentPage(bookId, currentPage + DEFAULT_PAGE_RANGE);
         sessionPool.release(ftpSession);

    }

    private int checkPageRange(int currentPage, int countPage) {
        if (currentPage > countPage) {
            return 0;
        }
        if (countPage < currentPage + DEFAULT_PAGE_RANGE) {
            return countPage - currentPage + 1;
        }
        return 0;
    }

     private String getRemoteDir(FtpSession ftpSession, String bookId){

         try {
             List<String> listFolders = Arrays.asList(ftpSession.listNames(THIRTY));
             if (listFolders.contains(bookId)){
                 return THIRTY;
             }
             listFolders = Arrays.asList(ftpSession.listNames(TWENTY));
             if (listFolders.contains(bookId)){
                 return TWENTY;
             }
         } catch (IOException e) {
            //TODO:add logger and wrapper exception
             e.printStackTrace();
                 }
         return TEN;
     }

    private int getCountPage(String bookId, FtpSession ftpSession){
        int count = 0;
        String path = getRemoteDir(ftpSession,bookId) + "/" + bookId + "/";
        try {
            String[] nameArray = ftpSession.listNames(path);
            for (String name : nameArray ) {
                if (name.endsWith(".jpg")) {
                    count++;
                }
            }
        } catch (Exception e) {
            //TODO:add logger and wrapper exception
        }

        return count;
    }

}
