// TODO: extract to one place
const rootUrl = 'http://localhost:8080'
const baseUrl = `${rootUrl}/role/v1`

describe('find by name', () => {
    
    it('should find successfully', () => {
        const name = 'person'
        const url = `${baseUrl}/find/${name}/name`

        cy.request(url).then((resp) => {
            const list = resp.body
            cy.log(list)

            for (var nameList of list) {
                expect(nameList).to.equal(name)
            }
        })
    })

    it('should find name that no exists', () => {
        const name = 'notExists-123'
        const url = `${baseUrl}/find/${name}/name`

        cy.request(url).then((resp) => {
            expect(resp.body).to.be.empty
        })
    })
})
