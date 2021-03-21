Feature: Check navigation in tab in main form

  Scenario Outline: Move in tab and check count item
    Given I open by 'https://otus.ru'
    When I navigate in '<tabName>'
    Then I should see <countItem> item in dropping out list from <numberOfTab> tab
    Examples:
      | tabName        | countItem | numberOfTab |
      | Курсы          | 9         | 1           |
      | События        | 3         | 2           |
      | Преподавателям | 3         | 3           |
      | Компаниям      | 3         | 4           |
      | О нас          | 6         | 5           |

  Scenario Outline: Move in category and check count course
    When I open by 'https://otus.ru'
    And I navigate in 'Курсы'
    And I navigate in tab '<nameOfCourse>'
    And I navigate in add tab
    Then I should see <countOfCourseFromTab> courses in list of tab '<nameOfCourse>'
    Examples:
      | nameOfCourse     | countOfCourseFromTab |
      | Программирование | 52                   |