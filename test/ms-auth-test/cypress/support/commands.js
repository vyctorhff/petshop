// ***********************************************
// ***********************************************
Cypress.Commands.add('doLoginAdmin', () => {
    const admin = Cypress.env('userAdmin')
    return cy.doLogin(admin)
})

// ***********************************************
// ***********************************************
Cypress.Commands.add('doLogin', (user) => {
    // TODO: check if need 
    const authApi = `${Cypress.env('baseUrl')}/auth/v1`
    return cy.request('GET', authApi, user)
})

// ***********************************************
// ***********************************************
Cypress.Commands.add('refreshToken', () => {
    // TODO: 
})
