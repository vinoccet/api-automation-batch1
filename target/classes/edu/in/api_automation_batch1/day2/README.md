include:
Inheritance
Abstract Classes
Interfaces
Exceptions
…all still mapped to API testing concepts but without heavy frameworks for now. We’ll stick to pretend API scenarios so they relate everything back to automation testing.

# 🌱 Java Basics for API Automation Testing 
---

## 🗂 Topics Covered So Far

- Variables
- Access Modifiers
- Data Types
- Class & Object
- OOP Basics (Encapsulation, Inheritance, Polymorphism, Abstraction)
- ✅ Inheritance
- ✅ Abstract Classes
- ✅ Interfaces
- ✅ Exceptions

---

## 6️⃣ Inheritance – Reusing Test Logic

**Why in API testing?**  
Inheritance allows us to put common setup (like base URL, auth token) in a parent class and share it across all API test classes.

### 🖥 Example:
```java
class ApiTestBase {
    String baseUrl = "https://api.example.com";

    void startTest() {
        System.out.println("Connecting to: " + baseUrl);
    }
}

class UserApiTest extends ApiTestBase {
    void getUser() {
        System.out.println("Pretend sending GET request to: " + baseUrl + "/users");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        UserApiTest test = new UserApiTest();
        test.startTest();
        test.getUser();
    }
}

💡 Beginner Challenge:
Create another child class ProductApiTest that prints "Pretend sending GET request to /products".
Notice: No need to rewrite baseUrl in each class.

7️⃣ Abstract Classes – Defining Common API Behavior
Why in API testing? Abstract classes let us define what all tests must do but leave the how to each specific test.
🖥 Example:
abstract class ApiClient {
    String baseUrl = "https://api.example.com";

    abstract void sendRequest(String endpoint);
}

class GetClient extends ApiClient {
    void sendRequest(String endpoint) {
        System.out.println("GET request to: " + baseUrl + endpoint);
    }
}

class PostClient extends ApiClient {
    void sendRequest(String endpoint) {
        System.out.println("POST request to: " + baseUrl + endpoint);
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        ApiClient get = new GetClient();
        get.sendRequest("/users");

        ApiClient post = new PostClient();
        post.sendRequest("/login");
    }
}

💡 Beginner Challenge:
Create a DeleteClient class extending ApiClient.
Call sendRequest("/users/101") and print "DELETE request...".

8️⃣ Interfaces – API Contracts
Why in API testing? Interfaces define a contract — if a class implements it, it must provide the methods. In automation, we can have interfaces for different test operations (GET, POST, DELETE).
🖥 Example:
interface ApiOperations {
    void get(String endpoint);
    void post(String endpoint);
}

class ApiTestImplementation implements ApiOperations {
    public void get(String endpoint) {
        System.out.println("Pretend GET request to: " + endpoint);
    }

    public void post(String endpoint) {
        System.out.println("Pretend POST request to: " + endpoint);
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        ApiOperations api = new ApiTestImplementation();
        api.get("/users");
        api.post("/login");
    }
}

💡 Beginner Challenge:
Add a delete(String endpoint) method to the interface.
Implement it in ApiTestImplementation.

9️⃣ Exceptions – Handling API Failures
Why in API testing? API calls can fail — network errors, invalid responses, wrong URLs. Java exceptions let us handle these failures gracefully.
🖥 Example:
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            String endpoint = null;
            System.out.println("Testing API: " + endpoint.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Error: Endpoint is null!");
        }

        System.out.println("Test completed.");
    }
}

💡 Beginner Challenge:
Simulate an API call that throws an exception if statusCode != 200.
Use try-catch to print "API call failed with status code...".

🏋️ Real-World API Testing Practice Ideas (Beginner Level)
Common Setup Class → Store base URL & auth token in a parent class, use it in child classes.
Abstract Class for Requests → One abstract method sendRequest(String endpoint) implemented differently for GET, POST, DELETE.
Interface for Test Actions → Define validateStatusCode(int code) and validateResponse(String body) in an interface, implement it in a test class.
Exception Handling in Tests → If status code != 200, throw a custom exception ApiTestFailedException.

📌 Key API Terms to Keep Using in Practice
Base URL → "https://api.example.com"
Endpoint → "/users"
HTTP Methods → GET, POST, PUT, DELETE
Status Code → 200, 404, 500
Auth Token → for authentication
Response Body → JSON/XML returned by API