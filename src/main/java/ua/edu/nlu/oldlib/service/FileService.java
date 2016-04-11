package ua.edu.nlu.oldlib.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by pc8 on 21.03.16.
 */
@Service
public class FileService {

    @Value("${directory}")
    private String DIRECTORY;


    public File getPage(int bookId, String page){
        File file = new File(DIRECTORY + "/" + bookId + "/" + page + ".jpg");

        if (!file.exists()){
            //TODO: "Could not find file"
        }

        return file;

    }


    public void deleteFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            //TODO: add logger
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    deleteFile(f.getAbsolutePath());
                }
            }
        }
        if (!file.delete()) {
            //TODO: add logger
        }
    }
}
