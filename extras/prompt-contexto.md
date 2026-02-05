# Criação do contexto técnico do projeto (`.ai/`)

> Você está operando em **Agent Mode**, com permissão para criar arquivos e escrever documentação.
>
> Atue como um **Staff Engineer / Tech Lead Java**, responsável por preparar o **contexto técnico e arquitetural** de um projeto que será implementado posteriormente por outro agente.
>
> Pense como se estivesse escrevendo documentação interna para um time real.

---

## 🎯 Objetivo

Criar uma pasta `.ai/` na raiz do projeto contendo documentos **claros, prescritivos e não genéricos**, que definem:

* padrões de código
* decisões arquiteturais
* stack tecnológica aprovada
* regras de negócio e domínio

Esses arquivos **não são explicativos**; eles **definem regras** que devem ser seguidas.

---

## 📁 Estrutura obrigatória

Criar exatamente a seguinte estrutura:

```
.ai/
├── standards.md
├── architecture.md
├── tech-stack.md
└── business-rules.md
```

---

## 📄 Conteúdo esperado (DETALHADO)

### 🔹 `.ai/standards.md` — Padrões de código e estilo

Defina regras **concretas**, incluindo:

* Java 25 como versão mínima
* Uso de:

  * `record` para DTOs imutáveis
  * `Optional` apenas em retornos, nunca em campos
  * `Stream API` para filtros e ordenações
* Convenções REST:

  * Controllers finos
  * Lógica apenas em Services
* Organização de pacotes:

  ```
  controller
  service
  repository
  domain
  dto
  config
  error
  ```
* Padrão de resposta JSON consistente
* Validações usando `jakarta.validation`
* Código legível > abstrações complexas
* Testes são desejáveis, mas não obrigatórios

Evite qualquer linguagem vaga como “quando possível”.

---

### 🔹 `.ai/architecture.md` — Arquitetura e decisões

Descreva explicitamente:

* Arquitetura em camadas (Spring MVC)
* Dados mantidos **em memória**
* Uso de:

  * `CommandLineRunner` ou inicializador dedicado para dataset fake
* Nenhum banco externo obrigatório
* Nenhuma chamada HTTP externa permitida
* O projeto **não é**:

  * um crawler
  * um agregador real
  * um proxy para APIs externas

Inclua 2–3 decisões arquiteturais no formato:

```text
Decision:
Context:
Consequence:
```

---

### 🔹 `.ai/tech-stack.md` — Stack tecnológica (PRESCRITIVO)

Defina explicitamente:

* **Java 25**
* Spring Boot (compatível com Java 25)
* Build tool: Maven
* Dependências aprovadas:

  * spring-boot-starter-web
  * spring-boot-starter-validation
  * springdoc-openapi
  * jackson-databind
* Dependências opcionais:

  * H2 (apenas para testes)
* Dependências proibidas:

  * WebClient / RestTemplate
  * Jsoup / Selenium
  * Feign
* Configuração via:

  * `application.yml`

Declare claramente:

> Qualquer dependência fora desta lista não deve ser utilizada.

---

### 🔹 `.ai/business-rules.md` — Regras de negócio

Documente regras claras:

* Domínio: simulação da API GNews
* Endpoints existentes:

  * `/api/v4/top-headlines`
  * `/api/v4/search`
* Todos os parâmetros devem seguir a documentação oficial
* API Key:

  * Obrigatória
  * Configurada via `application.yml`
* Rate limit:

  * Diário
  * Simulado em memória
* Notícias:

  * Sempre fake
  * Nunca copiadas de fontes reais
* Fontes:

  * Fictícias
  * URLs `.example`
* Imagens:

  * Obrigatórias
  * Exclusivamente de bancos royalty-free:

    * Unsplash
    * Pexels
    * Pixabay
  * Nunca de portais reais

Não inclua código.

---

## ⚠️ Regras finais

* Escreva os documentos pensando em **outro agente**
* Seja específico e direto
* Não use frases genéricas
* Não antecipe implementação

---

## ✅ Entregável

* Pasta `.ai/` criada
* Quatro arquivos preenchidos conforme especificado
* Ao final, apresente:

  * Lista dos arquivos criados
  * Um resumo objetivo de cada documento