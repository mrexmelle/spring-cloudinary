
package com.linecorp.example.springcloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/")
public class ImageController
{
    @Autowired
    @Qualifier("com.cloudinary.cloud_name")
    String mCloudName;

    @Autowired
    @Qualifier("com.cloudinary.api_key")
    String mApiKey;

    @Autowired
    @Qualifier("com.cloudinary.api_secret")
    String mApiSecret;

    @GetMapping(value="/image")
    public ResponseEntity< List<String> > get(
        @RequestParam(value="name", required=false) String aName)
    {
        Cloudinary c=new Cloudinary("cloudinary://"+mApiKey+":"+mApiSecret+"@"+mCloudName);
        List<String> retval=new ArrayList<String>();
        try
        {
            Map response=c.api().resource("", ObjectUtils.asMap("type", "upload"));
            List<Object> resList = (List<Object>)(response.get("resources"));

            for(Object o : resList)
            {
                Map m=(Map)(o);
                retval.add((String)(m.get("url")));
            }
        }
        catch (Exception e)
        {

        }
        return new ResponseEntity< List<String> >(retval, HttpStatus.OK);
    }
};
