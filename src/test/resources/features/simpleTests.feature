Feature: Basic tests

  @SomeTag
  Scenario: Open browser and visit page with some validations
    Given Open browser "chrome" and visit page
    When Check "title" has text "Інтернет-магазин ROZETKA™: офіційний сайт онлайн-гіпермаркету Розетка в Україні"