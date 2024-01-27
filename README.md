# Challenge1 Spring Boot Application

This is a simple Spring Boot application that provides an API endpoint for creating contacts. The project was generated using https://start.spring.io/.

## Dependencies

- Java 17
- Maven

## How to Run

1. Clone this repository.
2. Open IntelliJ and import the project.
3. Run the project.
4. Or you can run from a terminal window by running:

```bash
mvn spring-boot:run
```

4. The application will start on http://localhost:8080.

## API Endpoint

### Create Contact

- **Endpoint**: POST /create_contact
- **Request Body Format**:

```json
{
 "name": "John Doe",
 "email": "john.doe@example.com",
 "message": "Hello, I'm interested in your services.",
 "interest": "Product Inquiry"
}
``` 
Response Body Format:

```json
{
  "msg": "Thank John Doe, for getting in touch and sharing your interests. We look forward to hearing from you soon."
}
```

## Error Handling
If the request is missing required fields or contains invalid data, a 400 Bad Request response is returned with an error message.
If an internal server error occurs, a 500 Internal Server Error response is returned with a generic error message.

## Testing
Ensure that all dependencies are installed.

Run the following command:

```bash
mvn test
```
Check the test results for any failures.
