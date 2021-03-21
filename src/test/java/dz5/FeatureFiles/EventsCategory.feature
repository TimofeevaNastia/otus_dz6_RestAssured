@TestR
Feature: Check event tab
  Scenario: Go to calendar of course
    Given I open by 'https://otus.ru/'
    When I navigate in 'События'
    And I select item with name 'Календарь запуска курсов'
    Then I should see page calendar of courses with title 'Календарь\nзапуска курсов'
  Scenario: Go to calendar of event
    Given I open by 'https://otus.ru/'
    When I navigate in 'События'
    And I select item with name 'Календарь мероприятий'
    Then I should see page calendar of event with title 'Календарь мероприятий'