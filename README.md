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

## Developer Tools

Added to Project via maven artifact.

DevTools are automatically disabled when running a package application (ie java -jar). By default, not included in repackaged archives.

Automatic Restart:

* Triggers a restart of the Spring Context when classes change.
* Uses 2 classloaders: One for my app, one for project .jar dependencies.
* Restarts are very fast, since only your project classes are bring loaded.






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




## References



[^1]: [Online UUID Generator](https://www.uuidgenerator.net)
