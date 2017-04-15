package com.nyist.controller;

import com.nyist.entity.MediaFile;
import com.nyist.utility.Constant;
import com.nyist.utility.ResultMessage;
import com.nyist.utility.StatusCode;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kingcos on 06/02/2017.
 */

@RestController
@RequestMapping(value = "/file")
public class MediaFileController {

    @PostMapping(value = "/upload")
    public ResultMessage fileUpload(@RequestParam("file") MultipartFile[] files) {
        List<MediaFile> list = new ArrayList<>();
        StatusCode status = StatusCode.ERR;

        if (files != null && files.length != 0) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isEmpty()) {
                } else {
                    String fileFormat = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
                    MediaFile mediaFile = new MediaFile(UUID.randomUUID().toString() + fileFormat);
                    try {
                        byte[] bytes = files[i].getBytes();
                        BufferedOutputStream outputStream =
                                new BufferedOutputStream(
                                        new FileOutputStream(
                                                new File(Constant.USER_PHOTO_PATH + mediaFile.getMediaFilename())));
                        outputStream.write(bytes);
                        outputStream.close();

                        list.add(mediaFile);

                        status = StatusCode.OK;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return new ResultMessage(status.getStatusCode(), list);
    }

//    @GetMapping(value = "/download")
//    public ResultMessage fileDownload(HttpServletResponse response,
//                                      @RequestParam("filename") String filename) {
//        List<MediaFile> list = new ArrayList<>();
//        StatusCode status = StatusCode.ERR;
//
//        response.setHeader("content-type", "application/octet-stream");
//        response.setContentType("application/octet-stream");
//
//        File file = new File(Constant.USER_PHOTO_PATH + filename);
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//            response.setContentLengthLong(file.length());
//            outputStream.close();
//
//            status = StatusCode.OK;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return new ResultMessage(status.getStatusCode(), list);
//    }

//    @GetMapping(value = "/dl")
//    public void fileDL(HttpServletResponse response,
//                       @RequestParam("filename") String filename) {
//        response.setHeader("content-type", "application/octet-stream");
//        response.setContentType("application/octet-stream");
//
//        File file = new File(Constant.USER_PHOTO_PATH + filename);
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//            response.setContentLengthLong(file.length());
//            outputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @GetMapping(value = "/download")
    public ResponseEntity<InputStreamResource> fileDownload(@RequestParam("filename") String filename) throws IOException {
        String path = Constant.USER_PHOTO_PATH + filename;
        FileSystemResource resource = new FileSystemResource(path);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", resource.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(resource.getInputStream()));
    }
}
