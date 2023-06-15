package com.jags.ClubDeGolf.Config;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CloudinaryConfig {

    static public String subir_informe_socios(String nombreArchivo){

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ds0rvxag2",
                "api_key", "188345812237688",
                "api_secret", "dwAz_8NB1Um9heUFlbA3e8NB4UY"));

        File pdfFile = new File(nombreArchivo);
        String secureUrl="";

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(pdfFile, ObjectUtils.emptyMap());
            secureUrl = (String) uploadResult.get("secure_url");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return secureUrl;
    }


}
