# NOVA HR - Employee Management Portal

Full-stack HR/employee portal built with Spring Boot + React.

## Features
- Role based login: Employee, HR, Manager
- BCrypt password hashing + JWT authentication
- CORS configured for React localhost:5173
- Employee dashboard: leave balance, attendance, shortfall, overtime
- Employee leave requests: full day / half day / first or second half
- Manager leave approval/rejection workflow
- HR-managed attendance with hours, shortfall and overtime calculation
- HR-created payslips visible to employees
- Employee daily work status with work done, blockers and tomorrow plan
- HR/Manager can review daily work status
- HR employee directory and announcements
- 10 seeded employees + demo HR and Manager accounts
- H2 local database by default; PostgreSQL/Supabase can be configured later
- Responsive white professional UI

## Run backend
cd backend
mvn clean spring-boot:run

## Run frontend in another terminal
cd frontend
npm install
npm run dev

Open http://localhost:5173

## Demo accounts
HR: hr@company.com / Hr@123
Manager: manager@company.com / Manager@123
Employees: employee@company.com / Employee@123
           rahul@company.com / Employee@123
           priya@company.com / Employee@123
All seeded employees use Employee@123.

The database file is employee_portal_v2 so it starts with the new sample data rather than the earlier demo schema.
