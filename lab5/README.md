# Laborator 5 - Test Automatizat pentru 9gag.com

## Varianta 8

**Sarcina:**
- Deschide 9gag.com
- Caută "computer"
- Verifică dacă antetul 9gag este afișat

## Tehnologii folosite
- Java 21
- Maven
- Selenium WebDriver 4.15.0
- TestNG 7.8.0
- Chromium Browser

## Cum se rulează

### Instalare dependențe:
```bash
mvn clean install
```

### Rulare teste:
```bash
mvn test
```

## Rezultate
Toate testele rulează cu succes:
- ✅ Test deschidere 9gag.com
- ✅ Test verificare antet
- ✅ Test căutare "computer"
- ✅ Test verificare finală
