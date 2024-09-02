const api = `${Cypress.env('baseUrl')}/auth/v1`
const admin = Cypress.env('userAdmin')

describe('auth', () => {

    it('auth with token', () => {

        cy.request('GET', api, admin).then((resp) => {
            const {time, token, refresh} = resp.body

            expect(token).not.to.be.oneOf([undefined, null, '', ' '])
            expect(time).not.to.equal('')
            expect(refresh).not.to.oneOf([undefined, null, '', ' '])
        })
    })
})