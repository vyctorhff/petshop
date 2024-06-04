const root = 'http://localhost:8080'

describe('Role: find all', () => {

    const baseUrl = `${root}/role/v1`

    it("find all", () => {
        // get baseUrl
    })

    it("find by name", () => {
        const name = 'person'
        const url = `${baseUrl}/find/${name}/name`

        // get by name
        // response: name
    })
})