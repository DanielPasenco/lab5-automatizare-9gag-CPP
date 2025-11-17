# 🔍 Laborator 7 - Google Search Automation cu Cucumber BDD

**Student:** Daniel Pasenco  
**Grupa:** SI-221  
**Website testat:** https://www.google.co.in  
**Repository:** https://github.com/DanielPasenco/lab5-automatizare-9gag-CPP

---

## 📋 Cerințe Lab 7 - Varianta 1

### Test Cases Implementate:

**TC-01:** Verifică dacă pagina Google se deschide după introducerea adresei https://www.google.co.in

**TC-02:** Verifică câte rezultate sunt afișate pe o singură pagină

**TC-03:** Dacă nu introduci nimic și doar apeși pe „Căutare", nu ar trebui să se întâmple nimic

**TC-04:** Dacă un utilizator caută ceva irelevant, ar trebui să fie afișat linkul „Did you mean"

---

## 🚀 Rulare Teste

### Instalare dependințe:
```bash
mvn clean install
```

### Rulare toate testele:
```bash
mvn test
```

### Rulare test specific:
```bash
mvn test -Dcucumber.filter.tags="@Smoke"
```

---

## 📊 Rapoarte Generate

### 1. Cucumber HTML Report
```bash
firefox target/cucumber-reports/cucumber.html
```

### 2. ExtentReports (Profesional)
```bash
firefox target/extent-reports/ExtentReport.html
```

### 3. Screenshots
```bash
ls target/screenshots/
```

---

## 📁 Structură Proiect
```
lab7/
├── src/test/
│   ├── java/com/lab/
│   │   ├── pages/
│   │   │   ├── BasePage.java
│   │   │   └── GoogleSearchPage.java
│   │   ├── steps/
│   │   │   ├── Hooks.java
│   │   │   ├── CommonSteps.java
│   │   │   ├── SearchSteps.java
│   │   │   └── DidYouMeanSteps.java
│   │   ├── runners/
│   │   │   └── TestRunner.java
│   │   └── utils/
│   │       └── DriverManager.java
│   └── resources/
│       ├── features/
│       │   ├── TC01_GooglePageLoad.feature
│       │   ├── TC02_SearchResultsCount.feature
│       │   ├── TC03_EmptySearch.feature
│       │   └── TC04_DidYouMean.feature
│       ├── extent.properties
│       └── extent-config.xml
├── pom.xml
├── testng.xml
└── README.md
```

---

## ✅ Cerințe Îndeplinite

| Cerință | Status |
|---------|--------|
| Cucumber BDD | ✅ |
| Separare Step Definitions | ✅ |
| Pași generici validare | ✅ |
| Locatori relativi | ✅ |
| Chrome browser | ✅ |
| Rapoarte HTML | ✅ |
| Screenshots | ✅ |
| GitHub | ✅ |

---

## 👨‍💻 Autor

**Daniel Pasenco**  
Data: Noiembrie 2025
