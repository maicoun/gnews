# Implementação da API Fake GNews (Java 25)

> Você está operando em **Agent Mode**, com permissão para:
>
> * Criar e editar arquivos
> * Implementar código
> * Ajustar configurações
>
> Atue como um **Senior Java Backend Engineer** responsável pela implementação completa da API.

---

## 📌 Contexto obrigatório (LEITURA INICIAL)

Antes de iniciar qualquer implementação, **leia atentamente** os seguintes arquivos:

```
.ai/standards.md
.ai/architecture.md
.ai/tech-stack.md
.ai/business-rules.md
```

Todas as decisões técnicas, arquiteturais e de negócio **DEVEM** seguir exatamente o que está definido nesses documentos.

⚠️ Se houver conflito entre este prompt e os arquivos `.ai/`, **os arquivos `.ai/` têm prioridade**.

---

## 🎯 Objetivo

Implementar uma **API REST em Java 25 + Spring Boot** que **simule fielmente o contrato e o comportamento da API GNews**, conforme documentação oficial:

[https://docs.gnews.io/](https://docs.gnews.io/)

A aplicação deve ser:

* determinística
* previsível
* consumível por um frontend sem adaptações

---

## 🧩 Escopo funcional (FECHADO)

A API possui **exatamente dois endpoints públicos**:

* `GET /api/v4/top-headlines`
* `GET /api/v4/search`

Ambos devem ser implementados **com todos os parâmetros documentados** na GNews.

Nenhum outro endpoint deve ser criado.

---

## 🛠️ Etapas obrigatórias de implementação

Execute o trabalho **nesta ordem**, sem pular etapas:

### 🔹 Etapa 1 — Estrutura do projeto

* Criar projeto Spring Boot compatível com **Java 25**
* Usar Maven
* Configurar `application.yml`
* Organizar pacotes conforme `.ai/standards.md`

---

### 🔹 Etapa 2 — Domínio e DTOs

* Criar modelos de domínio para notícias e fontes
* Criar DTOs usando `record`
* Garantir imutabilidade
* Garantir serialização compatível com o contrato GNews

---

### 🔹 Etapa 3 — Dataset fake

* Criar um dataset inicial **em memória**
* Mínimo de **50 notícias**
* Variar:

  * categorias
  * idiomas
  * países
  * datas
* Implementar inicialização via componente dedicado (ex: `DataInitializer`)

---

### 🔹 Etapa 4 — Implementação dos endpoints

* Implementar:

  * `/api/v4/top-headlines`
  * `/api/v4/search`
* Implementar filtros:

  * categoria
  * idioma
  * país
  * busca textual
* Implementar paginação (`max`, `page`)
* Implementar ordenação quando aplicável

---

### 🔹 Etapa 5 — API Key e rate limit

* Validar `apikey` em todas as requisições
* Chaves configuradas via `application.yml`
* Simular rate limit diário **em memória**
* Retornar erros apropriados quando excedido

---

### 🔹 Etapa 6 — Tratamento de erros

* Criar modelo de erro consistente
* Usar HTTP status corretos
* Tratar:

  * parâmetros inválidos
  * datas mal formatadas
  * API key ausente ou inválida

---

### 🔹 Etapa 7 — Imagens (OBRIGATÓRIO)

* Cada notícia **DEVE conter uma imagem**
* Usar **exclusivamente URLs públicas** de:

  * Unsplash
  * Pexels
  * Pixabay
* Nunca usar imagens de portais de notícias reais
* Garantir coerência imagem ↔ categoria
* Aspect ratio recomendado: 16:9

---

### 🔹 Etapa 8 — Documentação

* Configurar Swagger / OpenAPI
* Documentar:

  * endpoints
  * parâmetros
  * exemplos de resposta
* Garantir acesso via navegador

---

## 📦 Formato de resposta (OBRIGATÓRIO)

Todas as respostas **DEVEM** seguir o formato da GNews:

```json
{
  "totalArticles": 123,
  "articles": [
    {
      "id": "string",
      "title": "string",
      "description": "string",
      "content": "string",
      "url": "string",
      "image": "string",
      "publishedAt": "2026-02-04T10:00:00Z",
      "lang": "en",
      "source": {
        "id": "string",
        "name": "string",
        "url": "string",
        "country": "us"
      }
    }
  ]
}
```

---

## ✅ Critérios de aceitação

A implementação será considerada concluída quando:

* A aplicação rodar corretamente em **Java 25**
* Os dois endpoints estiverem funcionais
* Todos os parâmetros documentados funcionarem
* Todas as notícias possuírem imagens válidas (royalty-free)
* O contrato da GNews for respeitado
* Swagger estiver acessível

---

## 🔁 Checkpoints obrigatórios

Ao final de **cada etapa**:

* Descreva o que foi feito
* Liste os arquivos criados ou alterados
* Indique claramente o próximo passo

Avance automaticamente apenas se não houver inconsistências evidentes.

---

## 🧠 Observação final

Este projeto é um **mock funcional de API**, não um agregador real de notícias.

O foco é:

* contrato
* previsibilidade
* engenharia de APIs
* uso correto de agentes