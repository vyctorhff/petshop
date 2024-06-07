const rootUrl = 'http://localhost:8080'
const baseUrl = `${rootUrl}/role/v1`

describe('find by name', () => {
    
    it('should find successfully', () => {
        const name = 'person'
        const url = `${baseUrl}/find/${name}/name`

        cy.request(url).then((resp) => {
            const body = resp.body
            cy.log(body)
        })
    })
})

describe('find all', () => {

    it('find all', () => {
        cy.request(baseUrl).then((resp) => {
            const body = resp.body
            cy.log(body)
        })
    })
})
