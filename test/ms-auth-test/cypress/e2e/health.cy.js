const rootUrl = 'http://localhost:8080'
const baseUrl = `${rootUrl}/health`

describe('Health', () => {
    const url = baseUrl

    it('get status up', () => {
        cy.request(url).then((resp) => {
            expect(resp.body.status).to.equal('UP')
        })
    })
})