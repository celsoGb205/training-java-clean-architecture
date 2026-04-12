# Fase 03 — HTTP e REST sem Framework

## 🎯 Objetivo

Entender HTTP e REST **sem depender de frameworks** como Spring.

Tudo é simulado em código para provar que:

* Controller é só um adaptador
* HTTP é só um protocolo
* O core da aplicação não depende disso

---

## 🧠 O que esta fase ensina

* Conceitos de REST:

    * Recurso
    * Endpoint
    * Verbo HTTP
    * Status code

* Diferença entre:

    * Controller vs Use Case
    * Recurso vs Ação

* Fluxo real:

```id="flow1"
HTTP Request → Controller → Use Case → Domínio → Use Case → Controller → HTTP Response
```

---

## 🧱 O que foi implementado

Simulação completa de HTTP:

* HttpRequest
* HttpResponse
* HttpMethod
* Router
* UsuarioController

Operações suportadas:

* `POST /users` → criar usuário
* `GET /users/{email}` → buscar usuário

---

## 🧪 Testes unitários

O projeto agora possui testes com JUnit para validar:

* Cadastro de usuário válido
* Bloqueio de email duplicado
* Validação de entrada nula
* Cadastro de múltiplos usuários

---

## ⚙️ Tecnologias

* Java 17
* Maven
* JUnit 5

---

## ▶️ Como rodar o projeto

```id="run1"
mvn clean install
```

---

## 🧪 Como rodar os testes

```id="run2"
mvn test
```

---

## 🧩 Estrutura do projeto

```id="struct1"
src/main/java
├── app/
├── http/
├── controller/
├── application/
├── dominio/
└── infra/

src/test/java
└── testes unitários
```

---

## 📌 Regras arquiteturais

* ❌ Nenhum framework

* ❌ Nenhum servidor real

* ❌ Nenhuma anotação

* ✅ Controller apenas traduz HTTP ↔ DTO

* ✅ Use cases independentes

* ✅ Domínio isolado

---

## 🧠 O que esta fase prova

* REST não depende de framework
* Controller é apenas adaptação
* Aplicação é independente de transporte (HTTP)
* Arquitetura desacoplada

---

## ⚠️ Observação

Não existe servidor real.

O `Main` simula requisições HTTP manualmente.

---

## ⏭️ Próxima fase

Fase 04 — Spring Boot + REST

Aqui o HTTP simulado será substituído por Spring,
sem alterar domínio ou use cases.
