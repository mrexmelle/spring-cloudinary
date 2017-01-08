
package com.linecorp.example.springcloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class Config
{
    @Autowired
    Environment mEnv;
    
    @Bean(name="com.cloudinary.cloud_name")
    public String getCloudinaryCloudName()
    {
        return mEnv.getProperty("com.cloudinary.cloud_name");
    }
    
    @Bean(name="com.cloudinary.api_key")
    public String getCloudinaryApiKey()
    {
        return mEnv.getProperty("com.cloudinary.api_key");
    }
    
    @Bean(name="com.cloudinary.api_secret")
    public String getCloudinaryApiSecret()
    {
        return mEnv.getProperty("com.cloudinary.api_secret");
    }
};
