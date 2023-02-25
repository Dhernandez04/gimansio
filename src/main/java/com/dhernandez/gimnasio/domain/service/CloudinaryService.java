package com.dhernandez.gimnasio.domain.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {
    Log Logger = LogFactory.getLog(CloudinaryService.class);


    private Cloudinary cloudinary;


    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryService() {
        valuesMap.put("cloud_name", "dz6e1a6wj");
        valuesMap.put("api_key", "369928991816243");
        valuesMap.put("api_secret", "4FpVbJnvUSiwXdBoytUmcI-35bQ");
        Logger.info("Credenciales"+valuesMap);

        cloudinary = new Cloudinary(valuesMap);

    }

   public Map uploadImagen(MultipartFile multipartFile) throws IOException {
       Logger.info("Iniciando metodo para subirImagen()");

        File file = this.convertir(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
       Logger.info("Finalizando metodo para subirImagen()");
        return result;
    }

    public Map eliminar(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    private File convertir(MultipartFile multipartFile) throws IOException {
    File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo =  new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
