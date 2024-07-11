// TODO: extract to one place
const rootUrl = 'http://localhost:8080'
const baseUrl = `${rootUrl}/role/v1`

describe('find all', () => {
    const url = baseUrl

    it('find all', () => {
        cy.request(url).then((resp) => {
            const list = resp.body
            cy.log(list)

            for (var nameList of list) {
                expect(nameList).to.not.be('')
                expect(nameList).to.not.null
                expect(nameList).to.not.empty

                // expect(nameList).to.exist
            }
        })
    })
})
