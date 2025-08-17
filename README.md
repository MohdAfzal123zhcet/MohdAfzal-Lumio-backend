# Meeting Summarizer Backend

A Spring Boot backend service for the Meeting Summarizer app.  
Features:
- Generate summaries using **Groq API (LLaMA model)**
- Send emails with **SMTP (Gmail/Mailjet supported)**
- REST APIs for summary + email
- Dockerized for easy deployment (Railway, local Docker)

---

## 🚀 Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Mail (JavaMailSender)
- Docker
- Railway (deployment)

---

## ⚙️ Setup

### 1. Clone the repository
```bash
git clone https://github.com/your-username/meeting-summarizer-backend.git
cd meeting-summarizer-backend



GROQ_API_KEY=your_groq_key

# Mail configuration
SPRING_MAIL_HOST=smtp.gmail.com
SPRING_MAIL_PORT=587
SPRING_MAIL_USERNAME=your_email@gmail.com
SPRING_MAIL_PASSWORD=your_app_password
MAIL_FROM=your_email@gmail.com


Backend will start on:
👉 http://localhost:8080



docker build -t meeting-summarizer-backend .
docker run -p 8080:8080 --env-file .env meeting-summarizer-backend




📡 API Endpoints
1. Summarize
POST /summarize


Body (JSON):

{
  "transcript": "Today we discussed project updates...",
  "prompt": "Summarize this meeting"
}

2. Send Email
POST /send-email


Body (JSON):

{
  "to": ["user@example.com"],
  "subject": "Meeting Summary",
  "body": "Here is your summary..."
}

🚀 Deployment

Supports Railway/Heroku/DockerHub.
On Railway, set environment variables (SPRING_MAIL_*, MAIL_FROM, GROQ_API_KEY) in the project settings.
