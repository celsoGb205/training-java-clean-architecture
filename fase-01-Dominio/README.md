## Fase 1 — Domínio em Java

### Objetivo
Construir um domínio sólido **sem frameworks**, aplicando princípios de orientação a objetos.

### Decisões técnicas
- `Email` define a identidade do usuário.
- `Nome` e `Email` são **Value Objects imutáveis**.
- `equals()`/`hashCode()` baseados na identidade.
- Repositório de memória usando `Set`.
- Estados inválidos lançam **exceções de domínio** (ex.: `InvalidDomainStateException`).

### Teste Real (Critério de aceitação)
- Dois usuários com o **mesmo email não podem ser cadastrados**.

### Status atual
- Estrutura básica de pacote criada.
- Decisões técnicas documentadas.
- Implementações de entidades e repositório iniciadas.

### Próximas fases
- **Fase 2 — HTTP e REST**