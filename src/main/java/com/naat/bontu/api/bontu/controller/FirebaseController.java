package com.naat.bontu.api.bontu.controller;

import com.naat.bontu.api.bontu.interceptor.RequestResponseLoggingInterceptor;
import com.naat.bontu.api.bontu.model.FirebaseNotification;
import com.naat.bontu.api.bontu.model.FirebaseToken;
import com.naat.bontu.api.bontu.model.User;
import com.naat.bontu.api.bontu.repository.FirebaseTokenRepository;
import com.naat.bontu.api.bontu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class FirebaseController {

    @Autowired
    FirebaseTokenRepository firebaseTokenRepository;
    @Autowired
    UserRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @PostMapping(value = {"/firebase_token/", "/firebase_token"})
    public FirebaseToken addFirebaseToken(@RequestBody FirebaseToken firebaseToken) {
        /*Optional<User> user=userRepository.findById(firebaseToken.getUser().getUser());
        if (user.isPresent()){
            int i= firebaseTokenRepository.setTokenByUser(firebaseToken.getToken(),new User(firebaseToken.getUser().getUser()));
            return firebaseToken;
        }
        return null;*/
        FirebaseToken token = firebaseTokenRepository.findByUser(firebaseToken.getUser());
        if (token == null) {
            return firebaseTokenRepository.save(firebaseToken);
        } else {
            int result = firebaseTokenRepository.setTokenByID(firebaseToken.getToken(), token.getNumber());
            return firebaseToken;
        }
    }

    @DeleteMapping(value = "/firebase_token/{token}")
    public Boolean deleteToken(@PathVariable String token) {
        FirebaseToken firebaseToken = firebaseTokenRepository.findByToken(token);
        Long count = firebaseTokenRepository.countByToken(token);
        if (count > 0) {
            firebaseTokenRepository.deleteById(firebaseToken.getNumber());
            return true;
        }
        return false;
    }


    @PostMapping(value = "/firebase_token/notification")
    public Object sendNotification(@RequestBody FirebaseNotification notification) {

        Map<String,String> dataMap= notification.getData();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization", "key=" + "AAAA_McKvQ0:APA91bEvu5ksvQ5dQbOex9Sr5j0QuSsn-O7RvnZqIWPNu47qXs5j3fAt5Kz1tX3ev-TufWgdX7aU8wnzuadjSXBsqOmDq9DgPmA_-DA_NsIiBOHOQqYnC7QUQvSKx4eHGbSsJRNWPEld");
        headers.add("Content-Type", "application/json");
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(factory);


        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());



        /*Map<String, String> data = new HashMap<>();

        data.put("body", "consectetur et.");
        data.put("title", "Promocion de algo");
        data.put("image", "");
        data.put("icon", "default");
        data.put("sound", "default");*/
        List<String> ids=firebaseTokenRepository.findAll().stream().map(FirebaseToken::getToken).collect(Collectors.toList());
        notification.setRegistrationIds(ids);
        notification.setData(dataMap);
        HttpEntity<FirebaseNotification> request = new HttpEntity<>(notification, headers);

        return restTemplate.postForObject("https://fcm.googleapis.com/fcm/send", request, Object.class);
    }
}
