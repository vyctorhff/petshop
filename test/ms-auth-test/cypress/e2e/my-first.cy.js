const root = 'https://jsonplaceholder.typicode.com'

const urlGET = `${root}/todos/1`
const urlPost = `${root}/posts`

/****************************************************
* Assestations
*****************************************************/
// https://docs.cypress.io/guides/references/assertions

/****************************************************
* Requests: post, get etc
*****************************************************/
describe('GET', () => {

  it('get request with json', () => {
    cy.request(urlGET)
      .then((response) => {
        const body = response.body

        expect(body).to.have.property('completed', false)
        expect(body).to.have.property('userId', 1)
      })
  })

  it('get request with json 2', () => {
    // only one should
    cy.request(urlGET)
      .its('body')
      .should('have.property', 'title')
  })
})

describe('POST', () => {
  it('post request with json', () => {
    const body = {
      "userId": 3,
      "title": "testing title",
      "body": "some testing body"
    }

    cy.request('POST', urlPost, body)
      .then((response) => {
        expect(response.status).to.eq(201)

        expect(response.body).to.have.property('title', 'testing title')
        expect(response.body).to.have.property('userId', 3)
      })
  })
})

/****************************************************
* Fixture
*****************************************************/
describe('learning with fixture', () => {

  beforeEach(() => {
    // To use this way, it will be needed to put this code
    // in beforeEach or berofe test function
    cy.fixture('example.json').as('exampleFixture')

    cy.fixture('example')
      .then(function(data) {
        this.data = data

        cy.log(`Hello: ${this.data.email}`)
      })
  })

  it('basic', function() {
    
    // precisa ser uma function para ter acesso ao this
    cy.log(this.exampleFixture.email)
  })
})

/****************************************************
* Commands
*****************************************************/
describe('commands', () => {

  it('define a basic command', () => {
    Cypress.Commands.add('example', (param1, param2) => {
      return Promise.resolve((success, err) => {
        return 2
      })
    })
  })

  it('using command example', () => {
    cy.example(2, 3).then((result) => {
      cy.log(result)
    })
  })

  it('define command with request', () => {
    Cypress.Commands.add('commandRequest', () => {
      return cy.request(urlGET).then((resp) => {
        return resp.body.completed
      })
    })
  })

  it('using command ', () => {
    cy.commandRequest().then(value => {
      cy.log(`return value: ${value}`)
    })
  })
})

/****************************************************
* Env
*****************************************************/
describe('Env', () => {

  it('defining', () => {
    Cypress.env('retrieveText', 'the text shared');
  })

  it('using', () => {
    const envText = Cypress.env('retrieveText');
    expect(envText).not.to.empty
    cy.log(`Retrieved env: ${envText}`)
  })
})
