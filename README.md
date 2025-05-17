Установка
1. Клонируйте репозиторий:
   git clone https://github.com/Nikita12-3/lab1DockerTodoList.git
2. docker-compose up --build

Работа:
Создать нового доктора:
curl -X POST http://localhost:8080/api/doctors
-H "Content-Type: application/json" 
-d '{"firstName": "Андрей", "lastName": "Смирнов", "specialty": "Кардиолог"}'

Создать новую запись к врачу:
curl -X POST http://localhost:8080/api/appointments 
-H "Content-Type: application/json" 
-d '{"date": "2024-01-10T09:00:00", "patientLastName": "Петров", "doctorId": 1}'

Получить статистику по записям по месяцам:
curl -X GET http://localhost:8080/api/reports/by-month

Получить статистику, к какому врачу(по фамилии) сколько записей:
curl -X GET http://localhost:8080/api/reports/by-doctor

Получить статистику к какому специалисту сколько записей:
curl -X GET http://localhost:8080/api/reports/by-speciality