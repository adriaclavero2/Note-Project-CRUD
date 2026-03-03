# CRUD Note Project
**Description**: A Java-based backend application designed to manage personal notes. It implements a layered architecture to handle note persistence in a MongoDB database (running on Docker), including automatic tracking of creation timestamps.

## 📌 Exercise Statement
Develop a robust system to Create, Read, Update, and Delete (CRUD) notes. Each note must consist of a title, content, and a creation date. The project must demonstrate best practices in software development, such as:
- Separation of concerns (Service and Repository layers).
- Defensive programming via custom Exception handling.
- Automated Integration Testing to verify database interactions.

## ✨ Features
- **Create**: Add new notes. The system automatically assigns a creation date.
- **Read**: Search and retrieve specific notes using their title.
- **Update**: Modify the content of existing notes safely.
- **Delete**: Remove notes from the database by title.
- **Data Integrity**: The Service layer validates business rules before any persistence operation.

## 🛠 Technologies
- **Backend**: Java 21
- **Database**: MongoDB (deployed via Docker)
- **Dependency Management**: Maven
- **Core Libraries**:
  - `mongodb-driver-sync`: Official MongoDB Java driver.
  - `dotenv-java`: Secure management of environment variables.
  - `JUnit 5`: Testing framework for unit and integration tests.

## 🚀 Installation and Execution
1. **Clone the repository**:
   ```bash
   git clone [https://github.com/adriaclavero2/Note-Project-CRUD.git](https://github.com/adriaclavero2/Note-Project-CRUD.git)
2. **Environment Variables:**
    Create a .env file in the root directory and configure your credentials:

MONGO_USER=your_user
MONGO_PASSWORD=your_password
MONGO_HOST=localhost
MONGO_PORT=27017
MONGO_DB=your_db_name

3. **Application Execution:**
    Run the Main.java file from your IDE or use Maven:

Bash
mvn compile exec:java -Dexec.mainClass="example.Main"

4. **Testing:**
    To run the integration and unit tests:

Bash
mvn test

🧩 Diagrams and Technical Decisions
Layered Architecture: Organized into model, service, persistence (Repository), and config to ensure high maintainability.

Defensive Programming: Use of custom exceptions instead of console prints in the Service layer to allow for flexible error handling.

Integration Tests (AAA Pattern): Tests follow the Arrange-Act-Assert structure, interacting with a real MongoDB instance to guarantee that queries and data mapping work as expected.
