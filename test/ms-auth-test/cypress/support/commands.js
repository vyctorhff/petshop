// ***********************************************
// ***********************************************
Cypress.Commands.add('doLoginAdmin', () => {
    const enrollment = '11223344'
    const password =  '123'

    return cy.doLogin(enrollment, password)
})

// ***********************************************
// ***********************************************
Cypress.Commands.add('doLogin', (enrollment, pass) => {
    const rootUrl = 'http://localhost:8080'
    const baseUrl = `${rootUrl}/auth/v1`

    cy.request('GET', baseUrl, userAdmin).then((resp) => {
        const {time, token, refresh} = resp.body

        Cypress.env('token', token)
        Cypress.env('refresh', refresh)
    })
})

// ***********************************************
// ***********************************************
Cypress.Commands.add('refreshToken', () => {
    // TODO: 
})
