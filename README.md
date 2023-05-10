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

### Semantic Versioning 2.0.0



## References



[^1]: [Online UUID Generator](https://www.uuidgenerator.net)
