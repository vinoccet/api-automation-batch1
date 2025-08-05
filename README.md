# 🌱 Java Basics for API Automation Testing (Beginner-Friendly)

> **Goal for this stage:**  
> Learn Java fundamentals while keeping API testing in mind.  
> No real HTTP calls yet — just understand how Java stores, processes, and structures data that we’ll use in API automation.

---

## 🗂 Topics Covered in This Module

1. Java Variables (storing API request/response data)
2. Access Modifiers (hiding sensitive API info)
3. Data Types (matching API response values)
4. Class & Object (structuring test code)
5. OOP Concepts (designing reusable API test components)

---

## 1️⃣ Java Variables – Storing API Data

**What is it?**  
A variable is like a container to store data — in API testing, we store:
- Base URL
- Endpoints
- API tokens
- Status codes
- Response messages

### 🖥 Example:
```java
public class ApiBasics {
    public static void main(String[] args) {
        String baseUrl = "https://api.example.com";
        String endpoint = "/users";
        int expectedStatus = 200;

        System.out.println("Testing API: " + baseUrl + endpoint);
        System.out.println("Expected Status Code: " + expectedStatus);
    }
}

💡 Beginner Challenge:
Add a variable for authToken (pretend value).
Print "Token is ready to be used for API calls".

2️⃣ Access Modifiers – Keeping API Secrets Safe
Why? Some data in API testing is sensitive (passwords, tokens). Access modifiers control who can see/change them in the code.
public → Can be used anywhere
private → Only inside the same class
protected → Same package + subclasses
(default) → Same package only
🖥 Example:
class AuthDetails {
    private String token = "SECRET_TOKEN_123"; // private for safety

    public String getToken() {
        return token; // controlled access
    }
}

public class AccessExample {
    public static void main(String[] args) {
        AuthDetails auth = new AuthDetails();
        System.out.println("Token from getter: " + auth.getToken());
    }
}

💡 Beginner Challenge:
Try accessing token directly — see what error appears.
Change it to public — discuss why this could be risky in API automation.

3️⃣ Data Types – Matching API Response Fields
Why? When we get an API response, it has different types of data:
"id": 101 → int
"price": 19.99 → double
"active": true → boolean
"name": "John" → String
🖥 Example:
public class UserResponse {
    int id;
    String name;
    boolean active;

    public static void main(String[] args) {
        UserResponse user = new UserResponse();
        user.id = 101;
        user.name = "Alice";
        user.active = true;

        System.out.println("User: " + user.name + " (Active: " + user.active + ")");
    }
}

💡 Beginner Challenge:
Add a double variable for accountBalance.
Print all user details in one line.

4️⃣ Class & Object – Structuring Test Code
Why? In API testing, we may have:
Class → Blueprint for requests, responses, or tests
Object → Actual instance with real data
🖥 Example:
class ApiRequest {
    String endpoint;
    String method;

    void printRequest() {
        System.out.println("Method: " + method + " | Endpoint: " + endpoint);
    }
}

public class ApiTest {
    public static void main(String[] args) {
        ApiRequest req = new ApiRequest();
        req.method = "GET";
        req.endpoint = "/users";
        req.printRequest();
    }
}

💡 Beginner Challenge:
Create another request object for a POST /login.
Print both requests.

5️⃣ OOP Concepts – Building Reusable API Test Components
Why? OOP helps us:
Encapsulation → Hide how requests are built
Inheritance → Share setup logic across tests
Polymorphism → Use same method name for different HTTP methods
Abstraction → Define “what to do” but not “how”
🖥 Example (Beginner-friendly):
abstract class ApiClient {
    abstract void sendRequest(String endpoint);
}

class GetClient extends ApiClient {
    void sendRequest(String endpoint) {
        System.out.println("Pretend sending GET to: " + endpoint);
    }
}

class PostClient extends ApiClient {
    void sendRequest(String endpoint) {
        System.out.println("Pretend sending POST to: " + endpoint);
    }
}

public class OopExample {
    public static void main(String[] args) {
        ApiClient get = new GetClient();
        ApiClient post = new PostClient();

        get.sendRequest("/users");
        post.sendRequest("/login");
    }
}

💡 Beginner Challenge:
Add a DeleteClient class.
Use the same sendRequest method name but print "Pretend sending DELETE...".

📌 Real-World API Testing References (Beginner Stage)
These terms will be common in automation and will appear in examples:
Base URL → https://api.example.com
Endpoint → /users, /login
Method → GET, POST, DELETE
Status Code → 200, 404, 500
Token → Used for authentication
We will use these in variables, classes, and objects during practice.

🏋️ Practice Problems for Freshers
Store baseUrl, endpoint, and expectedStatusCode as variables and print them.
Create a LoginDetails class with username and password variables.
Create a User class with id, email, and isActive → assign sample data.
Make a base class ApiTestBase with a method to print "Test Started", and extend it in another class.

🎯 What’s Next in the Course
Once we’re comfortable with:
Variables
Access Modifiers
Data Types
Classes & Objects
OOP basics
We’ll move on to:
Using RestAssured for real API calls
Parsing JSON into Java objects
Validating API responses with Java code
Building a mini API automation framework
