const getRequest = 'https://jsonplaceholder.typicode.com/todos/1'
const postRequest = 'https://jsonplaceholder.typicode.com/posts'

describe('testing requests', () => {

  it('get request with json', () => {
    cy.request("https://jsonplaceholder.typicode.com/todos/1")
      .then((response) => {
        const body = response.body

        expect(body).to.have.property('completed', false)
        expect(body).to.have.property('userId', 1)
      })
  })

  it('get request with json 2', () => {
    // only one should
    cy.request(getRequest)
      .its('body')
      .should('have.property', 'title')
  })

  it('post request with json', () => {
    const body = {
      "userId": 3,
      "title": "testing title",
      "body": "some testing body"
    }

    cy.request('POST', postRequest, body)
      .then((response) => {
        expect(response.status).to.eq(201)

        expect(response.body).to.have.property('title', 'testing title')
        expect(response.body).to.have.property('userId', 3)
      })
  })
})