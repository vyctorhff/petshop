// TODO: extract to one place
const rootUrl = 'http://localhost:8080'
const baseUrl = `${rootUrl}/token/v1`

describe('token', () => {

    it('refresh token', () => {
        cy.doLoginAdmin().then((resp) => {
            cy.log('passou por aqui')
            cy.log(resp)
        })
    })
})