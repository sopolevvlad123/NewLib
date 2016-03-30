package ua.edu.nlu.oldlib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpSession;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by pc8 on 12.03.16.
 */
@Service
public class SessionPoolTest {

    @Value("${pool.limit}")
    private int poolLimit;

    @Autowired
    private DefaultFtpSessionFactory defaultFtpSessionFactory;

    volatile private int counter;

    public FtpSession getSession() {
        FtpSession ftpSession;
        synchronized (this) {
            if (counter == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ftpSession = defaultFtpSessionFactory.getSession();
        }
        --poolLimit;
        return ftpSession;
    }

    public void release(FtpSession ftpSession) {
        ftpSession.close();
        synchronized (this) {
            ++poolLimit;
            this.notify();
        }
    }

    @PostConstruct
    private void initCounter() {
        counter = poolLimit;
    }
}
