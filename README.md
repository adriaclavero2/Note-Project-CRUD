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
