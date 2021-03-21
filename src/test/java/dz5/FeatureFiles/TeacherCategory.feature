Feature: Check teacher tab
  Scenario: Go to became a teacher
    Given I open by 'https://otus.ru/'
    When I navigate in 'Преподавателям'
    And I select item with name 'Стать преподавателем'
    Then I should see page became of teacher with title 'СТАНЬТЕ ПРЕПОДАВАТЕЛЕМ В OTUS.RU'
    And Must be button with name 'Стать преподавателем'
  Scenario: Go to our a teacher
    Given I open by 'https://otus.ru/'
    When I navigate in 'Преподавателям'
    And I select item with name 'Наши преподаватели'
    Then I should see title 'Преподаватели' over
  Scenario: Go to knowledge base
    Given I open by 'https://otus.ru/'
    When I navigate in 'Преподавателям'
    And I select item with name 'База знаний'
    Then I should see block
      | Блоги   |
      | Посты   |
      | Лучшие |
      | Участники           |