Feature: team can be create, delete, update, read, list

  Scenario: client creates Team 1 and get it by id
    Given the client calls POST /teams with
      | name          | BestTeam |
    Then the client receives status code of 200
    When the client calls GET /teams by last id
    Then the client receives status code of 200
    And the client receives object with
      | name          | BestTeam |

  Scenario: client makes call to GET /teams/id with wrong id
    When the client calls GET /teams by id 35946
    Then the client receives status code of 404

  Scenario: client creates Team 2 and update it
    Given the client calls POST /teams with
      | name          | SuperTeam |
    Then the client receives status code of 200
    When the client calls PUT /teams by last id with
      | name          | UpdatedTeam |
    Then the client receives status code of 204
    When the client calls GET /teams by id 2
    Then the client receives status code of 200
    And the client receives object with
      | name          | UpdatedTeam |

  Scenario: client creates Team 3 and delete it
    Given the client calls POST /teams with
      | name          | TopTeam |
    Then the client receives status code of 200
    When the client calls DELETE /teams by last id
    Then the client receives status code of 204