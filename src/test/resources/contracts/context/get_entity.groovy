package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url $(consumer("/get/${uuid()}"), producer('/get/ac8beeab-5bdf-47d0-9648-fdbd5adb440e'))
    }
    response {
        status 200
        body(
                name : 'some-name',
                id : $(client(uuid()), server('ac8beeab-5bdf-47d0-9648-fdbd5adb440e'))
        )
        headers {
            contentType(applicationJson())
        }
    }
}