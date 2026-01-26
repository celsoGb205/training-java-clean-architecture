# Fase 02 — Camada de Aplicação (Use Cases, DTOs e Ports)

## 🎯 Objetivo

Nesta fase, o objetivo é separar claramente:

- Domínio (regras de negócio)
- Camada de aplicação (casos de uso)
- Infraestrutura (implementações técnicas)
- Interface (CLI)

Aqui **não existe framework** e **não existe banco real**.  
O foco é **arquitetura, responsabilidade e fluxo correto de dependências**.

---

## 🧱 Estrutura do projeto

```text
src/
 ├── app/
 │   └── CadastroDeUsuarioCLI.java
 │
 ├── application/
 │   ├── dto/
 │   │   ├── BuscarPorEmailInput.java
 │   │   ├── BuscarPorEmailOutput.java
 │   │   ├── CadastrarUsuarioInput.java
 │   │   └── CadastrarUsuarioOutput.java
 │   │
 │   ├── ports/
 │   │   └── UsuarioRepository.java
 │   │
 │   └── usecase/
 │       ├── BuscarPorEmailUseCase.java
 │       └── CadastrarUsuarioUseCase.java
 │
 ├── dominio/
 │   ├── Nome.java
 │   ├── Email.java
 │   ├── Usuario.java
 │   ├── UsuarioJaExisteException.java
 │   └── UsuarioNaoEncontradoException.java
 │
 └── infra/
     └── InMemoryUsuarioRepository.java
```

---

## 🧠 Conceitos aplicados

- Clean Architecture
- Separação de responsabilidades
- Dependency Inversion (a aplicação depende de interfaces, não de implementações)
- Use Cases como orquestradores de regras
- Domínio isolado de infra e de interface
- DTOs para comunicação entre camadas

---

## 📌 Casos de uso implementados

- `CadastrarUsuarioUseCase`
    - Regra: não permite cadastrar dois usuários com o mesmo email
- `BuscarPorEmailUseCase`
    - Regra: lança exceção se o usuário não existir

---

## 🚫 Regras arquiteturais respeitadas

- O domínio **não conhece**:
    - CLI
    - Infra
    - DTO
- Use cases:
    - Não usam `Scanner`
    - Não usam `System.out`
    - Não conhecem implementações concretas de repositório
- CLI:
    - Não contém regra de negócio
    - Apenas monta DTOs, chama use cases e imprime resultados

---


O programa permite:

- Cadastrar usuários
- Buscar usuários por email
- Rejeitar emails duplicados
- Tratar erros de domínio com mensagens amigáveis

---

## 🧪 Observação importante

O repositório usado é **InMemory**.

Isso significa que:
- Os dados existem **apenas enquanto o programa está rodando**
- Ao encerrar o programa, tudo é perdido

Isso é intencional nesta fase.

---

## ✅ O que esta fase prova

- Que a aplicação funciona **sem framework**
- Que a arquitetura é independente de interface e infraestrutura
- Que os casos de uso podem ser testados isoladamente
- Que o domínio está protegido de detalhes técnicos

---

## ⏭️ Próxima fase

**Fase 03 — HTTP e REST sem framework**

O objetivo será:
- Simular controllers HTTP
- Simular request/response
- Traduzir HTTP ↔ DTO ↔ Use Case ↔ DTO ↔ HTTP
- Entender REST sem depender de Spring
