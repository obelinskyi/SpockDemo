package com.example.spockdemo

import com.example.spockdemo.dto.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseSpringBootTest extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    private WebApplicationContext webApplicationContext

    protected ResponseEntity get(String endpoint, int id) {
        int serverPort = ((AnnotationConfigServletWebServerApplicationContext) webApplicationContext).getWebServer().getPort()

        def url = String.format("http://localhost:%d%s?id=%d", serverPort, endpoint, id)
        return restTemplate.getForEntity(url, Person.class)
    }

    protected void 'Assert response code is Valid'(ResponseEntity response) {
        with(response) {
            assert statusCode == HttpStatus.OK
        }
    }

    protected void 'Assert response code is Not Found'(ResponseEntity response) {
        assert response.getStatusCode() == HttpStatus.NOT_FOUND
    }

}
