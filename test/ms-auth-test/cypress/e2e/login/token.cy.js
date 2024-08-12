const tokenApi = `${Cypress.env('baseUrl')}/auth/v1`

describe('token', () => {

    it('refresh token', () => {
        cy.doLoginAdmin().then((resp) => {
            const token = resp.body.token

            cy.request('PATCH', tokenApi, requestBody).then((resp) => {
                const body = resp.body

                expect(body.refresh).not.to.be.oneOf([undefined, null, '', ' '])
                expect(body.token).not.to.be.oneOf([undefined, null, '', ' '])

                expect(body.token).not.eq(token)
            })
        })
    })
})