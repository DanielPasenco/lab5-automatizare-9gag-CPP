## 📋 Cerințe Laborator 6

### Sarcina principală:
> **Automatizează toate testele create la laboratorul nr. 3, folosind Cucumber BDD și Selenium WebDriver.**

### Cerințe specifice:
1. ✅ **Separarea definițiilor pașilor** în funcție de funcționalitate
2. ✅ **Definirea pașilor generici** pentru validarea datelor
3. ✅ **Separarea locatorilor generici** pentru a identifica calea relativă către elementele web
4. ⚠️ **NU utiliza calea ABSOLUTĂ** - doar locatori relativi
5. ✅ **Încărcare pe GitHub** în repository-ul creat la Lab 5

### 🌟 Cerință BONUS:
> Creează cel puțin **1 scenariu folosind Cucumber Data Tables**

**Implementat:** ✅ **2 scenarii cu Data Tables** (TC-05 și TC-06)
## 🎯 Test Cases Automatizate (din Lab 3)

### TC-01: Verify homepage load and layout
- Verificare încărcare homepage
- Validare header, logo, meniu navigare
- Verificare listă produse și imagini

### TC-02: Navigation through main menu
- Navigare Home, Mens, Womens, Contact
- Test negativ: acces URL invalid (404)

### TC-03: Verify product display and details
- Afișare produse pe pagina Mens
- Deschidere pagină produs individual
- Verificare elemente produs (imagine, descriere, buton)
- Navigare înapoi la Mens
- Test negativ: produs inexistent

### TC-04: Quick View modal behaviour
- Deschidere Quick View modal
- Verificare conținut modal
- Închidere modal
- Test negativ: modal pe pagină diferită

### TC-05: Sort products by price ⭐ (cu Data Tables)
- Sortare crescătoare (Low to High)
- Sortare descrescătoare (High to Low)
- Verificare ordine produs
- **Data Table:** 3 variante de sortare

### TC-06: Filter products by price ⭐ (cu Data Tables)
- Filtrare interval valid
- Filtrare doar min/max
- Reset filtru prin reload
- Test negativ: interval invalid
- **Data Table:** 5 scenarii de filtrare

## 🏗️ Arhitectură Proiect

### Page Object Model (Locatori Relativi)
```
src/test/java/com/lab/pages/
├── BasePage.java       → Metode comune + locatori relativi
├── HomePage.java       → Locatori homepage (header, menu, products)
├── MensPage.java       → Locatori mens page (sorting, filtering)
├── ProductPage.java    → Locatori pagină produs
└── QuickViewModal.java → Locatori modal Quick View
```

**Exemplu locatori relativi:**
```java
// ❌ Absolut (GREȘIT):
By header = By.xpath("/html/body/header");

// ✅ Relativ (CORECT):
By header = By.cssSelector("header");
By logo = By.cssSelector("header img, header .logo");
By productList = By.cssSelector(".product-list, .products");

```

### Step Definitions (Separate pe Funcționalități)
```
src/test/java/com/lab/steps/
├── Hooks.java          → @Before/@After - Setup/Teardown
├── CommonSteps.java    → Pași generici validare (URL, 404, layout)
├── HomePageSteps.java  → Pași specifici homepage
├── NavigationSteps.java→ Pași navigare meniu
├── ProductSteps.java   → Pași gestionare produse
├── QuickViewSteps.java → Pași Quick View modal
├── SortingSteps.java   → Pași sortare (cu Data Tables)
└── FilteringSteps.java → Pași filtrare (cu Data Tables)
```

### Feature Files (Gherkin BDD)
```
src/test/resources/features/
├── TC01_HomePage.feature      → 3 scenarii homepage
├── TC02_Navigation.feature    → 5 scenarii navigare
├── TC03_ProductDetails.feature→ 5 scenarii produse
├── TC04_QuickView.feature     → 4 scenarii modal
├── TC05_Sorting.feature       → 4 scenarii (include Data Tables)
└── TC06_Filtering.feature     → 6 scenarii (include Data Tables)
```

### Utilities
```
src/test/java/com/lab/utils/
└── DriverManager.java  → Gestionare WebDriver (Chromium)
```

---

## 🌟 BONUS: Cucumber Data Tables

### Exemplu TC-05 (Sorting):
```gherkin
@DataTable
Scenario Outline: Sort products using different options - Data Table
  Given I am on the mens page
  When I sort products by ""
  Then the products should be sorted ""
  And the sort order should match ""
  
  Examples:
    | sortOption   | expectedOrder |
    | Low to High  | ascending     |
    | High to Low  | descending    |
    | Default      | default       |
```
**Rezultat:** 3 teste automate generate din 1 scenariu! 🎉
### Exemplu TC-06 (Filtering):
```gherkin
@DataTable
Scenario Outline: Filter products with different price ranges - Data Table
  Given I am on the mens page
  When I filter products with min price "" and max price ""
  Then the filtering result should be ""
  And products should match the price criteria "" to ""
  
  Examples:
    | minPrice | maxPrice | expectedResult    |
    | 10       | 50       | products shown    |
    | 20       | 30       | products shown    |
    | 100      | 200      | products shown    |
    | 1000     | 2000     | no products       |
    | 0        | 5        | no products       |
```
**Rezultat:** 5 teste automate generate din 1 scenariu! 🎉

---

## 🛠️ Tehnologii Utilizate

| Tehnologie | Versiune | Scop |
|------------|----------|------|
| Java | 21 | Limbaj de programare |
| Cucumber | 7.14.0 | BDD Framework (Gherkin) |
| Selenium WebDriver | 4.15.0 | Automatizare browser |
| TestNG | 7.8.0 | Test runner & assertions |
| Maven | 3.8+ | Build tool & dependency management |
| Chromium | 142 | Browser pentru teste |

---

## 🚀 Instalare și Rulare

### Prerequisite:
```bash
java -version    # Java 11+
mvn -version     # Maven 3.8+
chromium --version
```

### Instalare dependențe:
```bash
cd lab6
mvn clean install
```

### Rulare toate testele:
```bash
mvn test
```

### Rulare scenarii cu Data Tables:
```bash
mvn test -Dcucumber.filter.tags="@DataTable"
```

### Rulare specific feature:
```bash
mvn test -Dcucumber.features="src/test/resources/features/TC05_Sorting.feature"
```
---

## 📊 Rapoarte Cucumber

După rularea testelor, rapoartele sunt generate automat:

### 1. HTML Report (Recomandat)

### 2. JSON Report (Pentru CI/CD)

### 3. TestNG Report
