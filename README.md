# NOVA HR — Employee Portal

Full-stack employee self-service portal using React + Vite and Spring Boot 3.

## Features
- Login and signup
- BCrypt password hashing
- JWT authentication
- Employee dashboard
- Attendance history
- Leave requests and status
- Payslip UI
- Profile editing
- Company announcements
- Responsive white UI
- Local H2 database for zero-setup development
- PostgreSQL/Supabase support through environment variables

## Fastest local setup

### Backend
Requirements: Java 17+ and Maven.

```powershell
cd backend
mvn spring-boot:run
```

Backend: `http://localhost:8080`

No PostgreSQL, Docker, psql, or database setup is required. H2 automatically stores the local database under `backend/data/employee_portal`.

### Frontend
Open another PowerShell:

```powershell
cd frontend
npm install
npm run dev
```

Open `http://localhost:5173`.

## Demo accounts

- Employee: `employee@company.com` / `Employee@123`
- HR: `hr@company.com` / `Hr@123`
- Admin: `admin@company.com` / `Admin@123`

New signup accounts are created as `EMPLOYEE`.

## Supabase later

Set these environment variables before starting the backend:

```powershell
$env:DATABASE_URL="jdbc:postgresql://YOUR_SUPABASE_HOST:5432/postgres?sslmode=require"
$env:DATABASE_USERNAME="postgres"
$env:DATABASE_PASSWORD="YOUR_SUPABASE_DATABASE_PASSWORD"
$env:JWT_SECRET="a-long-random-secret"
mvn spring-boot:run
```

The application automatically switches from H2 to PostgreSQL when `DATABASE_URL` is provided. See `START-HERE.md` for the full setup.

Never commit real database credentials or JWT secrets.
