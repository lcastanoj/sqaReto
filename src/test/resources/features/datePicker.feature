Feature: Date selection using jQuery DatePicker

  Background:
    Given I open the jQuery DatePicker page

  @NextMonth
  Scenario Outline: Select a date from the DatePicker and validate the selection
    When I select the "<day>" of the next month
    Then I should see the selected "<date>" in the date selection field

    Examples:
      | day | date       |
      | 10  | 12/10/2025 |


  @CurrentlyMonth
  Scenario Outline: Reserve an appointment by selecting a date
    When I select the "<day>" of the current month
    Then I should see the selected "<date>" in the date selection field

    Examples:
      | day | date       |
      | 15  | 11/15/2025 |

  ##@ManuallyInteraction
  ##Scenario Outline: Prevent manual date input in the Datepicker
  ##  When I try to type a "<date>" manually into the date field
  ##  Then the date field should still be empty
  ##
  ##  Examples:
  ##    | date       |
  ##    | 04/13/2026 |