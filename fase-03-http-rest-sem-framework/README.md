# Fase 03 — HTTP e REST sem Framework

## 🎯 Objetivo

Nesta fase, o objetivo é:

> **Entender HTTP e REST de verdade, sem Spring, sem servidor e sem framework.**

Aqui não existe rede, não existe Tomcat, não existe controller do Spring.

Tudo é **simulado em código** para provar que:

- Controller é só um adaptador
- HTTP é só um protocolo
- O core da aplicação não depende de nada disso

---

## 🧠 O que esta fase ensina

- O que é:
    - Recurso
    - Endpoint
    - Verbo HTTP
    - Status code
- Diferença entre:
    - Recurso vs Ação
    - Controller vs Use Case
- Como funciona o fluxo real:
```texto
HTTP Request → Controller → Use Case → Domínio → Use Case → Controller → HTTP Response
```

---

## 🧱 O que é construído nesta fase

Tudo é simulado em código:

- `HttpRequest`
- `HttpResponse`
- `HttpMethod`
- `Router` (dispatcher)
- `UsuarioController`

E são suportadas duas operações REST:

- `POST /users` → criar usuário
- `GET /users/{email}` → buscar usuário por email

---

## 🧩 Estrutura do projeto

```texto
fase-03-http-rest-sem-framework/
└── src/
├── app/
│ └── Main.java
│
├── http/
│ ├── HttpRequest.java
│ ├── HttpResponse.java
│ ├── HttpMethod.java
│ ├── Router.java
│ └── Controller.java
│
├── controller/
│ └── UsuarioController.java
│
├── application/
│ ├── dto/
│ ├── usecase/
│ └── ports/
│
├── dominio/
│ └── (entidades e value objects)
│
└── infra/
└── (repositório em memória)
```

---

## 📌 Regras arquiteturais da fase

- ❌ Nenhum framework
- ❌ Nenhum servidor real
- ❌ Nenhuma anotação
- ❌ Nenhuma dependência HTTP no domínio ou nos use cases

- ✅ Controller só traduz:
    - HTTP ↔ DTO
- ✅ Use cases continuam iguais aos da Fase 02
- ✅ Domínio continua totalmente isolado

---

## 🧪 Teste real desta fase

> Se amanhã você jogar fora todo esse HTTP fake e colocar Spring:
>
> - O domínio NÃO MUDA
> - Os use cases NÃO MUDAM
>
> Se mudar → a arquitetura está errada.

---

## 🧠 O que esta fase prova

- Que REST não depende de framework
- Que controller é só um adaptador
- Que sua aplicação é independente de transporte (HTTP)
- Que sua arquitetura não é acoplada a tecnologia

---

## ⚠️ Observação importante

Não existe servidor real.

O `Main` **simula** chamadas HTTP criando `HttpRequest` na mão e passando para o `Router`.

---

## ⏭️ Próxima fase

**Fase 04 — Spring Boot + REST**

Aqui o HTTP fake é substituído por Spring.

O domínio e os use cases continuam exatamente iguais.

