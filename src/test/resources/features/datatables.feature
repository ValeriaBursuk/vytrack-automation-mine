
Feature: User should view all the main modules of the app
  User story:
  As a user, I should be accessing all the main modules of the app.

#  acceptance criteria 1
  Scenario: Module options for "driver"
    Given user is on the login page
    When user enters "truck driver" information
    Then user should be able to see the following modules
#      | module     |
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

# acceptance criteria 2
  Scenario: Module options for "sales manager"
    Given user is on the login page
    When user enters "sales manager" information
    Then user should be able to see the following modules
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

  Scenario: Login with given information
    Given user is on the login page
    When user enters below credentials
      |username| user10|
      |password| UserUser123|

    Then user should be able to see following information
      |firstname|John|
      |lastname |Doe |


    #data table - list of map
  Scenario: verify each product price
    Given User is on the HomePage
    Then User should be able to see expected prices in following products
    # category - key, product - key, expectedprice - key
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |

#| Phones   | Nexus 6           | 650           |
  #list.get(2).get("Category") -> phones
  #list.get(2).get("Product") -> nexus 6
  #list.get(2).get("expectedPrice") -> $650



    #datatable - LIst of List
  Scenario: verify each product price
    Given User is on the HomePage
    Then User should be able to see expected prices in following products with listOfList
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |
#list1 - vertical phones->monitors
  #list2 - horizontal monitors -> 230

#  list1.get(2).get(2) -> 650


#    list of map
#   module -  key
# 0 value =  fleet - first element of the list
# 1 value =  customers
# 2 value =  activities
# 3 value =  system
