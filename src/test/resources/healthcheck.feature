Feature: the healthcheck can be retrieved
  Scenario: client makes call to GET /healthcheck
    When the client calls get /healthcheck
    Then the client receives status code of 200