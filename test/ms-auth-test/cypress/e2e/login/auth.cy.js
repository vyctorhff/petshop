// TODO: extract to one place
// const rootUrl = 'http://localhost:8080'
// const baseUrl = `${rootUrl}/auth/v1`

const authApi = `${Cypress.env('baseUrl')}/auth/v1`

describe('auth - in progress', () => {

    it('auth - in progress', () => {
        // TODO: update to config env
        const userAdmin = {
            enrollment: '1',
            password: '123456'
        }

        // cy.request('GET', baseUrl, userAdmin).then((resp) => {
        cy.request('GET', authApi, userAdmin).then((resp) => {
            const {time, token, refresh} = resp.body

            // expect(token).not.to.be.oneOf([undefined, null, '', ' '])

            expect(token).not.to.equal(' ')
            expect(token).not.to.equal('')
            expect(token).not.to.equal(' ')

            expect(time).not.to.equal('')

            // expect(refresh).not.to.equal('')
        })
    })
})