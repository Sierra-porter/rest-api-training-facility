package com.example.restapitrainingfacility.storageservice;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
public interface FileStoraggeService {

    public void init();

    public void save(MultipartFile file);

    public Resource load(String fileName);
}