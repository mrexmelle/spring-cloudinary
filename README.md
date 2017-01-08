# spring-cloudinary #

This repository demonstrates how to create a basic web application using Spring Framework integrated with Cloudinary, an image/video storage service.

### How do I get set up? ###

* Create Cloudinary account at this URL

	> http://cloudinary.com/

* Add `application.properties` file in _src/main/resources_ directory, and fill it with your Cloudinary's cloud name, api key, and api secret, like the following:

	```ini
	com.cloudinary.cloud_name=<your_cloud_name>
	com.cloudinary.api_key=<your_api_key>
	com.cloudinary.api_secret=<your_api_secret>
	```

* Compile
 
    ```bash
    $ gradle clean build
    ```

* Run Server

    ```bash
    $ gradle bootRun
    ```

* Use  
    By default the server will serve at:
    > http://localhost:8080/
    
    You can see the list of uploaded image in your Cloudinary account by hitting to:
    > http://localhost:8080/cloud/image

	You can upload another image to your Cloudinary account by sending POST request like the following:
	
	```bash
	curl -X POST -F"upload=@<image_file>" -i "http://localhost:8080/cloud/image/"
	```

### How do I contribute? ###

* Add your name and e-mail address into CONTRIBUTORS.txt
