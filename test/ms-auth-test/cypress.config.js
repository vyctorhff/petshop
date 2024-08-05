const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
  env: {
    testEnv: 'defined in cypress.config.js - hello world',
    baseUrl: 'http://localhost:8080',
    userAdmin: {
      enrollment: '1',
      password: '123456',
    },
  },
});
