# SpringGithubCopilotSdk

## EN

A simple Spring Boot application with one HTTP endpoint that sends a prompt to Copilot SDK and returns the assistant response.

### Requirements

- Java 25
- Internet access (to download Maven dependencies)
- Windows PowerShell (commands below)

### Tech Stack

- Spring Boot `4.1.0-SNAPSHOT`
- Maven Wrapper (`mvnw`, `mvnw.cmd`)
- `io.github.copilot-community-sdk:copilot-sdk:1.0.11`

### Run Locally

```powershell
Push-Location "C:\Data\Java\SpringGithubCopilotSdk"
.\mvnw.cmd spring-boot:run
Pop-Location
```

By default, the app starts on port `8080`.

### Endpoint

- `GET /`
- Query parameter: `text` (optional)
- Default value: `What is 2+2?`

Example calls:

```powershell
curl "http://localhost:8080/"
curl "http://localhost:8080/?text=Briefly%20explain%20Spring%20Boot"
```

Example response:

```text
Response: ...
```

### Tests

```powershell
Push-Location "C:\Data\Java\SpringGithubCopilotSdk"
.\mvnw.cmd test
Pop-Location
```

### Structure

- `src/main/java/com/example/demo/DemoApplication.java` - Spring Boot entry point
- `src/main/java/com/example/demo/HelloController.java` - `GET /` endpoint
- `src/test/java/com/example/demo/DemoApplicationTests.java` - application context test

## PL

Prosta aplikacja Spring Boot z jednym endpointem HTTP, ktory wysyla prompt do Copilot SDK i zwraca odpowiedz asystenta.

### Wymagania

- Java 25
- Dostep do internetu (pobieranie zaleznosci Maven)
- Windows PowerShell (przyklady polecen ponizej)

### Technologie

- Spring Boot `4.1.0-SNAPSHOT`
- Maven Wrapper (`mvnw`, `mvnw.cmd`)
- `io.github.copilot-community-sdk:copilot-sdk:1.0.11`

### Uruchomienie lokalne

```powershell
Push-Location "C:\Data\Java\SpringGithubCopilotSdk"
.\mvnw.cmd spring-boot:run
Pop-Location
```

Domyslnie aplikacja startuje na porcie `8080`.

### Endpoint

- `GET /`
- Parametr zapytania: `text` (opcjonalny)
- Domyslna wartosc parametru: `What is 2+2?`

Przykladowe wywolania:

```powershell
curl "http://localhost:8080/"
curl "http://localhost:8080/?text=Opisz%20krotko%20Spring%20Boot"
```

Przykladowa odpowiedz:

```text
Odpowiedz: ...
```

### Testy

```powershell
Push-Location "C:\Data\Java\SpringGithubCopilotSdk"
.\mvnw.cmd test
Pop-Location
```

### Struktura

- `src/main/java/com/example/demo/DemoApplication.java` - klasa startowa Spring Boot
- `src/main/java/com/example/demo/HelloController.java` - endpoint `GET /`
- `src/test/java/com/example/demo/DemoApplicationTests.java` - test kontekstu aplikacji

---

