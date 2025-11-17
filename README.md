# Laboratoare Automatizare Testing - CPP

Repository pentru laboratoarele 5, 6 și 7 de automatizare testing.

---

## 📁 Structura Repository-ului
```
├── lab5/    → TestNG Automation (9gag.com)
├── lab6/    → Cucumber BDD Automation (adoring-pasteur site)
└── lab7/    → Cucumber BDD Automation (Google Search)
```

---

## 🔬 Lab 5 - TestNG Automation

**Website:** https://9gag.com  
**Framework:** Selenium WebDriver + TestNG

**Rulare:**
```bash
cd lab5
mvn clean test
```

---

## 🥒 Lab 6 - Cucumber BDD Automation

**Website:** https://adoring-pasteur-3ae17d.netlify.app/  
**Framework:** Selenium + Cucumber BDD + Page Object Model

**Caracteristici:**
- ✅ Gherkin scenarios (6 feature files)
- ✅ Page Object Model
- ✅ Step Definitions organizate pe funcționalități
- ✅ Data Tables (BONUS)
- ✅ Locatori relativi (nu absoluti)

**Rulare:**
```bash
cd lab6
mvn clean test
```

---

## 🔍 Lab 7 - Google Search Automation (Cucumber BDD)

**Website:** https://www.google.co.in  
**Framework:** Selenium + Cucumber BDD + Page Object Model  
**Varianta:** 1 (Google Search Testing)

**Test Cases:**
- TC-01: Verificare deschidere pagină Google
- TC-02: Verificare număr rezultate căutare
- TC-03: Testare căutare goală
- TC-04: Verificare sugestii "Did you mean"

**Caracteristici:**
- ✅ 4 feature files, 6 scenarii Gherkin
- ✅ Page Object Model cu locatori relativi
- ✅ Step Definitions separate pe funcționalități
- ✅ Pași generici pentru validare
- ✅ Rapoarte HTML automate
- ✅ Screenshots la eșecuri
- ✅ 100% teste PASSED (6/6)

**Rulare:**
```bash
cd lab7
mvn clean test
```

**Rapoarte:**
```bash
# Vizualizare raport HTML
firefox target/cucumber-reports/cucumber.html
```

---

## 👨‍💻 Autor

**Daniel Pasenco**  
Grupa: SI-221

---

## 📊 Statistici

| Lab | Test Cases | Scenarii | Framework | Status |
|-----|------------|----------|-----------|--------|
| Lab 5 | - | - | TestNG | ✅ |
| Lab 6 | 6 | 33 | Cucumber BDD | ✅ |
| Lab 7 | 4 | 6 | Cucumber BDD | ✅ 100% |
