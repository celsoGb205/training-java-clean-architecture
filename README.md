# Roadmap Backend Java (por fases)

Este repositório é um treino estruturado de backend em Java, dividido em fases independentes.
A ideia é evoluir por checkpoints, com entregáveis técnicos e critérios objetivos por fase.

## Regras
- Cada fase é uma pasta própria.
- Sem “checklist ilusório”: fase só conta como concluída com entregáveis (código rodando + README da fase).
- Nada de framework cedo: primeiro domínio, depois camada de aplicação, depois HTTP/REST, depois Spring.

## Fases
- **fase-01-dominio**: Value Objects, imutabilidade, equals/hashCode, regras de domínio, repository em memória
- **fase-02-camada-de-aplicacao**: Use Cases, DTOs, Ports, orquestração (sem HTTP)
- **fase-03-http-rest-sem-framework**: HTTP/REST na prática sem Spring (request/response, status codes, rotas)
- **fase-04-spring-boot-rest**: Controllers, DI/IoC, mappers, tratamento de erros
- **fase-05-banco-de-dados-jpa**: JPA/Hibernate, SQL gerado, paginação, N+1, índices
- **fase-06-autenticacao-e-seguranca**: auth vs authz, JWT, refresh token, ataques comuns
- **fase-07-testes**: testes de domínio/use case, testes sem Spring, testes de integração, Mockito com critério
- **fase-08-deploy**: docker, config por ambiente, migração, health check, rollback
- **fase-09-projeto-final**: projeto completo com trade-offs e documentação técnica

## Como usar
Abra a pasta da fase no IntelliJ como um projeto separado (evita conflito de classpath entre fases).
