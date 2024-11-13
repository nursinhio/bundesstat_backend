package com.example.new_project_challenge_15.service;

import com.example.new_project_challenge_15.modelsPhoto.photoDb;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;


@Service
public class newPhotoService {
    @Autowired
    com.example.new_project_challenge_15.repositoryPhoto.newPhotoRepo newPhotoRepo;




    public RestTemplate restTemplate() throws Exception {
        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial((chain, authType) -> true)  // Trust all certificates
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLContext(sslContext)
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)  // Disable hostname verification
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }

    public photoDb getPhotoByIIN(String iin) throws Exception {
        RestTemplate restTemplate = restTemplate();
        ResponseEntity<String> res=restTemplate.exchange("http://localhost:8081/api/"+iin,HttpMethod.GET,null,String.class);

        String url = "https://192.168.122.110:9000/photos/"+res.getBody();

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET,null, byte[].class);
        photoDb photo = new photoDb();
        photo.setPhoto(response.getBody());

        return photo;
    }

//    public photoDb getPhotoByIIN(String iin) {
//        return newPhotoRepo.findByIin(iin);
//    }


}
