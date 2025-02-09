# Currency Converter API

A **Spring Boot** application that integrates with a public API to provide real-time currency conversion.

## 📌 Features
- Fetches real-time exchange rates from an external API.
- Converts amounts between different currencies.
- REST API with structured responses.
- Error handling for invalid currency codes and API failures.

---

## 🚀 Getting Started

### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/your-username/currency-converter.git
cd currency-converter

# Setup the Project
Install Java 17+
Install Maven
Install Eclipse IDE (or IntelliJ IDEA)

Configure API Key
Update src/main/resources/application.properties:
      "spring.application.name=CurrencyConverter
      exchange.api.url=http://api.exchangeratesapi.io/v1/latest?access_key=YOUR_ACCESS_KEY
      server.port=8080"


#Build and Run

    mvn clean install
    mvn spring-boot:run


Fetch Exchange Rates
        GET /api/rates?base=USD



            {
    "base": "USD",
    "rates": {
        "EUR": 0.94,
        "INR": 83.0
    }
}


Convert Currency
POST /api/convert




{
    "from": "USD",
    "to": "EUR",
    "amount": 100
}
