Feature: Onliner Auto Window

  Scenario: check points of onliner.by auto
    When hover the cursor over "Автобарахолка"
    Then browse fields "Авто до ..."
    Then browse fields "cities"
    Then browse fields "auto brands"

  Scenario: check points of onliner.by apartments
    When hover the cursor over "Дома и квартиры"
    Then browse fields "cities"
    Then browse fields "rooms amount"
    Then browse fields "apartment price"