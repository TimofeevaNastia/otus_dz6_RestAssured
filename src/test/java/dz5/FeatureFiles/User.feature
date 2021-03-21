Feature: User Profile operation
  Scenario: Login user in personal account
    Given I open by 'https://otus.ru'
    And I authorization
    When I navigate in username
    Then I should see list by 4 item

  Scenario Outline: Go to Personal Page
    Given I open by 'https://otus.ru'
    And I authorization
    When I navigate in username
    And I select item with name '<tabName>'
    Then I should see title 'Личный кабинет' over
    And I should see active tab '<title>'
    And I should see 7 tab
    Examples:
      | tabName        | title     |
      | Личный кабинет | Мои курсы |
      | Оплата         | Оплата    |

  Scenario Outline: Go to Personal Page and check tab
    Given I open and authorization by 'https://otus.ru/lk/biography/personal/'
    When I select item with name 'О себе'
    Then I should see 5 item
    When I select tab '<itemName>'
    Then I should see title '<itemName>'
    Examples:
      | itemName              |
      | Персональные данные   |
      | Навыки и технологии   |
      | Проекты и опыт работы |
      | Образование           |

