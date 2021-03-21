Feature: Programming category
  Scenario Outline: Check programming category
    Given I open by 'https://otus.ru/'
    When I navigate in 'Курсы'
    And I select item with name '<nameOfCourse>'
    Then I should see <countOfCourse> courses in list of section
    And  I should see <countOfCourse> courses in title of section
    Examples:
      | countOfCourse | nameOfCourse     |
      | 57            | Программирование |
