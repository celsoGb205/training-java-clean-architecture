Fase 01 - Domínio em Java

objetivo:
Construir um domínio sólido sem frameworks.


Decisões técnicas:

 - Email define a identidade do usuário.
 - Nome e Email são Value Objetcs imutaveis.
 - equals/hashCode baseados em identidade.
 - Repositório em memória usando Set.

Teste Real:

 - Dois usuários com o mesmo email não pode ser cadastrado.
 - Estados inválidos lançam exceções de domínio