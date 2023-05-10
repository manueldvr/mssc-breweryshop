# MSSC - Brewery Shop sample
<u>__Microservices & Service Containers - Brewery shop__</u>

<br>
<br>

---

__index__

* Project
* Developer Tools Features
* API

<br>



## Project


### Lombok
DTO annotations:
> Enable annotation processing.

- @Data<br>
create getters and setters, equal and hash code methods.

- @NoArgsConstructor
- @AllArgsConstructor<br>
constructores con y sin argumentos.

- @Builder<br>
for implement Builder pattern.

## Resources

`Jakcson` object mapper

`MockMvc`

## Developer Tools

Added to Project via maven artifact.

DevTools are automatically disabled when running a package application (ie java -jar). By default, not included in repackaged archives.

Automatic Restart:

* Triggers a restart of the Spring Context when classes change.
* Uses 2 classloaders: One for my app, one for project .jar dependencies.
* Restarts are very fast, since only your project classes are bring loaded.

In IntelliJ by default select 'Build/Make Project'. 




## API

Test controller with Postman with: <u>http://localhost:8080/api/v1/beer/c0a00a06-b425-4c38-b3d5-c5a1cf5fc26e</u>.<br>
Returns:

~~~json
{
    "id": "ca2e4662-2fef-4ad7-9020-030a429c06f4",
    "beerName": "Galaxy Cat",
    "beerStyle": "Pale Ale",
    "upc": 1
}
~~~

See reference for UUID generation [^1].

~~~java
BeerService.getBeerById(UUID beerId)
customerService.getCustomerById(customerId)
BeerService.handlePost(BeerDto beer)
~~~

## API Versioning

Versioning my APIs is consodering a good practice.<br>
Example: <br>
`/api/v1/beer` where `v1` is the API version.

API versioning allows to evolve the API without breaking existing API consumers.

Typical lifespan:

* `v1` - first release
* `v2` - second release, notify consumers `v1` version is deprecated
* `v3` - remove `v1` (optional), notify consumers `v2` is deprecated

> `@Deprecated` can be used for a `v1` elements.

### Semantic Versioning 2.0.0

Version - MAJOR.MINOR.PATCH

* __MAJOR__ - version for major incompatible API changes - __aka breaking changes__ 
* __MINOR__ - new functionality - backwards compatible changes
* __PATCH__ - backwards compatible bug fixes

API URLs typically only use MAJOR versions. Can optionally use MINOR and PATCH

* `/v1` or `/v1.1`

### Non-Breaking Changes

Non-Breaking changes may be performed under MINOR or PATCH versions. Examples:

* New optional parameter
* New response fields
* New service (endpoint)
* Bug fixes - behavior change, NOT change to API itself

### Breaking Changes

Breaking Changes should be done under a MAJOR version. Examples:

* New required parameter
* Removal of existing parameter
* Removal of response value
* Parameter name change or type 
* Deprecation of a service

---

## Quiz

###Diferencia entre @Controller y @RestController:

@Controller esta anotacion es usada para parcar una clase como Controller en SpringMVC mientras @RestController es un controller especial en RESTful especificacion y equivale a la suma de @Controller y @ResponseBody.


### Difference between the @RequestMapping and @GetMapping:

@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).

@GetMapping is the newer annotaion. It supports consumes. Consume options are :

consumes = "text/plain"
consumes = {"text/plain", "application/*"}

For Further details see: GetMapping Annotation or read: request mapping variants.

__RequestMapping supports consumes as well__

GetMapping we can apply only on method level and RequestMapping annotation we can apply on class level and as well as on method level


### Why should you version your APIs?

Versioning allows me to evolve the API without breaking existing API consumers.


### Which of the following is considered a breaking change, where the API's version should be incremented?





## References

* Semantic Versioning 2.0.0 [Semantic Versioning](https://semver.org)

[^1]: [Online UUID Generator](https://www.uuidgenerator.net)
