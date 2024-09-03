const api = `${Cypress.env('baseUrl')}/role/v1`

describe('find all', () => {
    it.skip('find all', () => {
        cy.request(api).then((resp) => {
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
