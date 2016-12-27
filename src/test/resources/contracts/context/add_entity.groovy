package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/add'
        body(name : 'some-name')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 201
        body(
                name : $(client('some-name'), server(execute('name($it)'))),
                id : $(regex(uuid()))
        )
        headers {
            contentType(applicationJson())
            header('Location', regex("http://localhost/get/${uuid()}"))
        }
    }
}