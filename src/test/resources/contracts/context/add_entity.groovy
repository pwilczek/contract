package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/add'
        body([name : 'some-name'])
        headers {
            contentType('application/json')
        }
    }
    response {
        status 201
        body(
                name : 'some-name',
                id : $(regex(uuid()))
        )
        headers {
            contentType('application/json')
        }
    }
}