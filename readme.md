src/main/java/com/example/ems

├── controller
│   ├── EmployeeController
│   └── DepartmentController
│
├── service
│   ├── EmployeeService
│   ├── DepartmentService
│   └── impl
│
├── repository
│   ├── EmployeeRepository
│   └── DepartmentRepository
│
├── entity
│   ├── Employee
│   ├── Department
│   └── EmployeeStatus
│
├── dto
│   ├── EmployeeRequestDto
│   ├── EmployeeResponseDto
│   └── DepartmentDto
│
├── exception
│   ├── EmployeeNotFoundException
│   ├── DepartmentNotFoundException
│   └── GlobalExceptionHandler
│
└── EmployeeManagementApplication

Employee Endpoints

| Method | Endpoint                            | Description          |
| ------ | ----------------------------------- | -------------------- |
| POST   | /api/employees                      | Add employee         |
| GET    | /api/employees                      | Get all employees    |
| GET    | /api/employees/{id}                 | Get employee by id   |
| PUT    | /api/employees/{id}                 | Update employee      |
| DELETE | /api/employees/{id}                 | Delete employee      |
| GET    | /api/employees/search?name=ankit    | Search by name       |
| GET    | /api/employees/search?department=IT | Search by department |


Department Endpoints

| Method | Endpoint              |
| ------ | --------------------- |
| POST   | /api/departments      |
| GET    | /api/departments      |
| GET    | /api/departments/{id} |
| PUT    | /api/departments/{id} |
| DELETE | /api/departments/{id} |
