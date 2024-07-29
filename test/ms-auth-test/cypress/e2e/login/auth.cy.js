// TODO: extract to one place
const rootUrl = 'http://localhost:8080'
const baseUrl = `${rootUrl}/auth/v1`

describe('auth - in progress', () => {

    it('auth - in progress', () => {
        const userAdmin = {
            enrollment: '1',
            password: '123456'
        }

        cy.request('GET', baseUrl, userAdmin).then((resp) => {
            const {time, token, refresh} = resp.body

            expect(token).not.to.equal(' ')
            expect(token).not.to.equal('')
            expect(token).not.to.equal(' ')

            expect(time).not.to.equal('')

            // expect(refresh).not.to.equal('')
        })
    })
})