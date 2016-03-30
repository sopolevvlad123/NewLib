package ua.edu.nlu.oldlib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpSession;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Semaphore;

/**
 * Created by pc8 on 15.03.16.
 */
@Service
public class SessionPool {

    @Value("${pool.limit}")
    private int poolLimit;

    @Autowired
    private DefaultFtpSessionFactory defaultFtpSessionFactory;

    private Semaphore semaphore;

    public FtpSession getSession() {
        try {
            semaphore.acquire();
            return defaultFtpSessionFactory.getSession();
        } catch (InterruptedException e) {
            //TODO:I will add logger and throw my exception here!!!!!!!!!!!!!!!!
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            //TODO:I will add logger and throw my exception here!!!!!!!!!!!!!!!!
            semaphore.release();
            throw new RuntimeException(e);
        }
    }

    public void release(FtpSession ftpSession) {
        try {
            ftpSession.close();
        } finally {
            semaphore.release();
        }
    }

    @PostConstruct
    private void initCounter() {
        semaphore = new Semaphore(poolLimit);
    }

}
