const root = 'http://localhost:8080'
const baseUrl = `${root}/role/v1`

describe('Role: find by name', () => {
    
    it("should find successfully", () => {
        const name = 'person'
        const url = `${baseUrl}/find/${name}/name`

        // get by name
        // response: name
    })
})

describe('Role: find all', () => {

    it("find all", () => {
        // get baseUrl
        // response: list
    })
})
