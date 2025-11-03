Feature: Add a new customer
  As a user on the Home screen
  I want to add a new customer
  So that the new customer appears at the end of the customer list

  Scenario: Add a new customer successfully
    Given I am on the Home screen
    When I click on the "Add a new customer" FAB button
    Then I should arrive on the Add screen

    When I enter "Fievel Farwest" in the name field
    And I enter "fievel.farwest@example.com" in the email field
    And I click on the "Save the new customer" FAB button
    Then I should return to the Home screen
#    And I should see "Fievel Farwest" added at the end of the customer list
#    And I should see a toast message "New customer succesfully created"
#
#  Scenario: Cannot add new customer when name field is empty
#    Given I am on the add screen
#    When I leave the name field empty
#    And I enter "fievel.farwest@example.com" in the email field
#    Then I cannot click on the save FAB button
#
#  Scenario: Cannot add new customer when email field is empty
#    Given I am on the add screen
#    When I enter "Fievel Farwest" in the name field
#    And I leave the email field empty
#    Then I cannot click on the save FAB button
#
#  Scenario: Cannot add new customer when email field is invalid
#    Given I am on the add screen
#    When I enter "Fievel Farwest" in the name field
#    And I enter "not-an-email" in the email field
#    Then I cannot click on the save FAB button