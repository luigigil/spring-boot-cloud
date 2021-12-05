package com.example.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
public class VersioningController {

    // url versioning
    @GetMapping("v1/person")
    public PersonV1 getPersonV1Path() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2Path() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // param versioning
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 getPersonV1Param() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 getPersonV2Param() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // header versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Header() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Header() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // produces versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1Produces() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2Produces() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

}